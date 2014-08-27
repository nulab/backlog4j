package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.User;

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


}
