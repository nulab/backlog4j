package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for update issue comment API.
 *
 * @author nulab-inc
 */
public class UpdateIssueCommentParams extends PatchParams {
    private long issueId;
    private String issueKey;
    private long commentId;

    public UpdateIssueCommentParams(long issueId, long commentId, String content) {
        this.issueId = issueId;
        this.commentId = commentId;
        parameters.add(new BasicNameValuePair("content", content));
    }

    public UpdateIssueCommentParams(String issueKey, long commentId, String content) {
        this.issueKey = issueKey;
        this.commentId = commentId;
        parameters.add(new BasicNameValuePair("content", content));
    }

    public long getCommentId() {
        return commentId;
    }

    public String getIssueIdOrKeyString() {
        if (issueKey != null) {
            return issueKey;
        } else {
            return String.valueOf(issueId);
        }
    }
}
