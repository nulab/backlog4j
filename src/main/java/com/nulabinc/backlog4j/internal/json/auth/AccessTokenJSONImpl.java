package com.nulabinc.backlog4j.internal.json.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.auth.AccessToken;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessTokenJSONImpl extends AccessToken {


    @JsonProperty("token_type")
    private String type;
    @JsonProperty("access_token")
    private String token;
    @JsonProperty("expires_in")
    private Long expires;
    @JsonProperty("refresh_token")
    private String refresh;

    public AccessTokenJSONImpl() {
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        AccessTokenJSONImpl rhs = (AccessTokenJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.type, rhs.type)
                .append(this.token, rhs.token)
                .append(this.expires, rhs.expires)
                .append(this.refresh, rhs.refresh)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(type)
                .append(token)
                .append(expires)
                .append(refresh)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("token", token)
                .append("expires", expires)
                .append("refresh", refresh)
                .toString();
    }
}
