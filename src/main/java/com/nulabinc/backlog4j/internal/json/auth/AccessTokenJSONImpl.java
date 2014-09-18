package com.nulabinc.backlog4j.internal.json.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.auth.AccessToken;
/**
 * @author nulab-inc
 */
public class AccessTokenJSONImpl extends AccessToken {


    @JsonProperty("token_type")
    private String type;
    @JsonProperty("access_token")
    private String token;
    @JsonProperty("expires_in")
    private Long expires;
    @JsonProperty("refresh_token")
    private String refresh;

    public AccessTokenJSONImpl(){
        super(null, null, null);
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public Long getExpires() {
        return expires;
    }

    @Override
    public String getRefresh() {
        return refresh;
    }

    @Override
    public String getType() {
        return type;
    }
}
