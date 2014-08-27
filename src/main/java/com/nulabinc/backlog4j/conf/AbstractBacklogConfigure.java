package com.nulabinc.backlog4j.conf;

import com.nulabinc.backlog4j.auth.AccessToken;

/**
 * @author nulab-inc
 */
public abstract class AbstractBacklogConfigure implements BacklogConfigure {

    protected AccessToken accessToken;
    protected String apiKey;
    protected int connectionTimeout = 30000;
    protected int readTimeout = 30000;

    public AbstractBacklogConfigure accessToken(AccessToken accessToken) {
        this.accessToken = accessToken;

        return this;
    }

    public AbstractBacklogConfigure apiKey(String apiKey) {
        this.apiKey = apiKey;

        return this;
    }

    public AbstractBacklogConfigure readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;

        return this;
    }

    public AbstractBacklogConfigure connectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;

        return this;
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public int getReadTimeout() {
        return readTimeout;
    }

    @Override
    public int getConnectionTimeout() {
        return connectionTimeout;
    }


}
