package com.nulabinc.backlog4j.http;

import com.nulabinc.backlog4j.BacklogAPIException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLDecoder;

/**
 * Created by yuhkim on 2014/10/17.
 */
public class BacklogHttpResponseImpl implements BacklogHttpResponse {
    private HttpURLConnection urlConnection;
    private InputStream inputStream;
    private int statusCode;
    private String responseAsString = null;

    public BacklogHttpResponseImpl(HttpURLConnection urlConnection) {
        try {
            this.urlConnection = urlConnection;
            this.statusCode = urlConnection.getResponseCode();
            this.inputStream = new BufferedInputStream(urlConnection.getInputStream());
        } catch (IOException e) {
            this.inputStream = new BufferedInputStream(urlConnection.getErrorStream());
        }
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
