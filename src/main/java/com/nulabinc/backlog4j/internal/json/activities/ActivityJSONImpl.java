package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.internal.json.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IssueCreatedActivity.class, name = "1"),
        @JsonSubTypes.Type(value = IssueUpdatedActivity.class, name = "2"),
        @JsonSubTypes.Type(value = IssueCommentedActivity.class, name = "3"),
        @JsonSubTypes.Type(value = IssueDeletedActivity.class, name = "4"),
        @JsonSubTypes.Type(value = WikiCreatedActivity.class, name = "5"),
        @JsonSubTypes.Type(value = WikiUpdatedActivity.class, name = "6"),
        @JsonSubTypes.Type(value = WikiDeletedActivity.class, name = "7"),
        @JsonSubTypes.Type(value = FileAddedActivity.class, name = "8"),
        @JsonSubTypes.Type(value = FileUpdatedActivity.class, name = "9"),
        @JsonSubTypes.Type(value = FileDeletedActivity.class, name = "10"),
        @JsonSubTypes.Type(value = SvnCommittedActivity.class, name = "11"),
        @JsonSubTypes.Type(value = GitPushedActivity.class, name = "12"),
        @JsonSubTypes.Type(value = GitRepositoryCreatedActivity.class, name = "13"),
        @JsonSubTypes.Type(value = IssueMultiUpdatedActivity.class, name = "14"),
        @JsonSubTypes.Type(value = ProjectUserAddedActivity.class, name = "15"),
        @JsonSubTypes.Type(value = ProjectUserRemovedActivity.class, name = "16"),
        @JsonSubTypes.Type(value = NotificationAddedActivity.class, name = "17")
})
public abstract class ActivityJSONImpl implements Activity {

    private int id;
    @JsonDeserialize(as=ProjectJSONImpl.class)
    private Project project;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Project getProject() {
        return this.project;
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
        ActivityJSONImpl rhs = (ActivityJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.project, rhs.project)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(project)
                .append(createdUser)
                .append(created)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("project", project)
                .append("createdUser", createdUser)
                .append("created", created)
                .toString();
    }
}
