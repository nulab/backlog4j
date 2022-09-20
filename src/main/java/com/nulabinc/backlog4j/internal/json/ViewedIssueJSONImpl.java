package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ViewedIssue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewedIssueJSONImpl implements ViewedIssue {

    @JsonDeserialize(as = IssueJSONImpl.class)
    private Issue issue;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public Issue getIssue() {
        return issue;
    }

    @Override
    public Date getUpdated() {
        return updated;
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
        ViewedIssueJSONImpl rhs = (ViewedIssueJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.issue, rhs.issue)
                .append(this.updated, rhs.updated)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(issue)
                .append(updated)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("issue", issue)
                .append("updated", updated)
                .toString();
    }
}
