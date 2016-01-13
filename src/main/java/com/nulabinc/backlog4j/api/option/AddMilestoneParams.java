package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for add version API.
 *
 * @author nulab-inc
 */
public class AddMilestoneParams extends PostParams {

    private Object projectIdOrKey;

    public AddMilestoneParams(Object projectIdOrKey, String name) {
        this.projectIdOrKey = projectIdOrKey;
        parameters.add(new NameValuePair("name", name));
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public AddMilestoneParams description(String description) {
        parameters.add(new NameValuePair("description", description));
        return this;
    }

    public AddMilestoneParams startDate(String startDate) {
        parameters.add(new NameValuePair("startDate", startDate));
        return this;
    }

    public AddMilestoneParams releaseDueDate(String releaseDueDate) {
        parameters.add(new NameValuePair("releaseDueDate", releaseDueDate));
        return this;
    }
}
