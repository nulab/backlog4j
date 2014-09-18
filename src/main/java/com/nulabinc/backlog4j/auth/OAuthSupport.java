package com.nulabinc.backlog4j.auth;

/**
 * @author nulab-inc
 */
public interface OAuthSupport {
    void setOAuthClientId(String clientId, String clientSecret);

    void setOAuthRedirectUrl(String redirectUrl);

    String getOAuthAuthorizationURL();

    AccessToken getOAuthAccessToken(String oauthCode);

    AccessToken refreshOAuthAccessToken();

    void setOnAccessTokenRefreshListener(OnAccessTokenRefreshListener listener);
}

