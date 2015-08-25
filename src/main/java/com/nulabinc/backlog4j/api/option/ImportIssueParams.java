package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * @author nulab-inc
 */
public class ImportIssueParams extends CreateIssueParams {

    /**
     * Constructor
     *
     * @param projectId   the project identifier
     * @param summary     the issue title
     * @param issueTypeId the issue type identifier
     * @param priority    the priority of the issue
     */
    public ImportIssueParams(long projectId, String summary, long issueTypeId, Issue.PriorityType priority) {
        super(projectId, summary, issueTypeId, priority);
    }


    public ImportIssueParams createdUserId(long createdUserId) {
        parameters.add(new NameValuePair("createdUserId", String.valueOf(createdUserId)));
        return this;
    }

    public ImportIssueParams created(String created) {
        parameters.add(new NameValuePair("created", created));
        return this;
    }

    public ImportIssueParams updatedUserId(long updatedUserId) {
        parameters.add(new NameValuePair("updatedUserId", String.valueOf(updatedUserId)));
        return this;

    }

    public ImportIssueParams updated(String updated) {
        parameters.add(new NameValuePair("updated", updated));
        return this;
    }

}
