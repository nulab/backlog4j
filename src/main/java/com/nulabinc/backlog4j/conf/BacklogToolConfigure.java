package com.nulabinc.backlog4j.conf;

import java.net.MalformedURLException;

/**
 * @author nulab-inc
 */
public class BacklogToolConfigure extends AbstractBacklogConfigure {

    private final String spaceKey;

    public BacklogToolConfigure(String spaceKey) throws MalformedURLException {
        if (spaceKey == null) {
            throw new IllegalArgumentException("spaceKey must not be null");
        }
        this.spaceKey = spaceKey;
    }

    @Override
    public String getOAuthAuthorizationURL() {
        return "https://" + spaceKey + ".backlogtool.com/OAuth2AccessRequest.action";
    }

    @Override
    public String getOAuthAccessTokenURL() {
        return "https://" + spaceKey + ".backlogtool.com/api/v2/oauth2/token";
    }

    @Override
    public String getRestBaseURL() {
        return "https://" + spaceKey + ".backlogtool.com/api/v2";
    }
}
