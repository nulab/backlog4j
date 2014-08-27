package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class NotificationJSONImpl implements Notification {

    private long id;
    private boolean alreadyRead;
    private int reason;
    private boolean resourceAlreadyRead;
    @JsonDeserialize(as=ProjectJSONImpl.class)
    private Project project;
    @JsonDeserialize(as=IssueJSONImpl.class)
    private Issue issue;
    @JsonDeserialize(as=IssueCommentJSONImpl.class)
    private IssueComment comment;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User sender;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User user;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public boolean isAlreadyRead() {
        return alreadyRead;
    }

    @Override
    public int getReason() {
        return reason;
    }

    @Override
    public boolean isResourceAlreadyRead() {
        return resourceAlreadyRead;
    }

    @Override
    public User getSender() {
        return sender;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public Issue getIssue() {
        return issue;
    }

    @Override
    public IssueComment getComment() {
        return comment;
    }

    @Override
    public Date getCreated() {
        return created;
    }
}
