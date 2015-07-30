package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add pull request comment API.
 *
 * @author nulab-inc
 */
public class UpdatePullRequestCommentParams extends PatchParams {

    private long projectId;
    private String projectKey;

    private long repoId;
    private String repoName;

    private long number;
    private long commentId;

    /**
     * Constructor
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @param commentId the pull request comment identifier
     * @param content the comment content
     */
    public UpdatePullRequestCommentParams(long projectId, long repoId, long number, long commentId, String content) {
        this.projectId = projectId;
        this.repoId = repoId;
        this.number = number;
        this.commentId = commentId;
        parameters.add(new NameValuePair("content", content));
    }

    /**
     * Constructor
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @param commentId the pull request comment identifier
     * @param content the comment content
     */
    public UpdatePullRequestCommentParams(String projectKey, String repoName, long number, long commentId, String content) {
        this.projectKey = projectKey;
        this.repoName = repoName;
        this.number = number;
        this.commentId = commentId;
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
     * @return thr pull request number
     */
    public String getNumber() {
        return String.valueOf(number);
    }

    /**
     * Returns the pull request comment identifier string.
     *
     * @return thr pull request comment identifier
     */
    public String getCommentid() {
        return String.valueOf(commentId);
    }

    /**
     * Sets the notified users.
     *
     * @param notifiedUserIds the notified user identifiers
     * @return AddPullRequestCommentParams instance
     */
    public UpdatePullRequestCommentParams notifiedUserIds(List<Long> notifiedUserIds) {
        for (Long notifiedUserId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", String.valueOf(notifiedUserId)));
        }
        return this;
    }

}
