package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update issue comment API.
 *
 * @author nulab-inc
 */
public class UpdateIssueCommentParams extends PatchParams {
    private long issueId;
    private String issueIdOrKey;
    private long commentId;

    public UpdateIssueCommentParams(long issueId, long commentId, String content) {
        this.issueId = issueId;
        this.commentId = commentId;
        parameters.add(new NameValuePair("content", content));
    }

    public UpdateIssueCommentParams(String issueIdOrKey, long commentId, String content) {
        this.issueIdOrKey = issueIdOrKey;
        this.commentId = commentId;
        parameters.add(new NameValuePair("content", content));
    }

    public long getCommentId() {
        return commentId;
    }

    public String getIssueIdOrKeyString() {
        if (issueIdOrKey != null) {
            return issueIdOrKey;
        } else {
            return String.valueOf(issueId);
        }
    }
}
