package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import org.apache.http.message.BasicNameValuePair;

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
        parameters.add(new BasicNameValuePair("name", name));
        parameters.add(new BasicNameValuePair("color", color.getStrValue()));
    }

    public AddIssueTypeParams(String projectKey, String name, Project.IssueTypeColor color){
        parameters.add(new BasicNameValuePair("name", name));
        parameters.add(new BasicNameValuePair("color", color.getStrValue()));
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
