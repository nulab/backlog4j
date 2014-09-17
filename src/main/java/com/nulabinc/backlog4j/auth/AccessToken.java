package com.nulabinc.backlog4j.auth;

/**
 * @author nulab-inc
 */
public class AccessToken {

    private String type;
    private String token;
    private Long expires;
    private String refresh;

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
