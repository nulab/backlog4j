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
    private String projectKey;

    private long repoId;
    private String repoName;

    private long pullRequestId;
    private String pullRequestKey;

    /**
     * Constructor
     *
     * @param projectKey the project identifier
     * @param pullRequestId the pull request identifier
     * @param content the comment content
     */
    public AddPullRequestCommentParams(String projectKey, String repoName, long pullRequestId, String content) {
        this.projectKey = projectKey;
        this.repoName = repoName;
        this.pullRequestId = pullRequestId;
        parameters.add(new NameValuePair("content", content));
    }

    /**
     * Returns the project identifier string.
     *
     * @return project id or project key
     */
    public String getProjectIdOrKeyString() {
        if (projectKey != null) {
            return projectKey;
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
     * @return project pull request id or pull request key
     */
    public String getPullRequestIdOrKeyString() {
        if (pullRequestKey != null) {
            return pullRequestKey;
        } else {
            return String.valueOf(pullRequestId);
        }
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
