package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.internal.json.GroupProjectActivityJSONImpl;
import com.nulabinc.backlog4j.internal.json.UserJSONImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
        ProjectUserRemovedContent rhs = (ProjectUserRemovedContent) obj;
        return new EqualsBuilder()
                .append(this.users, rhs.users)
                .append(this.comment, rhs.comment)
                .append(this.groupProjectActivities, rhs.groupProjectActivities)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(users)
                .append(comment)
                .append(groupProjectActivities)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("users", users)
                .append("comment", comment)
                .append("groupProjectActivities", groupProjectActivities)
                .toString();
    }
}
