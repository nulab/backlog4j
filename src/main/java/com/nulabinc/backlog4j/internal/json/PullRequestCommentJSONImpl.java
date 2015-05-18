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
public class PullRequestCommentJSONImpl implements PullRequestComment {

    private int id;
    private String content;
    @JsonDeserialize(as= ChangeLogJSONImpl[].class)
    private ChangeLog[] changeLog;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;


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
        PullRequestCommentJSONImpl rhs = (PullRequestCommentJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.content, rhs.content)
                .append(this.changeLog, rhs.changeLog)
                .append(this.createdUser, rhs.createdUser)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(content)
                .append(changeLog)
                .append(createdUser)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("content", content)
                .append("changeLog", changeLog)
                .append("createdUser", createdUser)
                .toString();
    }
}
