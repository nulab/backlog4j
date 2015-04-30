package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Change;
import com.nulabinc.backlog4j.Comment;
import com.nulabinc.backlog4j.Content;
import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.internal.json.ChangeJSONImpl;
import com.nulabinc.backlog4j.internal.json.CommentJSONImpl;
import com.nulabinc.backlog4j.internal.json.RepositoryJSONImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class PullRequestContent extends Content {

    private long id;
    private long number;
    private String summary;
    private String description;
    @JsonDeserialize(as=CommentJSONImpl.class)
    private Comment comment;
    @JsonDeserialize(as= ChangeJSONImpl[].class)
    private Change[] changes;
    @JsonDeserialize(as=RepositoryJSONImpl.class)
    private Repository repository;

    public long getId() {
        return this.id;
    }

    public long getNumber() {
        return this.number;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public Comment getComment() {
        return comment;
    }

    public List<Change> getChanges() {
        return Arrays.asList(this.changes);
    }

    public Repository getRepository() {
        return repository;
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
        PullRequestContent rhs = (PullRequestContent) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.number, rhs.number)
                .append(this.summary, rhs.summary)
                .append(this.description, rhs.description)
                .append(this.comment, rhs.comment)
                .append(this.changes, rhs.changes)
                .append(this.repository, rhs.repository)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(number)
                .append(summary)
                .append(description)
                .append(comment)
                .append(changes)
                .append(repository)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("keyId", number)
                .append("summary", summary)
                .append("description", description)
                .append("comment", comment)
                .append("changes", changes)
                .append("repository", repository)
                .toString();
    }

}
