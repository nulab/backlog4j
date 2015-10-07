package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonDeserialize(as=PullRequestJSONImpl.class)
    private PullRequest pullRequest;
    @JsonDeserialize(as=PullRequestCommentJSONImpl.class)
    private PullRequestComment pullRequestComment;
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
    public String getIdAsString() {
        return String.valueOf(this.id);
    }

    @Override
    public boolean isAlreadyRead() {
        return alreadyRead;
    }

    @Override
    public Reason getReason() {
        return Notification.Reason.valueOf(this.reason);
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
    public PullRequest getPullRequest() {
        return this.pullRequest;
    }

    @Override
    public PullRequestComment getPullRequestComment() {
        return this.pullRequestComment;
    }

    @Override
    public Date getCreated() {
        return created;
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
        NotificationJSONImpl rhs = (NotificationJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.alreadyRead, rhs.alreadyRead)
                .append(this.reason, rhs.reason)
                .append(this.resourceAlreadyRead, rhs.resourceAlreadyRead)
                .append(this.project, rhs.project)
                .append(this.issue, rhs.issue)
                .append(this.comment, rhs.comment)
                .append(this.pullRequest, rhs.pullRequest)
                .append(this.pullRequestComment, rhs.pullRequestComment)
                .append(this.sender, rhs.sender)
                .append(this.user, rhs.user)
                .append(this.created, rhs.created)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(alreadyRead)
                .append(reason)
                .append(resourceAlreadyRead)
                .append(project)
                .append(issue)
                .append(comment)
                .append(pullRequest)
                .append(pullRequestComment)
                .append(sender)
                .append(user)
                .append(created)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("alreadyRead", alreadyRead)
                .append("reason", reason)
                .append("resourceAlreadyRead", resourceAlreadyRead)
                .append("project", project)
                .append("issue", issue)
                .append("comment", comment)
                .append("pullRequest", pullRequest)
                .append("pullRequestComment", pullRequestComment)
                .append("sender", sender)
                .append("user", user)
                .append("created", created)
                .toString();
    }
}
