package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add pull request API.
 *
 * @author nulab-inc
 */
public class AddPullRequestParams extends PostParams {

    private long projectId;
    private String projectIdOrKey;
    private long repoId;
    private String repoName;

    /**
     * Constructor
     *
     * @param projectId   the project identifier
     * @param repoId      the repository identifier
     * @param summary     the pull request title
     */
    public AddPullRequestParams(long projectId, long repoId, String summary) {
        this.projectId = projectId;
        this.repoId = repoId;
        parameters.add(new NameValuePair("summary", summary));
    }

    /**
     * Constructor
     *
     * @param projectIdOrKey    the project identifier
     * @param repoName      the repository identifier
     * @param summary       the pull request title
     */
    public AddPullRequestParams(String projectIdOrKey, String repoName, String summary, String description,
                                String base, String branch) {
        this.projectIdOrKey = projectIdOrKey;
        this.repoName = repoName;
        parameters.add(new NameValuePair("summary", summary));
        parameters.add(new NameValuePair("description", description));
        parameters.add(new NameValuePair("base", base));
        parameters.add(new NameValuePair("branch", branch));
    }

    public String getProjectIdOrKeyString() {
        if(projectIdOrKey != null){
            return projectIdOrKey;
        }else{
            return String.valueOf(projectId);
        }
    }

    public String getRepoIdOrNameString() {
        if(repoName != null){
            return repoName;
        }else{
            return String.valueOf(repoId);
        }
    }

    /**
     * Sets the related issue parameter.
     *
     * @param issueId the isssue identifier
     * @return AddPullRequestParams instance
     */
    public AddPullRequestParams issueId(long issueId) {
        parameters.add(new NameValuePair("issueId", String.valueOf(issueId)));
        return this;
    }

    /**
     * Sets the pull request assignee user.
     *
     * @param assigneeId the assignee user id
     * @return AddPullRequestParams instance
     */
    public AddPullRequestParams assigneeId(long assigneeId) {
        parameters.add(new NameValuePair("assigneeId", String.valueOf(assigneeId)));
        return this;

    }

    /**
     * Sets the pull request notified users.
     *
     * @param notifiedUserIds notified user identifiers
     * @return AddPullRequestParams instance
     */
    public AddPullRequestParams notifiedUserIds(List<Long> notifiedUserIds) {
        for (Long notifiedUserId : notifiedUserIds) {
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
    public AddPullRequestParams attachmentIds(List<Long> attachmentIds) {
        for (Long attachmentId : attachmentIds) {
            parameters.add(new NameValuePair("attachmentId[]", attachmentId.toString()));
        }
        return this;
    }

}
