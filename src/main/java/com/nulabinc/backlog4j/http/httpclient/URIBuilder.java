package com.nulabinc.backlog4j.http.httpclient;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class URIBuilder {

    private final String uriString;

    private final List<NameValuePair> queries = new ArrayList<>();

    public URIBuilder(String uriString) {
        this.uriString = uriString;
    }

    public URIBuilder addParameter(String name, String value) {
        if (value != null) {
            this.queries.add(new NameValuePair(name, value));
        }
        return this;
    }

    public URI build() throws URISyntaxException {
        final StringBuilder sb = new StringBuilder(this.uriString);
        if (!queries.isEmpty()) {
            final String query = queries.stream()
                    .map(pair -> pair.getName() + "=" + URLEncoder.encode(pair.getValue(), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));
            sb.append("?");
            sb.append(query);
        }
        return new URI(sb.toString());
    }
}

