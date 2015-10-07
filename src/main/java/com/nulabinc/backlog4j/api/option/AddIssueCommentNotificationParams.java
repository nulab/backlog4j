package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add category API.
 *
 * @author nulab-inc
 */
public class AddIssueCommentNotificationParams extends PostParams {

    private Object issueIdOrKey;
    private Object commentId;

    /**
     * Constructor
     *
     * @param issueIdOrKey           the issue identifier
     * @param commentId         the comment identifier
     * @param notifiedUserIds   the user identifiers for notification
     */
    public AddIssueCommentNotificationParams(Object issueIdOrKey, Object commentId, List notifiedUserIds) {
        this.issueIdOrKey = issueIdOrKey;
        this.commentId = commentId;
        for (Object userId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", String.valueOf(userId)));
        }
    }

    /**
     * Returns the comment identifier.
     *
     * @return comment id
     */
    public String getCommentId() {
        return commentId.toString();
    }

    /**
     * Returns the issue identifier string.
     *
     * @return issue id or project key
     */
    public String getIssueIdOrKeyString() {
        return issueIdOrKey.toString();
    }
}
