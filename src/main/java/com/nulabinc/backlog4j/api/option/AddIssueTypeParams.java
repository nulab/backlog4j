package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for add issue type API.
 *
 * @author nulab-inc
 */
public class AddIssueTypeParams extends PostParams {
    private long projectId;
    private String projectKey;

    public AddIssueTypeParams(long projectId, String name, Project.IssueTypeColor color){
        this.projectId = projectId;
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("color", color.getStrValue()));
    }

    public AddIssueTypeParams(String projectKey, String name, Project.IssueTypeColor color){
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("color", color.getStrValue()));
        this.projectKey = projectKey;
    }

    public String getProjectIdOrKeyString() {
        if(projectKey != null){
            return projectKey;
        }else{
            return String.valueOf(projectId);
        }
    }
}
