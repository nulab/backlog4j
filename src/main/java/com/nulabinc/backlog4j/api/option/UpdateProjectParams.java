package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for update project API.
 *
 * @author nulab-inc
 */
public class UpdateProjectParams extends PatchParams {
    private long projectId;
    private String projectKey;

    public UpdateProjectParams(long projectId){
        this.projectId = projectId;
    }
    public UpdateProjectParams(String projectKey){
        this.projectKey = projectKey;
    }

    public String getProjectIdOrKeyString() {
        if(projectKey != null){
            return projectKey;
        }else{
            return String.valueOf(projectId);
        }
    }

    public UpdateProjectParams name(String name) {
        parameters.add(new BasicNameValuePair("name", String.valueOf(name)));
        return this;
    }

    public UpdateProjectParams projectKey(String projectKey) {
        parameters.add(new BasicNameValuePair("key", projectKey));
        return this;
    }

    public UpdateProjectParams chartEnabled(boolean chartEnabled) {
        parameters.add(new BasicNameValuePair("chartEnabled", String.valueOf(chartEnabled)));
        return this;
    }

    public UpdateProjectParams subtaskingEnabled(boolean subtaskingEnabled) {
        parameters.add(new BasicNameValuePair("subtaskingEnabled", String.valueOf(subtaskingEnabled)));
        return this;
    }

    public UpdateProjectParams textFormattingRule(Project.TextFormattingRule textFormattingRule) {
        parameters.add(new BasicNameValuePair("textFormattingRule", textFormattingRule.getStrValue()));
        return this;
    }

    public UpdateProjectParams setArchived(boolean archived) {
        parameters.add(new BasicNameValuePair("archived", String.valueOf(archived)));
        return this;
    }
}
