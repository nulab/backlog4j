package com.nulabinc.backlog4j.conf;

import com.nulabinc.backlog4j.auth.AccessToken;

/**
 * @author nulab-inc
 */
public interface BacklogConfigure {

    String getOAuthAuthorizationURL();

    String getOAuthAccessTokenURL();

    String getRestBaseURL();

    AccessToken getAccessToken();

    String getApiKey();

    int getReadTimeout();

    int getConnectionTimeout();
}
