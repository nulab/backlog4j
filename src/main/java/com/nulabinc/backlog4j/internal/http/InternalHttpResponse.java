package com.nulabinc.backlog4j.internal.http;

import com.nulabinc.backlog4j.BacklogException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.mime.MIME;

import java.io.*;

/**
 * @author nulab-inc
 */
public class InternalHttpResponse {
    protected int statusCode;
    protected String responseAsString = null;
    protected InputStream inputStream;
    protected HttpResponse httpResponse;
    private boolean proceedInputStream = false;

    public InternalHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
        statusCode = httpResponse.getStatusLine().getStatusCode();

        try {
            HttpEntity entity = httpResponse.getEntity();
            if(entity != null) {
                inputStream = entity.getContent();
                asString();
            }
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String asString() {
        if (!proceedInputStream && inputStream != null) {
            responseAsString = convertStreamToString(asInputStream());
            proceedInputStream = true;
        }
        return responseAsString;
    }

    public InputStream asInputStream() {
        return inputStream;
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = null;
        StringBuilder sb = null;
        String line = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
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
                is.close();
            } catch (IOException e) {
                throw new BacklogException(e);
            }
        }
        return sb.toString();
    }

    public String getFilenameFromContentDisposition() {
        Header header = httpResponse.getFirstHeader(MIME.CONTENT_DISPOSITION);
        return MimeHelper.decodeContentDispositionFilename(header.getValue());
    }

}
