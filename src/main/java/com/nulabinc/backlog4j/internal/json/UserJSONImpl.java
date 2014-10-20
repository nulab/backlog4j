package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
        UserJSONImpl rhs = (UserJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .append(this.userId, rhs.userId)
                .append(this.roleType, rhs.roleType)
                .append(this.lang, rhs.lang)
                .append(this.mailAddress, rhs.mailAddress)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(userId)
                .append(roleType)
                .append(lang)
                .append(mailAddress)
                .toHashCode();
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
