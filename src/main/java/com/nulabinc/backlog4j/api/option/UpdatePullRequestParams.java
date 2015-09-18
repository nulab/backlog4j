package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for update pull request API.
 *
 * @author nulab-inc
 */
public class UpdatePullRequestParams extends PatchParams {

    private Object projectIdOrKey;
    private Object repoIdOrName;
    private Object number;

    /**
     * Constructor
     *
     * @param projectIdOrKey    the project identifier
     * @param repoIdOrName      the repository identifier
     * @param number        the pull request title
     */
    public UpdatePullRequestParams(Object projectIdOrKey, Object repoIdOrName, Object number) {
        this.projectIdOrKey = projectIdOrKey;
        this.repoIdOrName = repoIdOrName;
        this.number = number;
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public String getRepoIdOrNameString() {
        return repoIdOrName.toString();
    }

    public String getNumber() {
        return this.number.toString();
    }

    /**
     * Sets the summary.
     *
     * @param summary the pull request description
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams summary(String summary) {
        parameters.add(new NameValuePair("summary", summary));
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description the pull request description
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams description(String description) {
        parameters.add(new NameValuePair("description", description));
        return this;
    }

    /**
     * Sets the base parameter.
     *
     * @param base the base branch name
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams base(String base) {
        parameters.add(new NameValuePair("base", base));
        return this;
    }

    /**
     * Sets the branch parameter.
     *
     * @param branch the branch name merge to
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams branch(String branch) {
        parameters.add(new NameValuePair("branch", branch));
        return this;
    }

    /**
     * Sets the related issue parameter.
     *
     * @param issueId the isssue identifier
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams issueId(long issueId) {
        parameters.add(new NameValuePair("issueId", String.valueOf(issueId)));
        return this;
    }

    /**
     * Sets the pull request assignee user.
     *
     * @param assigneeId the assignee user id
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams assigneeId(long assigneeId) {
        parameters.add(new NameValuePair("assigneeId", String.valueOf(assigneeId)));
        return this;

    }

    /**
     * Sets the pull request notified users.
     *
     * @param notifiedUserIds notified user identifiers
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams notifiedUserIds(List<Long> notifiedUserIds) {
        for (Long notifiedUserId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", notifiedUserId.toString()));
        }
        return this;

    }

    /**
     * Sets the pull request attachment files.
     *
     * @param attachmentIds the attachment file identifiers
     * @return UpdatePullRequestParams instance
     */
    public UpdatePullRequestParams attachmentIds(List<Long> attachmentIds) {
        for (Long attachmentId : attachmentIds) {
            parameters.add(new NameValuePair("attachmentId[]", attachmentId.toString()));
        }
        return this;
    }
}
