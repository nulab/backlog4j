package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for add version API.
 *
 * @author nulab-inc
 */
public class AddVersionParams extends PostParams {

    private long projectId;
    private String projectKey;

    public AddVersionParams(long projectId, String name) {
        this.projectId = projectId;
        parameters.add(new BasicNameValuePair("name", name));
    }

    public AddVersionParams(String projectKey, String name) {
        this.projectKey = projectKey;
        parameters.add(new BasicNameValuePair("name", name));
    }

    public String getProjectIdOrKeyString() {
        if (projectKey != null) {
            return projectKey;
        } else {
            return String.valueOf(projectId);
        }
    }

    public AddVersionParams description(String description) {
        parameters.add(new BasicNameValuePair("description", description));
        return this;
    }

    public AddVersionParams startDate(String startDate) {
        parameters.add(new BasicNameValuePair("startDate", startDate));
        return this;
    }

    public AddVersionParams releaseDueDate(String releaseDueDate) {
        parameters.add(new BasicNameValuePair("releaseDueDate", releaseDueDate));
        return this;
    }
}
