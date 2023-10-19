package com.nulabinc.backlog4j.http.httpclient;

import com.nulabinc.backlog4j.AttachmentData;
import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.api.option.GetParams;
import com.nulabinc.backlog4j.api.option.QueryParams;
import com.nulabinc.backlog4j.http.BacklogHttpClient;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class HttpClientBacklogHttpClient implements BacklogHttpClient {

    private static final String PACKAGE_VERSION = Objects.requireNonNullElse(HttpClientBacklogHttpClient.class.getPackage().getImplementationVersion(), "-");

    private static final String DEFAULT_USER_AGENT = "backlog4j/" + PACKAGE_VERSION;

    private final HttpClient.Builder httpClientBuilder;

    private HttpClient httpClient = null;

    private String userAgent = DEFAULT_USER_AGENT;

    private String apiKey;

    private String bearerToken;

    private int connectionTimeout;

    private int readTimeout;

    public HttpClientBacklogHttpClient() {
        this(HttpClient.newBuilder());
    }

    public HttpClientBacklogHttpClient(final HttpClient.Builder httpClientBuilder) {
        this.httpClientBuilder = httpClientBuilder;
    }

    @Override
    public void setApiKey(final String apiKey) {
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
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String getUserAgent() {
        return this.userAgent;
    }

    @Override
    public BacklogHttpResponse get(final String endpoint, final GetParams getParams, final QueryParams queryParams) throws BacklogException {
        try {
            final HttpClient httpClient = getHttpClient();
            final URIBuilder uriBuilder = new URIBuilder(endpoint)
                    .addParameter("apiKey", this.apiKey);
            if (getParams != null) {
                getParams.getParamList().forEach(param -> uriBuilder.addParameter(param.getName(), param.getValue()));
            }
            if (queryParams != null) {
                queryParams.getParamList().forEach(param -> uriBuilder.addParameter(param.getName(), param.getValue()));
            }
            final HttpRequest request = newHttpRequestBuilder()
                    .uri(uriBuilder.build())
                    .GET()
                    .build();
            final HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return new HttpClientBacklogHttpResponse(response);
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(e);
        } catch (final IOException | InterruptedException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public BacklogHttpResponse post(final String endpoint, final List<NameValuePair> postParams, final List<NameValuePair> headers) throws BacklogException {
        try {
            final HttpClient httpClient = getHttpClient();
            final URIBuilder uriBuilder = new URIBuilder(endpoint)
                    .addParameter("apiKey", this.apiKey);
            final HttpRequest request = newHttpRequestBuilder(headers)
                    .uri(uriBuilder.build())
                    .POST(buildForm(postParams))
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .build();
            final HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return new HttpClientBacklogHttpResponse(response);
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(e);
        } catch (final IOException | InterruptedException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public BacklogHttpResponse patch(final String endpoint, final List<NameValuePair> patchParams, final List<NameValuePair> headers) throws BacklogException {
        try {
            final HttpClient httpClient = getHttpClient();
            final URIBuilder uriBuilder = new URIBuilder(endpoint)
                    .addParameter("apiKey", this.apiKey);
            final HttpRequest request = newHttpRequestBuilder(headers)
                    .uri(uriBuilder.build())
                    .method("PATCH", buildForm(patchParams))
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .build();
            final HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return new HttpClientBacklogHttpResponse(response);
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(e);
        } catch (final IOException | InterruptedException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public BacklogHttpResponse put(final String endpoint, final List<NameValuePair> putParams) throws BacklogException {
        try {
            final HttpClient httpClient = getHttpClient();
            final URIBuilder uriBuilder = new URIBuilder(endpoint)
                    .addParameter("apiKey", this.apiKey);
            final HttpRequest request = newHttpRequestBuilder()
                    .uri(uriBuilder.build())
                    .PUT(buildForm(putParams))
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .build();
            final HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return new HttpClientBacklogHttpResponse(response);
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(e);
        } catch (final IOException | InterruptedException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public BacklogHttpResponse delete(final String endpoint, final List<NameValuePair> deleteParams) throws BacklogException {
        try {
            final HttpClient httpClient = getHttpClient();
            final URIBuilder uriBuilder = new URIBuilder(endpoint)
                    .addParameter("apiKey", this.apiKey);
            final HttpRequest request = newHttpRequestBuilder()
                    .uri(uriBuilder.build())
                    .method("DELETE", buildForm(deleteParams))
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .build();
            final HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return new HttpClientBacklogHttpResponse(response);
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(e);
        } catch (final IOException | InterruptedException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public BacklogHttpResponse postMultiPart(final String endpoint, final Map<String, Object> postParams) throws BacklogException {
        try {
            final HttpClient httpClient = getHttpClient();
            final URIBuilder uriBuilder = new URIBuilder(endpoint)
                    .addParameter("apiKey", this.apiKey);
            final String boundary = "*******";
            final byte[] data = toByteArray(postParams, boundary);
            final HttpRequest request = newHttpRequestBuilder()
                    .uri(uriBuilder.build())
                    .POST(HttpRequest.BodyPublishers.ofByteArray(data))
                    .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                    .build();
            final HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            return new HttpClientBacklogHttpResponse(response);
        } catch (final URISyntaxException e) {
            throw new IllegalArgumentException(e);
        } catch (final IOException | InterruptedException e) {
            throw new BacklogAPIException(e);
        }
    }

    private byte[] toByteArray(final Map<String, Object> params, final String boundary) {
        if (params == null || params.isEmpty()) {
            return null;
        }

        try (final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(8192);
             final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
             final PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8)))) {
            for (final Map.Entry<String, Object> entry : params.entrySet()) {
                final String name = entry.getKey();
                final Object value = entry.getValue();
                if (value instanceof String) {
                    writeStringBoundary(boundary, writer, name, value.toString());
                } else if (value instanceof AttachmentData) {
                    writeAttachmentBoundary(boundary, bufferedOutputStream, writer, name, (AttachmentData) value);
                } else {
                    throw new BacklogAPIException("Illegal parameter type name=" + name + ",value=" + value);
                }
            }
            writer.append("\r\n").flush();
            writer.append("--").append(boundary).append("--").append("\r\n");
            writer.flush();

            return outputStream.toByteArray();
        } catch (final IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    private void writeStringBoundary(final String boundary, final PrintWriter writer, final String name, final String value) {
        writer.append("--").append(boundary).append("\r\n");
        writer.append("Content-Disposition: form-data; name=\"").append(name).append("\"").append("\r\n");
        writer.append("Content-Type: text/plain; charset=UTF-8").append("\r\n");
        writer.append("\r\n");
        writer.append(value).append("\r\n");
        writer.flush();
    }

    private void writeAttachmentBoundary(final String boundary, final OutputStream outputStream, final PrintWriter writer, final String name, final AttachmentData attachmentData) throws IOException {
        final String fileName = attachmentData.getFilename();
        writer.append("--").append(boundary).append("\r\n");
        writer.append("Content-Disposition: form-data; name=\"").append(name).append("\"; filename=\"").append(fileName).append("\"").append("\r\n");
        writer.append("Content-Type: application/octet-stream; charset=UTF-8").append("\r\n");
        writer.append("Content-Transfer-Encoding: binary").append("\r\n");
        writer.append("\r\n");
        writer.flush();

        try (final InputStream inputStream = attachmentData.getContent()) {
            final byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        }
        writer.flush();
    }

    private HttpRequest.Builder newHttpRequestBuilder() {
        return newHttpRequestBuilder(null);
    }

    private HttpRequest.Builder newHttpRequestBuilder(final List<NameValuePair> headers) {
        final HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .timeout(Duration.ofMillis(this.readTimeout))
                .header("Cache-Control", "no-cache")
                .header("User-Agent", this.userAgent);
        if (this.apiKey == null && this.bearerToken != null) {
            requestBuilder.header("Authorization", "Bearer " + bearerToken);
        }
        if (headers != null) {
            headers.forEach(header -> requestBuilder.header(header.getName(), header.getValue()));
        }
        return requestBuilder;
    }

    private HttpRequest.BodyPublisher buildForm(final List<NameValuePair> params) {
        return HttpRequest.BodyPublishers.ofString(params
                .stream()
                .map(param -> param.getName() + "=" + URLEncoder.encode(param.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&")));
    }

    private HttpClient getHttpClient() {
        if (this.httpClient != null) {
            return this.httpClient;
        }
        synchronized (this) {
            if (this.httpClient != null) {
                return this.httpClient;
            }
            this.httpClient = this.httpClientBuilder
                    .connectTimeout(Duration.ofMillis(this.connectionTimeout))
                    .build();
            return this.httpClient;
        }
    }
}
