package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for add status API.
 *
 * @author nulab-inc
 */
public class AddStatusParams extends PostParams {

    private Object projectIdOrKey;

    public AddStatusParams(Object projectIdOrKey, String name, Project.CustomStatusColor color) {
        this.projectIdOrKey = projectIdOrKey;
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("color", color.getStrValue()));
    }


    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

}
