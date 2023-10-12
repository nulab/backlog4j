package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestJSONImpl implements PullRequest {

    private int id;
    private long projectId;
    private long repositoryId;
    private long number;
    private String summary;
    private String description;
    private String base;
    private String branch;
    @JsonDeserialize(as = PullRequestStatusJSONImpl.class)
    private PullRequestStatus status;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User assignee;
    @JsonDeserialize(as = IssueJSONImpl.class)
    private Issue issue;
    private String mergeCommit;
    private String baseCommit;
    private String branchCommit;
    private String closeAt;
    private String mergeAt;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User updatedUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;
    @JsonDeserialize(as = AttachmentJSONImpl[].class)
    private Attachment[] attachments;
    @JsonDeserialize(as = StarJSONImpl[].class)
    private Star[] stars;


    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(this.id);
    }

    @Override
    public long getProjectId() {
        return this.projectId;
    }

    @Override
    public String getProjectIdAsString() {
        return String.valueOf(this.projectId);
    }

    @Override
    public long getRepositoryId() {
        return this.repositoryId;
    }

    @Override
    public String getRepositoryIdAsString() {
        return String.valueOf(this.repositoryId);
    }

    @Override
    public long getNumber() {
        return this.number;
    }

    @Override
    public String getSummary() {
        return this.summary;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getBase() {
        return this.base;
    }

    @Override
    public String getBranch() {
        return this.branch;
    }

    @Override
    public PullRequestStatus getStatus() {
        return this.status;
    }

    @Override
    public User getAssignee() {
        return this.assignee;
    }

    @Override
    public Issue getIssue() {
        return this.issue;
    }

    @Override
    public String getMergeCommit() {
        return this.mergeCommit;
    }

    @Override
    public String getBaseCommit() {
        return this.baseCommit;
    }

    @Override
    public String getBranchCommit() {
        return this.branchCommit;
    }

    @Override
    public String getCloseAt() {
        return this.closeAt;
    }

    @Override
    public String getMergeAt() {
        return this.mergeAt;
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
    public User getUpdatedUser() {
        return this.updatedUser;
    }

    @Override
    public Date getUpdated() {
        return this.updated;
    }

    @Override
    public List<Attachment> getAttachments() {
        if (attachments == null || attachments.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(attachments);
    }

    @Override
    public List<Star> getStars() {
        if (stars == null || stars.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(stars);
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
        PullRequestJSONImpl rhs = (PullRequestJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.projectId, rhs.projectId)
                .append(this.repositoryId, rhs.repositoryId)
                .append(this.number, rhs.number)
                .append(this.summary, rhs.summary)
                .append(this.description, rhs.description)
                .append(this.base, rhs.base)
                .append(this.branch, rhs.branch)
                .append(this.status, rhs.status)
                .append(this.assignee, rhs.assignee)
                .append(this.issue, rhs.issue)
                .append(this.mergeCommit, rhs.mergeCommit)
                .append(this.baseCommit, rhs.baseCommit)
                .append(this.branchCommit, rhs.branchCommit)
                .append(this.closeAt, rhs.closeAt)
                .append(this.mergeAt, rhs.mergeAt)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .append(this.updatedUser, rhs.updatedUser)
                .append(this.updated, rhs.updated)
                .append(this.attachments, rhs.attachments)
                .append(this.stars, rhs.stars)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(projectId)
                .append(repositoryId)
                .append(number)
                .append(summary)
                .append(description)
                .append(base)
                .append(branch)
                .append(status)
                .append(assignee)
                .append(issue)
                .append(mergeCommit)
                .append(baseCommit)
                .append(branchCommit)
                .append(closeAt)
                .append(mergeAt)
                .append(createdUser)
                .append(created)
                .append(updatedUser)
                .append(updated)
                .append(attachments)
                .append(stars)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("projectId", projectId)
                .append("repositoryId", repositoryId)
                .append("number", number)
                .append("summary", summary)
                .append("description", description)
                .append("base", base)
                .append("branch", branch)
                .append("status", status)
                .append("assignee", assignee)
                .append("issue", issue)
                .append("mergeCommit", mergeCommit)
                .append("baseCommit", baseCommit)
                .append("branchCommit", branchCommit)
                .append("closeAt", closeAt)
                .append("mergeAt", mergeAt)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updatedUser", updatedUser)
                .append("updated", updated)
                .append("attachments", attachments)
                .append("stars", stars)
                .toString();
    }
}
