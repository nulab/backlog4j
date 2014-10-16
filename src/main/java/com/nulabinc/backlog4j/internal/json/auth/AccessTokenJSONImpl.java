package com.nulabinc.backlog4j.internal.json.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Attachment;
import com.nulabinc.backlog4j.auth.AccessToken;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof AccessToken) {
            AccessToken other = (AccessToken)obj;
            result = new EqualsBuilder().append( type, other.getType() )
                    .append( token, other.getToken() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("type", type)
                .append("token", token)
                .append("expires", expires)
                .append("refresh", refresh)
                .toString();
    }
}
