package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add pull request comment API.
 *
 * @author nulab-inc
 */
public class UpdatePullRequestCommentParams extends PatchParams {

    private Object projectIdOrKey;
    private Object repoIdOrName;
    private Object number;
    private Object commentId;

    /**
     * Constructor
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName the repository name
     * @param number the pull request identifier
     * @param commentId the pull request comment identifier
     * @param content the comment content
     */
    public UpdatePullRequestCommentParams(Object projectIdOrKey, Object repoIdOrName, Object number, Object commentId, String content) {
        this.projectIdOrKey = projectIdOrKey;
        this.repoIdOrName = repoIdOrName;
        this.number = number;
        this.commentId = commentId;
        parameters.add(new NameValuePair("content", content));
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public String getRepoIdOrName() {
        return repoIdOrName.toString();
    }

    public String getNumber() {
        return this.number.toString();
    }

    public String getCommentId() {
        return this.commentId.toString();
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
