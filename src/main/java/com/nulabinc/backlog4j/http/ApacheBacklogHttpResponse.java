package com.nulabinc.backlog4j.http;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.internal.http.MimeHelper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.mime.MIME;

import java.io.*;

/**
 * @author nulab-inc
 */
public class ApacheBacklogHttpResponse implements BacklogHttpResponse{
    private InputStream inputStream;
    private int statusCode;
    private String responseAsString = null;
    private HttpResponse httpResponse;
    private boolean proceedInputStream = false;

    public ApacheBacklogHttpResponse(HttpResponse httpResponse, ClientConnectionManager clientConnectionManager) {
        this.httpResponse = httpResponse;
        statusCode = httpResponse.getStatusLine().getStatusCode();

        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                inputStream = entity.getContent();
            }
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public InputStream asInputStream(){
        return this.inputStream;
    }

    public String asString() {
        if (!proceedInputStream && inputStream != null) {
            responseAsString = convertStreamToString();
            proceedInputStream = true;
        }
        return responseAsString;
    }

    private String convertStreamToString() {

        BufferedReader reader = null;
        StringBuilder sb = null;
        String line = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

        } catch (UnsupportedEncodingException e) {
            throw new BacklogAPIException(e);
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        } finally {
            try {
                inputStream.close();
                reader.close();
            } catch (IOException e) {
                throw new BacklogAPIException(e);
            }
        }
        return sb.toString();
    }

    public String getFileNameFromContentDisposition() {
        Header header = httpResponse.getFirstHeader(MIME.CONTENT_DISPOSITION);
        if (header == null) return null;
        return MimeHelper.decodeContentDispositionFilename(header.getValue());
    }

}
