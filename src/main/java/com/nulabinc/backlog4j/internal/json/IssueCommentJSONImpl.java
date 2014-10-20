package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
public class IssueCommentJSONImpl implements IssueComment {

    private long id;
    private String content;
    @JsonDeserialize(as= ChangeLogJSONImpl[].class)
    private ChangeLog[] changeLog;
    @JsonDeserialize(as= UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;
    @JsonDeserialize(as= StarJSONImpl[].class)
    private Star[] stars;
    @JsonDeserialize(as=NotificationJSONImpl[].class)
    private Notification[] notifications;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public List<ChangeLog> getChangeLog() {
        return Arrays.asList(this.changeLog);
    }

    @Override
    public User getCreatedUser() {
        return this.createdUser;
    }

    @Override
    public Date getCreated() {
        return this.created;
    }

    @Override
    public Date getUpdated() {
        return this.updated;
    }

    @Override
    public List<Star> getStars() {
        return Arrays.asList(this.stars);
    }

    @Override
    public List<Notification> getNotifications() {
        return Arrays.asList(this.notifications);
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
        IssueCommentJSONImpl rhs = (IssueCommentJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.content, rhs.content)
                .append(this.changeLog, rhs.changeLog)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .append(this.updated, rhs.updated)
                .append(this.stars, rhs.stars)
                .append(this.notifications, rhs.notifications)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(content)
                .append(changeLog)
                .append(createdUser)
                .append(created)
                .append(updated)
                .append(stars)
                .append(notifications)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("content", content)
                .append("changeLog", changeLog)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updated", updated)
                .append("stars", stars)
                .append("notifications", notifications)
                .toString();
    }
}
