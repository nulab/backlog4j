package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for updates order about status API.
 *
 * @author nulab-inc
 */
public class UpdateOrderOfStatusParams extends PatchParams {

    private Object projectIdOrKey;

    public UpdateOrderOfStatusParams(Object projectIdOrKey, List statusIds) {
        this.projectIdOrKey = projectIdOrKey;
        for (Object statusId : statusIds) {
            parameters.add(new NameValuePair("statusId[]", statusId.toString()));
        }
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

}
