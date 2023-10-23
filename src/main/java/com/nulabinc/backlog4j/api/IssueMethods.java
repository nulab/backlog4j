package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.*;

import java.util.List;

/**
 * Executes Backlog Issue APIs.
 *
 * @author nulab-inc
 */
public interface IssueMethods {

    /**
     * Finds and returns all the issues.
     *
     * @param params the finding issue parameters
     * @return the issues in a list.
     * @throws BacklogException
     */
    ResponseList<Issue> getIssues(GetIssuesParams params) throws BacklogException;

    /**
     * Finds and returns all the issues count.
     *
     * @param params the finding issue parameters
     * @return the issues count.
     * @throws BacklogException
     */
    int getIssuesCount(GetIssuesCountParams params) throws BacklogException;

    /**
     * Creates an issue.
     *
     * @param params the issue creating parameters
     * @return the created Issue
     * @throws BacklogException
     */
    Issue createIssue(CreateIssueParams params) throws BacklogException;

    // 課題情報の取得

    /**
     * Returns the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @return the Issue
     * @throws BacklogException
     */
    Issue getIssue(Object issueIdOrKey) throws BacklogException;

    /**
     * Updates an existing issue.
     *
     * @param params the issue updating parameters
     * @return the updated Issue
     * @throws BacklogException
     */
    Issue updateIssue(UpdateIssueParams params) throws BacklogException;

    /**
     * Deletes the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @return the deleted Issue
     * @throws BacklogException
     */
    Issue deleteIssue(Object issueIdOrKey) throws BacklogException;

    /**
     * Returns the issue comments.
     *
     * @param issueIdOrKey the issue identifier
     * @return the issue's comments in a list.
     * @throws BacklogException
     */
    ResponseList<IssueComment> getIssueComments(Object issueIdOrKey) throws BacklogException;

    /**
     * Returns the issue comments.
     *
     * @param issueIdOrKey the issue identifier
     * @param queryParams  the query parameters
     * @return the issue's comments in a list.
     * @throws BacklogException
     */
    ResponseList<IssueComment> getIssueComments(Object issueIdOrKey, QueryParams queryParams) throws BacklogException;

    /**
     * Adds a issue comment.
     *
     * @param params the issue comment adding parameters
     * @return the added IssueComment
     * @throws BacklogException
     */
    IssueComment addIssueComment(AddIssueCommentParams params) throws BacklogException;

    /**
     * Returns the count of the issue comments.
     *
     * @param issueIdOrKey the issue identifier
     * @return count of the issue comments.
     * @throws BacklogException
     */
    int getIssueCommentCount(Object issueIdOrKey) throws BacklogException;

    /**
     * Returns the issue comment.
     *
     * @param issueIdOrKey the issue identifier
     * @param commentId    the comment identifier
     * @return the issue comment
     * @throws BacklogException
     */
    IssueComment getIssueComment(Object issueIdOrKey, Object commentId) throws BacklogException;

    /**
     * Updates an existing issue comment.
     *
     * @param params the issue comment updating parameters.
     * @return the updated IssueComment
     * @throws BacklogException
     */
    IssueComment updateIssueComment(UpdateIssueCommentParams params) throws BacklogException;

    /**
     * Returns the issue comment notifications.
     *
     * @param issueIdOrKey the issue identifier
     * @param commentId    the comment identifier
     * @return the issue comment notifications
     * @throws BacklogException
     */
    ResponseList<Notification> getIssueCommentNotifications(Object issueIdOrKey, Object commentId) throws BacklogException;

    /**
     * Adds a issue comment notification.
     *
     * @param params the issue comment notification adding parameters
     * @return the issue comment
     * @throws BacklogException
     */
    IssueComment addIssueCommentNotification(AddIssueCommentNotificationParams params) throws BacklogException;

    /**
     * Returns all the attachments on the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @return the attachments in a list.
     */
    ResponseList<Attachment> getIssueAttachments(Object issueIdOrKey);

    /**
     * Returns the attachment file data on the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @param attachmentId the attachment identifier
     * @return the AttachmentData
     */
    AttachmentData downloadIssueAttachment(Object issueIdOrKey, Object attachmentId);

    /**
     * Deletes the attachment file on the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @param attachmentId the attachment identifier
     * @return the Attachment
     */
    Attachment deleteIssueAttachment(Object issueIdOrKey, Object attachmentId);

    /**
     * Returns all the shared files on the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @return the shared files in a list.
     */
    ResponseList<SharedFile> getIssueSharedFiles(Object issueIdOrKey);

    /**
     * links the shared files to the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @param fileIds      the file identifiers in a list
     * @return the linked shared files in a list.
     */
    ResponseList<SharedFile> linkIssueSharedFile(Object issueIdOrKey, List fileIds);

    /**
     * Deletes link of the shared file from the issue.
     *
     * @param issueIdOrKey the issue identifier
     * @param fileId       the file identifiers
     * @return the unlinked SharedFile
     */
    SharedFile unlinkIssueSharedFile(Object issueIdOrKey, Object fileId);

}
