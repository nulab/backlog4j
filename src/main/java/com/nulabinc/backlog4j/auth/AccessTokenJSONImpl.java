package com.nulabinc.backlog4j.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author nulab-inc
 */
public class AccessTokenJSONImpl implements AccessToken{

    @JsonProperty("token_type")
    private String type;
    @JsonProperty("access_token")
    private String token;
    @JsonProperty("expires_in")
    private Long expires;
    @JsonProperty("refresh_token")
    private String refresh;

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
