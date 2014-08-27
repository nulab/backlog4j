package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ViewedIssue;

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
}
