package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Parameters for import update issue API.
 *
 * @author nulab-inc
 */
public class ImportUpdateIssueParams extends UpdateIssueParams {

    public ImportUpdateIssueParams(long issueId) {
        super(issueId);
    }

    public ImportUpdateIssueParams(String issueKey) {
        super(issueKey);
    }

    public ImportUpdateIssueParams createdUserId(long createdUserId) {
        parameters.add(new NameValuePair("createdUserId", String.valueOf(createdUserId)));
        return this;
    }

    public ImportUpdateIssueParams created(String created) {
        parameters.add(new NameValuePair("created", created));
        return this;
    }

    public ImportUpdateIssueParams updatedUserId(long updatedUserId) {
        parameters.add(new NameValuePair("updatedUserId", String.valueOf(updatedUserId)));
        return this;

    }

    public ImportUpdateIssueParams updated(String updated) {
        parameters.add(new NameValuePair("updated", updated));
        return this;
    }

}
