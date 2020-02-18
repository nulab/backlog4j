package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for add issue type API.
 *
 * @author nulab-inc
 */
public class AddIssueTypeParams extends PostParams {
    private Object projectIdOrKey;

    public AddIssueTypeParams(Object projectIdOrKey, String name, Project.IssueTypeColor color){
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("color", color.getStrValue()));
        this.projectIdOrKey = projectIdOrKey;
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public AddIssueTypeParams templateSummary(String templateSummary) {
        parameters.add(new NameValuePair("templateSummary", templateSummary));
        return this;
    }

    public AddIssueTypeParams templateDescription(String templateDescription) {
        parameters.add(new NameValuePair("templateDescription", templateDescription));
        return this;
    }
}
