package com.nulabinc.backlog4j.auth;

import java.io.Serializable;

/**
 * @author nulab-inc
 */
public class AccessToken implements Serializable {

    protected String type;
    protected String token;
    protected Long expires;
    protected String refresh;

    public AccessToken(String token, Long expires, String refresh) {
        this.token = token;
        this.expires = expires;
        this.refresh = refresh;
    }

    public String getToken() {
        return token;
    }

    public Long getExpires() {
        return expires;
    }

    public String getRefresh() {
        return refresh;
    }

    public String getType() {
        return type;
    }
}
