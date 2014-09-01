package com.nulabinc.backlog4j.internal.http;

import com.nulabinc.backlog4j.BacklogException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.mime.MIME;
import org.apache.http.util.EntityUtils;

import java.io.*;

/**
 * @author nulab-inc
 */
public class InternalHttpResponse {
    private HttpInputStream httpInputStream;
    private int statusCode;
    private String responseAsString = null;
    private HttpResponse httpResponse;
    private boolean proceedInputStream = false;

    public InternalHttpResponse(HttpResponse httpResponse, ClientConnectionManager clientConnectionManager) {
        this.httpResponse = httpResponse;
        statusCode = httpResponse.getStatusLine().getStatusCode();

        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                httpInputStream = new HttpInputStream(entity.getContent(), clientConnectionManager);
            }
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public InputStream asInputStream(){
        return this.httpInputStream;
    }

    public String asString() {
        if (!proceedInputStream && httpInputStream != null) {
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
            reader = new BufferedReader(new InputStreamReader(httpInputStream, "utf-8"));
            sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

        } catch (UnsupportedEncodingException e) {
            throw new BacklogException(e);
        } catch (IOException e) {
            throw new BacklogException(e);
        } finally {
            try {
                httpInputStream.close();
                reader.close();
            } catch (IOException e) {
                throw new BacklogException(e);
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
