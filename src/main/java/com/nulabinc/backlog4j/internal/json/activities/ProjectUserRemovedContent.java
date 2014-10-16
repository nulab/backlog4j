package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.internal.json.GroupProjectActivityJSONImpl;
import com.nulabinc.backlog4j.internal.json.UserJSONImpl;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class ProjectUserRemovedContent extends Content {


    @JsonDeserialize(as=UserJSONImpl[].class)
    private User[] users;
    private String comment;
    @JsonProperty("group_project_activities")
    @JsonDeserialize(as=GroupProjectActivityJSONImpl[].class)
    private GroupProjectActivity[] groupProjectActivities;

    public List<User> getUsers() {
        return Arrays.asList(users);
    }

    public String getComment() {
        return comment;
    }

    public List<GroupProjectActivity> getGroupProjectActivities() {
        return Arrays.asList(groupProjectActivities);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("users", users)
                .append("comment", comment)
                .append("groupProjectActivities", groupProjectActivities)
                .toString();
    }
}
