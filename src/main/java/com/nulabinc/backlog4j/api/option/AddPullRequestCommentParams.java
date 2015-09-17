package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add pull request comment API.
 *
 * @author nulab-inc
 */
public class AddPullRequestCommentParams extends PostParams {

    private long projectId;
    private String projectIdOrKey;

    private long repoId;
    private String repoName;

    private long number;

    /**
     * Constructor
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @param content the comment content
     */
    public AddPullRequestCommentParams(long projectId, long repoId, long number, String content) {
        this.projectId = projectId;
        this.repoId = repoId;
        this.number = number;
        parameters.add(new NameValuePair("content", content));
    }

    /**
     * Constructor
     *
     * @param projectIdOrKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @param content the comment content
     */
    public AddPullRequestCommentParams(String projectIdOrKey, String repoName, long number, String content) {
        this.projectIdOrKey = projectIdOrKey;
        this.repoName = repoName;
        this.number = number;
        parameters.add(new NameValuePair("content", content));
    }

    /**
     * Returns the project identifier string.
     *
     * @return project id or project key
     */
    public String getProjectIdOrKeyString() {
        if (projectIdOrKey != null) {
            return projectIdOrKey;
        } else {
            return String.valueOf(projectId);
        }
    }

    /**
     * Returns the repo name identifier string.
     *
     * @return project repo id or repo name
     */
    public String getRepoIdOrName() {
        if (repoName != null) {
            return repoName;
        } else {
            return String.valueOf(repoId);
        }
    }

    /**
     * Returns the pull request identifier string.
     *
     * @return project pull request number
     */
    public String getNumber() {
        return String.valueOf(number);
    }

    /**
     * Sets the notified users.
     *
     * @param notifiedUserIds the notified user identifiers
     * @return AddPullRequestCommentParams instance
     */
    public AddPullRequestCommentParams notifiedUserIds(List<Long> notifiedUserIds) {
        for (Long notifiedUserId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", String.valueOf(notifiedUserId)));
        }
        return this;
    }

}
