package com.nulabinc.backlog4j.conf;

/**
 * @author nulab-inc
 */
public class BacklogPackageConfigure extends BacklogConfigure {

    private String url;

    public BacklogPackageConfigure(String url) {

        if (url == null) {
            throw new IllegalArgumentException("url must not be null");
        }

        if (url.endsWith("/")) {
            this.url = url.substring(0, url.length() - 1);
        } else {
            this.url = url;
        }
    }

    @Override
    public String getOAuthAuthorizationURL() {
        return this.url + "/OAuth2AccessRequest.action";
    }

    @Override
    public String getOAuthAccessTokenURL() {
        return this.url + "/api/v2/oauth2/token";
    }

    @Override
    public String getRestBaseURL() {
        return this.url + "/api/v2";
    }

    @Override
    public String getWebAppBaseURL() {
        return this.url;
    }

}
