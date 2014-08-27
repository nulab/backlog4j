package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for add issue comment API.
 *
 * @author nulab-inc
 */
public class AddIssueCommentParams extends PostParams {

    private long issueId;
    private String issueKey;

    /**
     * Constructor
     *
     * @param issueId the issue identifier
     * @param content the comment content
     */
    public AddIssueCommentParams(long issueId, String content) {
        this.issueId = issueId;
        parameters.add(new BasicNameValuePair("content", content));
    }

    /**
     * Constructor
     *
     * @param issueKey the issue identifier
     * @param content the comment content
     */
    public AddIssueCommentParams(String issueKey, String content) {
        this.issueKey = issueKey;
        parameters.add(new BasicNameValuePair("content", content));
    }

    /**
     * Returns the issue identifier string.
     *
     * @return issue id or issue key
     */
    public String getIssueIdOrKeyString() {
        if (issueKey != null) {
            return issueKey;
        } else {
            return String.valueOf(issueId);
        }
    }

    /**
     * Sets the notified users.
     *
     * @param notifiedUserIds the notified user identifiers
     * @return AddIssueCommentParams instance
     */
    public AddIssueCommentParams notifiedUserIds(List<Long> notifiedUserIds) {
        for (Long notifiedUserId : notifiedUserIds) {
            parameters.add(new BasicNameValuePair("notifiedUserId[]", String.valueOf(notifiedUserId)));
        }
        return this;
    }

    /**
     * Sets the attachment files.
     *
     * @param attachmentIds the notified file identifiers
     * @return AddIssueCommentParams instance
     */
    public AddIssueCommentParams attachmentIds(List<Long> attachmentIds) {
        for (Long attachmentId : attachmentIds) {
            parameters.add(new BasicNameValuePair("attachmentId[]", String.valueOf(attachmentId)));
        }
        return this;
    }
}
