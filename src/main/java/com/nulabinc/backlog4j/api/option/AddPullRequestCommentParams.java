package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add pull request comment API.
 *
 * @author nulab-inc
 */
public class AddPullRequestCommentParams extends PostParams {

    private Object projectIdOrKey;
    private Object repoIdOrName;
    private Object number;

    /**
     * Constructor
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param number         the pull request identifier
     * @param content        the comment content
     */
    public AddPullRequestCommentParams(Object projectIdOrKey, Object repoIdOrName, Object number, String content) {
        this.projectIdOrKey = projectIdOrKey;
        this.repoIdOrName = repoIdOrName;
        this.number = number;
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
