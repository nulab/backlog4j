package com.nulabinc.backlog4j.conf;

import com.nulabinc.backlog4j.auth.AccessToken;
import com.nulabinc.backlog4j.auth.OAuthSupport;
import com.nulabinc.backlog4j.auth.OnAccessTokenRefreshListener;

/**
 * @author nulab-inc
 */
public abstract class BacklogConfigure {

    protected AccessToken accessToken;
    protected String apiKey;
    protected int connectionTimeout = 30000;
    protected int readTimeout = 30000;
    protected OAuthSupport oAuthSupport;
    protected OnAccessTokenRefreshListener listener;

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

    public void setOnAccessTokenRefreshListener(OAuthSupport oAuthSupport, OnAccessTokenRefreshListener listener) {
        this.listener = listener;
        this.oAuthSupport = oAuthSupport;
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

    public OAuthSupport getOAuthSupport() {
        return oAuthSupport;
    }

    public OnAccessTokenRefreshListener getOnAccessTokenRefreshListener() {
        return listener;
    }

    public abstract String getOAuthAuthorizationURL();

    public abstract String getOAuthAccessTokenURL();

    public abstract String getRestBaseURL();


}
