package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class UserJSONImpl implements User {

    private long id;
    private String name;
    private String userId;
    private int roleType;
    private String lang;
    private String mailAddress;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public RoleType getRoleType() {
        return RoleType.valueOf(roleType);
    }

    @Override
    public String getLang() {
        return this.lang;
    }

    @Override
    public String getMailAddress() {
        return this.mailAddress;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof User ) {
            User other = (User)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("userId", userId)
                .append("roleType", roleType)
                .append("lang", lang)
                .append("mailAddress", mailAddress)
                .toString();
    }
}
