package com.nulabinc.backlog4j.http.httpclient;

import com.nulabinc.backlog4j.conf.BacklogConfigure;
import okhttp3.mockwebserver.MockWebServer;

public class MockWebServerBacklogConfigure extends BacklogConfigure {

    private final MockWebServer mockWebServer;

    public MockWebServerBacklogConfigure(final MockWebServer mockWebServer) {
        this.mockWebServer = mockWebServer;
    }

    public String getOAuthAuthorizationURL() {
        return mockWebServer.url("/OAuth2AccessRequest.action").toString();
    }

    public String getOAuthAccessTokenURL() {
        return mockWebServer.url("/api/v2/oauth2/token").toString();
    }

    public String getRestBaseURL() {
        return mockWebServer.url("/api/v2").toString();
    }

    public String getWebAppBaseURL() {
        return mockWebServer.url("").toString();
    }
}
