package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update version API.
 *
 * @author nulab-inc
 */
public class UpdateVersionParams extends PatchParams {

    private long projectId;
    private String projectKey;
    private long versionId;

    public UpdateVersionParams(long projectId, long versionId, String name) {
        this.projectId = projectId;
        this.versionId = versionId;
        parameters.add(new NameValuePair("name", name));
    }

    public UpdateVersionParams(String projectKey, long versionId, String name) {
        this.projectKey = projectKey;
        this.versionId = versionId;
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

    public long getVersionId() {
        return versionId;
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
