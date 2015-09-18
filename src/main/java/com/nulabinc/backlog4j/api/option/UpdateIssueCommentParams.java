package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update issue comment API.
 *
 * @author nulab-inc
 */
public class UpdateIssueCommentParams extends PatchParams {
    private Object issueIdOrKey;
    private Object commentId;

    public UpdateIssueCommentParams(Object issueIdOrKey, Object commentId, String content) {
        this.issueIdOrKey = issueIdOrKey;
        this.commentId = commentId;
        parameters.add(new NameValuePair("content", content));
    }

    public String getCommentId() {
        return commentId.toString();
    }

    public String getIssueIdOrKeyString() {
        return issueIdOrKey.toString();
    }
}
