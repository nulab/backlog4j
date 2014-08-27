package com.nulabinc.backlog4j.conf;

import java.net.MalformedURLException;

/**
 * @author nulab-inc
 */
public class BacklogPackageConfigure extends AbstractBacklogConfigure {

    private String url;
    private String authorizationUrl;
    private String accessTokenUrl;
    private String restBaseUrl;

    public BacklogPackageConfigure(String url) throws MalformedURLException {

        if (url == null) {
            throw new IllegalArgumentException("url must not be null");
        }

        if (url.endsWith("/")) {
            this.url = url;
        } else {
            this.url = url + "/";
        }
    }

    @Override
    public String getOAuthAuthorizationURL() {
        return this.url + "OAuth2AccessRequest.action";
    }

    @Override
    public String getOAuthAccessTokenURL() {
        return this.url + "api/v2/oauth2/token";
    }

    @Override
    public String getRestBaseURL() {
        return this.restBaseUrl = this.url + "api/v2";
    }

}
