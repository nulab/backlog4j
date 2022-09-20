package com.nulabinc.backlog4j.conf;

import com.nulabinc.backlog4j.auth.AccessToken;

/**
 * @author nulab-inc
 */
public abstract class BacklogConfigure {

    protected AccessToken accessToken;
    protected String apiKey;
    protected int connectionTimeout = 30000;
    protected int readTimeout = 30000;

    public BacklogConfigure accessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public BacklogConfigure apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public BacklogConfigure readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public BacklogConfigure connectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }


    public AccessToken getAccessToken() {
        return accessToken;
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public abstract String getOAuthAuthorizationURL();

    public abstract String getOAuthAccessTokenURL();

    public abstract String getRestBaseURL();

    public abstract String getWebAppBaseURL();

}
