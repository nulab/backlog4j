package com.nulabinc.backlog4j.http;

import com.nulabinc.backlog4j.AttachmentData;
import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.api.option.GetParams;
import com.nulabinc.backlog4j.api.option.QueryParams;

import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.util.List;
import java.util.Map;

/**
 * @author nulab-inc
 */
public class BacklogHttpClientImpl implements BacklogHttpClient {

    protected static final String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
    protected static final String CHARSET = "UTF-8";
    protected static final String LINE_FEED = "\r\n";
    protected static final String PACKAGE_VERSION = BacklogHttpClientImpl.class.getPackage().getImplementationVersion();
    protected static final String DEFAULT_USER_AGENT = "backlog4j/" + PACKAGE_VERSION;

    protected String userAgent = DEFAULT_USER_AGENT;
    protected String apiKey;
    protected String bearerToken;
    protected int readTimeout;
    protected int connectionTimeout;

    public BacklogHttpClientImpl() {
        final String proxyUser = System.getProperty("https.proxyUser");
        final String proxyPass = System.getProperty("https.proxyPassword");

        if (proxyUser != null && proxyPass != null) {
            Authenticator.setDefault(
                    new Authenticator() {
                        @Override
                        public PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    proxyUser,
                                    proxyPass.toCharArray()
                            );
                        }
                    }
            );
        }
    }

    @Override
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @Override
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    @Override
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    @Override
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }

    @Override
    public String getUserAgent() { return this.userAgent; }

    @Override
    public BacklogHttpResponse get(String endpoint, GetParams getParams, QueryParams queryParams) throws BacklogException {
        String url = getUrl(endpoint);
        boolean paramExists = (apiKey != null);
        if(getParams != null && getParams.getParamList().size() > 0){
            url += getParamsString(paramExists, getParams);
            paramExists = true;
        }
        if(queryParams != null && queryParams.getParamList().size() > 0){
            url += getParamsString(paramExists, queryParams);
        }

        HttpURLConnection urlConnection = openUrlConnection(url, "GET", CONTENT_TYPE);
        return handleResponse(urlConnection);
    }

    public String getParamsString(boolean paramExists, GetParams getParams) {
        StringBuffer sb = new StringBuffer();
        if (!paramExists) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(getDataString(getParams.getParamList()));
        return sb.toString();
    }

    @Override
    public BacklogHttpResponse post(String endpoint, List<NameValuePair> postParams) throws BacklogException {
        String url = getUrl(endpoint);
        HttpURLConnection urlConnection = openUrlConnection(url, "POST", CONTENT_TYPE);
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        writeParams(urlConnection, postParams);
        return handleResponse(urlConnection);
    }

    @Override
    public BacklogHttpResponse patch(String endpoint, List<NameValuePair> patchParams) throws BacklogException {
        String url = getUrl(endpoint);
        HttpURLConnection urlConnection = openUrlConnection(url, "PATCH", CONTENT_TYPE);
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        writeParams(urlConnection, patchParams);
        return handleResponse(urlConnection);
    }

    @Override
    public BacklogHttpResponse put(String endpoint, List<NameValuePair> patchParams) throws BacklogException {
        String url = getUrl(endpoint);
        HttpURLConnection urlConnection = openUrlConnection(url, "PUT", CONTENT_TYPE);
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        writeParams(urlConnection, patchParams);
        return handleResponse(urlConnection);
    }

    @Override
    public BacklogHttpResponse delete(String endpoint, List<NameValuePair> params) throws BacklogException {
        String url = getUrl(endpoint);
        HttpURLConnection urlConnection = openUrlConnection(url, "DELETE", CONTENT_TYPE);
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        writeParams(urlConnection, params);
        return handleResponse(urlConnection);
    }

    @Override
    public BacklogHttpResponse postMultiPart(String endpoint, Map<String, Object> postParams) throws BacklogException {
        String url = getUrl(endpoint);

        String boundary = "*******";
        HttpURLConnection urlConnection = openUrlConnection(url, "POST", "multipart/form-data; boundary=" + boundary);
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);

        writeMultiPartParams(urlConnection, postParams, boundary);
        return handleResponse(urlConnection);
    }


    private String getUrl(String endpoint) {
        if (apiKey != null) {
            return endpoint + "?apiKey=" + apiKey;
        } else {
            return endpoint;
        }
    }

    private HttpURLConnection openUrlConnection(String url, String method, String contentType) {
        HttpURLConnection urlConnection;
        try {
            urlConnection = (HttpURLConnection) new URL(url).openConnection();

            urlConnection.setUseCaches(false);

            urlConnection.setRequestProperty("Connection", "Keep-Alive");
            urlConnection.setRequestProperty("Cache-Control", "no-cache");

            setRequestMethodUsingWorkaroundForJREBug(urlConnection, method);
            urlConnection.setReadTimeout(this.readTimeout);
            urlConnection.setConnectTimeout(this.connectionTimeout);
            urlConnection.setRequestProperty("User-Agent", userAgent);
            urlConnection.setRequestProperty("Content-Type", contentType);

            if (apiKey == null && bearerToken != null) {
                urlConnection.setRequestProperty("Authorization", "Bearer " + bearerToken);
            }

        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
        return urlConnection;
    }

    private void writeParams(HttpURLConnection urlConnection, List<NameValuePair> params) {
        if (params == null || params.size() == 0) return;

        String query = getDataString(params);
        try {
            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            out.write(query.getBytes(CHARSET));
            out.close();
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    private void writeMultiPartParams(HttpURLConnection urlConnection, Map<String, Object> params, String boundary) {
        if (params == null || params.size() == 0) return;

        try {
            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out, "UTF-8")));
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    writer.append("--" + boundary).append(LINE_FEED);
                    writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
                            .append(LINE_FEED);
                    writer.append("Content-Type: text/plain; charset=" + CHARSET).append(LINE_FEED);
                    writer.append(LINE_FEED);
                    writer.append((String) value).append(LINE_FEED);
                    writer.flush();

                } else if (value instanceof AttachmentData) {
                    AttachmentData attachmentData = (AttachmentData) value;
                    String fileName = attachmentData.getFilename();
                    writer.append("--" + boundary).append(LINE_FEED);
                    writer.append("Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + fileName + "\"")
                            .append(LINE_FEED);
                    writer.append("Content-Type: application/octet-stream; charset=" + CHARSET)
                            .append(LINE_FEED);
                    writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
                    writer.append(LINE_FEED);
                    writer.flush();

                    InputStream inputStream = attachmentData.getContent();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    out.flush();
                    inputStream.close();

                    writer.flush();
                } else {
                    throw new BacklogAPIException("Illegal parameter type name=" + name + ",value=" + value);
                }
            }
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            out.close();

        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    private String getDataString(List<NameValuePair> pairs) {
        StringBuffer sb = new StringBuffer();
        boolean first = true;
        for (NameValuePair pair : pairs) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            try {
                sb.append(URLEncoder.encode(pair.getName(), "utf-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(pair.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new BacklogAPIException(e);
            }
        }
        return sb.toString();
    }

    private void setRequestMethodUsingWorkaroundForJREBug(
            final HttpURLConnection httpURLConnection, final String method) {
        try {
            httpURLConnection.setRequestMethod(method);
            // Check whether we are running on a buggy JRE
        } catch (final ProtocolException pe) {
            Class<?> connectionClass = httpURLConnection
                    .getClass();
            Field delegateField = null;
            try {
                delegateField = connectionClass.getDeclaredField("delegate");
                delegateField.setAccessible(true);
                HttpURLConnection delegateConnection = (HttpURLConnection) delegateField
                        .get(httpURLConnection);
                setRequestMethodUsingWorkaroundForJREBug(delegateConnection, method);
            } catch (NoSuchFieldException e) {
                // Ignore for now, keep going
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            try {
                Field methodField;
                while (connectionClass != null) {
                    try {
                        methodField = connectionClass
                                .getDeclaredField("method");
                    } catch (NoSuchFieldException e) {
                        connectionClass = connectionClass.getSuperclass();
                        continue;
                    }
                    methodField.setAccessible(true);
                    methodField.set(httpURLConnection, method);
                    break;
                }
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private BacklogHttpResponse handleResponse(final HttpURLConnection connection) {
        BacklogHttpResponse response = new BacklogHttpResponseImpl(connection);

        return response;
    }
}
