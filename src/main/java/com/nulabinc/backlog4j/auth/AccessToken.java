package com.nulabinc.backlog4j.auth;

/**
 * @author nulab-inc
 */
public interface AccessToken {

    String getType();

    String getToken();

    Long getExpires();

    String getRefresh();
}
