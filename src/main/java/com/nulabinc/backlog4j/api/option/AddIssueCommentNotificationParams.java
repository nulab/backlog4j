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
    private String issueKey;
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
     * @param issueKey           the issue identifier
     * @param commentId         the comment identifier
     * @param notifiedUserIds   the user identifiers for notification
     */
    public AddIssueCommentNotificationParams(String issueKey, long commentId, List<Long> notifiedUserIds) {
        this.issueKey = issueKey;
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
        if (issueKey != null) {
            return issueKey;
        } else {
            return String.valueOf(issueId);
        }
    }
}
