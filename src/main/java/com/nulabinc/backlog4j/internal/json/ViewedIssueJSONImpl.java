package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Version;
import com.nulabinc.backlog4j.ViewedIssue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
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
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof ViewedIssue) {
            ViewedIssue other = (ViewedIssue)obj;
            result = new EqualsBuilder().append( issue.getId(), other.getIssue().getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("issue", issue)
                .append("updated", updated)
                .toString();
    }
}
