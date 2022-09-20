package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add issue comment API.
 *
 * @author nulab-inc
 */
public class AddIssueCommentParams extends PostParams {

    private Object issueIdOrKey;

    /**
     * Constructor
     *
     * @param issueIdOrKey the issue identifier
     * @param content      the comment content
     */
    public AddIssueCommentParams(Object issueIdOrKey, String content) {
        this.issueIdOrKey = issueIdOrKey;
        parameters.add(new NameValuePair("content", content));
    }

    /**
     * Returns the issue identifier string.
     *
     * @return issue id or issue key
     */
    public String getIssueIdOrKeyString() {
        return issueIdOrKey.toString();
    }

    /**
     * Sets the notified users.
     *
     * @param notifiedUserIds the notified user identifiers
     * @return AddIssueCommentParams instance
     */
    public AddIssueCommentParams notifiedUserIds(List notifiedUserIds) {
        for (Object notifiedUserId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", notifiedUserId.toString()));
        }
        return this;
    }

    /**
     * Sets the attachment files.
     *
     * @param attachmentIds the notified file identifiers
     * @return AddIssueCommentParams instance
     */
    public AddIssueCommentParams attachmentIds(List attachmentIds) {
        for (Object attachmentId : attachmentIds) {
            parameters.add(new NameValuePair("attachmentId[]", attachmentId.toString()));
        }
        return this;
    }
}
