package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update issue type API.
 *
 * @author nulab-inc
 */
public class UpdateIssueTypeParams extends PatchParams {

    private long projectId;
    private String projectKey;
    private long issueTypeId;

    public UpdateIssueTypeParams(long projectId, long issueTypeId) {
        this.projectId = projectId;
        this.issueTypeId = issueTypeId;
    }

    public UpdateIssueTypeParams(String projectKey, long issueTypeId) {
        this.projectKey = projectKey;
        this.issueTypeId = issueTypeId;
    }

    public String getProjectIdOrKeyString() {
        if (projectKey != null) {
            return projectKey;
        } else {
            return String.valueOf(projectId);
        }
    }

    public UpdateIssueTypeParams name(String name) {
        parameters.add(new NameValuePair("name", name));
        return this;
    }

    public UpdateIssueTypeParams color(Project.IssueTypeColor color) {
        parameters.add(new NameValuePair("color", color.getStrValue()));
        return this;
    }

    public long getIssueTypeId() {
        return issueTypeId;
    }
}
