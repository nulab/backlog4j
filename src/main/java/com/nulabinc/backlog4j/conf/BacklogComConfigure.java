package com.nulabinc.backlog4j.conf;

/**
 * @author nulab-inc
 */
public final class BacklogComConfigure extends BacklogConfigure {

    private final String spaceKey;

    public BacklogComConfigure(String spaceKey) {
        if (spaceKey == null) {
            throw new IllegalArgumentException("spaceKey must not be null");
        }
        this.spaceKey = spaceKey;
    }

    @Override
    public String getOAuthAuthorizationURL() {
        return "https://" + spaceKey + ".backlog.com/OAuth2AccessRequest.action";
    }

    @Override
    public String getOAuthAccessTokenURL() {
        return "https://" + spaceKey + ".backlog.com/api/v2/oauth2/token";
    }

    @Override
    public String getRestBaseURL() {
        return "https://" + spaceKey + ".backlog.com/api/v2";
    }

    @Override
    public String getWebAppBaseURL() {
        return "https://" + spaceKey + ".backlog.com";
    }
}
