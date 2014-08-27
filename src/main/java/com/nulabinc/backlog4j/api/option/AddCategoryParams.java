package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for add category API.
 *
 * @author nulab-inc
 */
public class AddCategoryParams extends PostParams {

    private long projectId;
    private String projectKey;

    /**
     * Constructor
     *
     * @param projectId the project identifier
     * @param name      the category name
     */
    public AddCategoryParams(long projectId, String name) {
        this.projectId = projectId;
        parameters.add(new BasicNameValuePair("name", name));
    }

    /**
     * Constructor
     *
     * @param projectKey the project identifier
     * @param name       the category name
     */
    public AddCategoryParams(String projectKey, String name) {
        this.projectKey = projectKey;
        parameters.add(new BasicNameValuePair("name", name));
    }

    /**
     * Returns the project identifier string.
     *
     * @return project id or project key
     */
    public String getProjectIdOrKeyString() {
        if (projectKey != null) {
            return projectKey;
        } else {
            return String.valueOf(projectId);
        }
    }
}
