package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for add category API.
 *
 * @author nulab-inc
 */
public class AddCategoryParams extends PostParams {

    private long projectId;
    private String projectIdOrKey;

    /**
     * Constructor
     *
     * @param projectId the project identifier
     * @param name      the category name
     */
    public AddCategoryParams(long projectId, String name) {
        this.projectId = projectId;
        parameters.add(new NameValuePair("name", name));
    }

    /**
     * Constructor
     *
     * @param projectIdOrKey    the project identifier
     * @param name              the category name
     */
    public AddCategoryParams(String projectIdOrKey, String name) {
        this.projectIdOrKey = projectIdOrKey;
        parameters.add(new NameValuePair("name", name));
    }

    /**
     * Returns the project identifier string.
     *
     * @return project id or project key
     */
    public String getProjectIdOrKeyString() {
        if (projectIdOrKey != null) {
            return projectIdOrKey;
        } else {
            return String.valueOf(projectId);
        }
    }
}
