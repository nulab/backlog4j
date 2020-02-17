package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update issue type API.
 *
 * @author nulab-inc
 */
public class UpdateIssueTypeParams extends PatchParams {

    private Object projectIdOrKey;
    private Object issueTypeId;

    public UpdateIssueTypeParams(Object projectIdOrKey, Object issueTypeId) {
        this.projectIdOrKey = projectIdOrKey;
        this.issueTypeId = issueTypeId;
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public UpdateIssueTypeParams name(String name) {
        parameters.add(new NameValuePair("name", name));
        return this;
    }

    public UpdateIssueTypeParams color(Project.IssueTypeColor color) {
        parameters.add(new NameValuePair("color", color.getStrValue()));
        return this;
    }

    public String getIssueTypeId() {
        return issueTypeId.toString();
    }

    public UpdateIssueTypeParams templateSummary(String templateSummary) {
        parameters.add(new NameValuePair("templateSummary", templateSummary));
        return this;
    }

    public UpdateIssueTypeParams templateDescription(String templateDescription) {
        parameters.add(new NameValuePair("templateDescription", templateDescription));
        return this;
    }
}
