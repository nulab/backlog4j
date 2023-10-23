package com.nulabinc.backlog4j.http.httpclient;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;

import java.io.*;
import java.net.URLDecoder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;

class HttpClientBacklogHttpResponse implements BacklogHttpResponse {

    private final HttpResponse<InputStream> response;
    private final int statusCode;
    private final int rateLimitLimit;
    private final int rateLimitRemaining;
    private final String rateLimitReset;
    private final Date rateLimitResetDate;

    public HttpClientBacklogHttpResponse(final HttpResponse<InputStream> response) {
        this.response = response;
        this.statusCode = response.statusCode();
        this.rateLimitLimit = getHeaderValueAsInt(response, "X-RateLimit-Limit");
        this.rateLimitRemaining = getHeaderValueAsInt(response, "X-RateLimit-Remaining");
        this.rateLimitReset = getHeaderValueOrNull(response, "X-RateLimit-Reset");
        this.rateLimitResetDate = toRateLimitResetDate(this.rateLimitReset);
    }

    private String getHeaderValueOrNull(final HttpResponse<?> response, final String name) {
        return response.headers().firstValue(name).orElse(null);
    }

    private int getHeaderValueAsInt(final HttpResponse<?> response, final String name) {
        final String value = getHeaderValueOrNull(response, name);
        if (value == null) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            return 0;
        }
    }

    private Date toRateLimitResetDate(String rateLimitReset) {
        if (isBlank(rateLimitReset)) {
            return null;
        }
        try {
            return new Date(Long.parseLong(rateLimitReset) * 1000);
        } catch (Exception e) {
            // do nothing
        }
        return null;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public int getRateLimitLimit() {
        return this.rateLimitLimit;
    }

    @Override
    public int getRateLimitRemaining() {
        return this.rateLimitRemaining;
    }

    @Override
    public Date getRateLimitResetDate() {
        return this.rateLimitResetDate;
    }

    @Override
    public String getRateLimitReset() {
        return this.rateLimitReset;
    }

    @Override
    public InputStream asInputStream() {
        return this.response.body();
    }

    @Override
    public String asString() {
        try (final InputStream inputStream = this.asInputStream()) {
            return inputStreamToString(inputStream);
        } catch (final IOException e) {
            // ignore
            return null;
        }
    }

    private String inputStreamToString(final InputStream inputStream) {
        try (final InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             final BufferedReader reader = new BufferedReader(inputStreamReader)) {
            final StringBuilder sb = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (final IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public String getFileNameFromContentDisposition() {
        final String disposition = getHeaderValueOrNull(this.response, "Content-Disposition");
        if (disposition != null) {
            final String encode = disposition.substring(disposition.indexOf("=") + 1, disposition.indexOf("''"));
            final String fileName = disposition.substring(disposition.indexOf("''") + 2);
            try {
                return URLDecoder.decode(fileName, encode);
            } catch (UnsupportedEncodingException e) {
                throw new BacklogAPIException(e);
            }
        }
        return null;
    }

    private static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

        }
        return true;
    }
}
