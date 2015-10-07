package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update category API.
 *
 * @author nulab-inc
 */
public class UpdateCategoryParams extends PatchParams {

    private Object projectIdOrKey;
    private Object categoryId;

    public UpdateCategoryParams(Object projectIdOrKey, Object categoryId, String name) {
        this.projectIdOrKey = projectIdOrKey;
        this.categoryId = categoryId;
        parameters.add(new NameValuePair("name", name));
    }


    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public String getCategoryId() {
        return categoryId.toString();
    }
}
