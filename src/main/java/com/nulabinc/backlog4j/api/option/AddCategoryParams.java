package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for add category API.
 *
 * @author nulab-inc
 */
public class AddCategoryParams extends PostParams {

    private Object projectIdOrKey;

    /**
     * Constructor
     *
     * @param projectIdOrKey    the project identifier
     * @param name              the category name
     */
    public AddCategoryParams(Object projectIdOrKey, String name) {
        this.projectIdOrKey = projectIdOrKey;
        parameters.add(new NameValuePair("name", name));
    }

    /**
     * Returns the project identifier string.
     *
     * @return project id or project key
     */
    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }
}
