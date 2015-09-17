package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update project API.
 *
 * @author nulab-inc
 */
public class UpdateProjectParams extends PatchParams {
    private long projectId;
    private String projectIdOrKey;

    public UpdateProjectParams(long projectId){
        this.projectId = projectId;
    }
    public UpdateProjectParams(String projectIdOrKey){
        this.projectIdOrKey = projectIdOrKey;
    }

    public String getProjectIdOrKeyString() {
        if(projectIdOrKey != null){
            return projectIdOrKey;
        }else{
            return String.valueOf(projectId);
        }
    }

    public UpdateProjectParams name(String name) {
        parameters.add(new NameValuePair("name", String.valueOf(name)));
        return this;
    }

    public UpdateProjectParams projectKey(String projectKey) {
        parameters.add(new NameValuePair("key", projectKey));
        return this;
    }

    public UpdateProjectParams chartEnabled(boolean chartEnabled) {
        parameters.add(new NameValuePair("chartEnabled", String.valueOf(chartEnabled)));
        return this;
    }

    public UpdateProjectParams subtaskingEnabled(boolean subtaskingEnabled) {
        parameters.add(new NameValuePair("subtaskingEnabled", String.valueOf(subtaskingEnabled)));
        return this;
    }

    public UpdateProjectParams textFormattingRule(Project.TextFormattingRule textFormattingRule) {
        parameters.add(new NameValuePair("textFormattingRule", textFormattingRule.getStrValue()));
        return this;
    }

    public UpdateProjectParams setArchived(boolean archived) {
        parameters.add(new NameValuePair("archived", String.valueOf(archived)));
        return this;
    }
}
