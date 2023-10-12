package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update version API.
 *
 * @author nulab-inc
 */
public class UpdateVersionParams extends PatchParams {

    private Object projectIdOrKey;
    private Object versionId;

    public UpdateVersionParams(Object projectIdOrKey, Object versionId, String name) {
        this.projectIdOrKey = projectIdOrKey;
        this.versionId = versionId;
        parameters.add(new NameValuePair("name", name));
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public String getVersionId() {
        return versionId.toString();
    }

    public UpdateVersionParams description(String description) {
        parameters.add(new NameValuePair("description", description));
        return this;
    }

    public UpdateVersionParams startDate(String startDate) {
        parameters.add(new NameValuePair("startDate", startDate));
        return this;
    }

    public UpdateVersionParams releaseDueDate(String releaseDueDate) {
        parameters.add(new NameValuePair("releaseDueDate", releaseDueDate));
        return this;
    }

    public UpdateVersionParams archived(boolean archived) {
        parameters.add(new NameValuePair("archived", String.valueOf(archived)));
        return this;
    }
}
