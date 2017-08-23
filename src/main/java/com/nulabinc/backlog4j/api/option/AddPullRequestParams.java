package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add pull request API.
 *
 * @author nulab-inc
 */
public class AddPullRequestParams extends PostParams {

    private Object projectIdOrKey;
    private Object repoIdOrName;

    /**
     * Constructor
     *
     * @param projectIdOrKey    the project identifier
     * @param repoIdOrName      the repository identifier
     * @param summary       the pull request title
     */
    public AddPullRequestParams(Object projectIdOrKey, Object repoIdOrName, String summary, String description,
                                String base, String branch) {
        this.projectIdOrKey = projectIdOrKey;
        this.repoIdOrName = repoIdOrName;
        parameters.add(new NameValuePair("summary", summary));
        parameters.add(new NameValuePair("description", description));
        parameters.add(new NameValuePair("base", base));
        parameters.add(new NameValuePair("branch", branch));
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public String getRepoIdOrNameString() {
        return repoIdOrName.toString();
    }

    /**
     * Sets the related issue parameter.
     *
     * @param issueId the isssue identifier
     * @return AddPullRequestParams instance
     */
    public AddPullRequestParams issueId(Object issueId) {
        parameters.add(new NameValuePair("issueId", issueId.toString()));
        return this;
    }

    /**
     * Sets the pull request assignee user.
     *
     * @param assigneeId the assignee user id
     * @return AddPullRequestParams instance
     */
    public AddPullRequestParams assigneeId(Object assigneeId) {
        parameters.add(new NameValuePair("assigneeId", assigneeId.toString()));
        return this;

    }

    /**
     * Sets the pull request notified users.
     *
     * @param notifiedUserIds notified user identifiers
     * @return AddPullRequestParams instance
     */
    public AddPullRequestParams notifiedUserIds(List notifiedUserIds) {
        for (Object notifiedUserId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", notifiedUserId.toString()));
        }
        return this;

    }

    /**
     * Sets the pull request attachment files.
     *
     * @param attachmentIds the attachment file identifiers
     * @return AddPullRequestParams instance
     */
    public AddPullRequestParams attachmentIds(List attachmentIds) {
        for (Object attachmentId : attachmentIds) {
            parameters.add(new NameValuePair("attachmentId[]", attachmentId.toString()));
        }
        return this;
    }

}
