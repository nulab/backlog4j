package com.nulabinc.backlog4j.http;

import com.nulabinc.backlog4j.BacklogAPIException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.util.Date;

/**
 * @author nulab-inc
 */
public class BacklogHttpResponseImpl implements BacklogHttpResponse {
    protected HttpURLConnection urlConnection;
    protected InputStream inputStream;
    protected int statusCode;
    protected String responseAsString = null;
    protected int rateLimitLimit;
    protected int rateLimitRemaining;
    protected Date rateLimitResetDate = null;
    protected String rateLimitReset = null;

    public BacklogHttpResponseImpl(HttpURLConnection urlConnection) {
        try {
            this.urlConnection = urlConnection;
            this.statusCode = urlConnection.getResponseCode();
            if (this.statusCode < 400) {
                this.inputStream = new BufferedInputStream(urlConnection.getInputStream());
            } else {
                this.inputStream = new BufferedInputStream(urlConnection.getErrorStream());
            }
            try {
                rateLimitLimit = Integer.parseInt(urlConnection.getHeaderField("X-RateLimit-Limit"));
                rateLimitRemaining = Integer.parseInt(urlConnection.getHeaderField("X-RateLimit-Remaining"));
            } catch (Exception e) {
            }
            rateLimitReset = urlConnection.getHeaderField("X-RateLimit-Reset");
            setRateLimitResetDate(rateLimitReset);
        } catch (IOException e) {
            this.inputStream = new BufferedInputStream(urlConnection.getErrorStream());
        }
    }

    public int getRateLimitLimit() {
        return rateLimitLimit;
    }

    public int getRateLimitRemaining() {
        return rateLimitRemaining;
    }

    public String getRateLimitReset() {
        return rateLimitReset;
    }

    private void setRateLimitResetDate(String rateLimitReset) {
        if (StringUtils.isBlank(rateLimitReset)) {
            return;
        }
        try {
            rateLimitResetDate = new Date(Long.parseLong(rateLimitReset)*1000);
        } catch (Exception e) {
        }
    }

    public Date getRateLimitResetDate() {
        return rateLimitResetDate;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public InputStream asInputStream() {
        return this.inputStream;
    }

    public String asString() {
        if (responseAsString == null && inputStream != null) {
            responseAsString = convertStreamToString();
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
        String disposition = this.urlConnection.getHeaderField("Content-Disposition");
        if (disposition != null) {
            String encode = disposition.substring(disposition.indexOf("=")+1,disposition.indexOf("''"));
            String fileName = disposition.substring(disposition.indexOf("''")+2);
            if(encode != null){
                try {
                    return URLDecoder.decode(fileName, encode);
                } catch (UnsupportedEncodingException e) {
                    throw new BacklogAPIException(e);
                }
            }else{
                return fileName;
            }
        }

        return null;
    }
}
