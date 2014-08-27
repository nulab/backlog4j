package com.nulabinc.backlog4j.conf;

import java.net.MalformedURLException;

/**
 * @author nulab-inc
 */
public final class BacklogDefaultConfigure extends AbstractBacklogConfigure {

    private final String spaceKey;

    public BacklogDefaultConfigure(String spaceKey) throws MalformedURLException {
        if (spaceKey == null) {
            throw new IllegalArgumentException("spaceKey must not be null");
        }
        this.spaceKey = spaceKey;
    }

    @Override
    public String getOAuthAuthorizationURL() {
        return "https://" + spaceKey + ".backlog.jp/OAuth2AccessRequest.action";
    }

    @Override
    public String getOAuthAccessTokenURL() {
        return "https://" + spaceKey + ".backlog.jp/api/v2/oauth2/token";
    }

    @Override
    public String getRestBaseURL() {
        return "https://" + spaceKey + ".backlog.jp/api/v2";
    }
}
