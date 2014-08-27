package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for update custom field API.
 *
 * @author nulab-inc
 */
public abstract class UpdateCustomFieldParams extends PatchParams {

    private long projectId;
    private String projectKey;
    private long customFiledId;

    public UpdateCustomFieldParams(long projectId, long customFiledId){
        this.projectId = projectId;
        this.customFiledId = customFiledId;
    }

    public UpdateCustomFieldParams(String projectKey, long customFiledId){
        this.projectKey = projectKey;
        this.customFiledId = customFiledId;
    }

    public String getProjectIdOrKeyString() {
        if(projectKey != null){
            return projectKey;
        }else{
            return String.valueOf(projectId);
        }
    }

    public long getCustomFiledId() {
        return customFiledId;
    }

    public UpdateCustomFieldParams name(String name) {
        parameters.add(new BasicNameValuePair("name", name));
        return this;
    }

    public UpdateCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        for (Long applicableIssueType :applicableIssueTypes) {
            parameters.add(new BasicNameValuePair("applicableIssueTypes[]", String.valueOf(applicableIssueType)));
        }
        return this;
    }

    public UpdateCustomFieldParams description(String description) {
        parameters.add(new BasicNameValuePair("description", description));
        return this;
    }

    public UpdateCustomFieldParams required(boolean required) {
        parameters.add(new BasicNameValuePair("required", String.valueOf(required)));
        return this;
    }
}
