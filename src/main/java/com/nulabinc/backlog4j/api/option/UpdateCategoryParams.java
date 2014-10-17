package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update category API.
 *
 * @author nulab-inc
 */
public class UpdateCategoryParams extends PatchParams {

    private long projectId;
    private String projectKey;
    private long categoryId;

    public UpdateCategoryParams(long projectId, long categoryId, String name) {
        this.projectId = projectId;
        this.categoryId = categoryId;
        parameters.add(new NameValuePair("name", name));
    }

    public UpdateCategoryParams(String projectKey, long categoryId, String name) {
        this.projectKey = projectKey;
        this.categoryId = categoryId;
        parameters.add(new NameValuePair("name", name));
        ;
    }


    public String getProjectIdOrKeyString() {
        if (projectKey != null) {
            return projectKey;
        } else {
            return String.valueOf(projectId);
        }
    }

    public long getCategoryId() {
        return categoryId;
    }
}
