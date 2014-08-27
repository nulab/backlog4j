package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Category;
import com.nulabinc.backlog4j.Group;
import com.nulabinc.backlog4j.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
public class GroupJSONImpl implements Group {

    private long id;
    private String name;
    @JsonDeserialize(as=UserJSONImpl[].class)
    private User[] members;
    private long displayOrder;

    @JsonDeserialize(as=UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User updatedUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<User> getMembers() {
        return Arrays.asList(members);
    }

    @Override
    public long getDisplayOrder() {
        return displayOrder;
    }

    @Override
    public User getCreatedUser() {
        return createdUser;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public User getUpdatedUser() {
        return updatedUser;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }
}
