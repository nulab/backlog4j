package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.IssueComment;
import com.nulabinc.backlog4j.Notification;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
public class IssueCommentJSONImpl implements IssueComment {

    private long id;
    private String content;
    @JsonIgnore
    private String[] changeLog;
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
    public List<String> getChangeLog() {
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
    public String toString() {
        return "IssueCommentJSONImpl extends " + super.toString();
    }


}
