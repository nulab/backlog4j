package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add category API.
 *
 * @author nulab-inc
 */
public class AddIssueCommentNotificationParams extends PostParams {

    private long issueId;
    private String issueIdOrKey;
    private long commentId;

    /**
     * Constructor
     *
     * @param issueId           the issue identifier
     * @param commentId         the comment identifier
     * @param notifiedUserIds   the user identifiers for notification
     */
    public AddIssueCommentNotificationParams(long issueId, long commentId, List<Long> notifiedUserIds) {
        this.issueId = issueId;
        this.commentId = commentId;
        for (Long userId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", String.valueOf(userId)));
        }
    }

    /**
     * Constructor
     *
     * @param issueIdOrKey           the issue identifier
     * @param commentId         the comment identifier
     * @param notifiedUserIds   the user identifiers for notification
     */
    public AddIssueCommentNotificationParams(String issueIdOrKey, long commentId, List<Long> notifiedUserIds) {
        this.issueIdOrKey = issueIdOrKey;
        this.commentId = commentId;
        for (Long userId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", String.valueOf(userId)));
        }
    }

    /**
     * Returns the comment identifier.
     *
     * @return comment id
     */
    public long getCommentId() {
        return commentId;
    }

    /**
     * Returns the issue identifier string.
     *
     * @return issue id or project key
     */
    public String getIssueIdOrKeyString() {
        if (issueIdOrKey != null) {
            return issueIdOrKey;
        } else {
            return String.valueOf(issueId);
        }
    }
}
