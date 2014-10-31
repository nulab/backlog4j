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
    Count getIssuesCount(GetIssuesParams params) throws BacklogException;

    /**
     * Creates a issue.
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
     * @param issueId the issue identifier
     * @return the Issue
     * @throws BacklogException
     */
    Issue getIssue(long issueId) throws BacklogException;

    /**
     * Returns the issue.
     *
     * @param issueKey the issue identifier
     * @return the Issue
     * @throws BacklogException
     */
    Issue getIssue(String issueKey) throws BacklogException;

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
     * @param issueId the issue identifier
     * @return the deleted Issue
     * @throws BacklogException
     */
    Issue deleteIssue(long issueId) throws BacklogException;

    /**
     * Deletes the issue.
     *
     * @param issueKey the issue identifier
     * @return the deleted Issue
     * @throws BacklogException
     */
    Issue deleteIssue(String issueKey) throws BacklogException;

    /**
     * Returns the comments on the issue.
     *
     * @param issueId the issue identifier
     * @return the issue's comments in a list.
     * @throws BacklogException
     */
    ResponseList<IssueComment> getIssueComments(long issueId) throws BacklogException;

    /**
     * Returns the issue comments.
     *
     * @param issueKey the issue identifier
     * @return the issue's comments in a list.
     * @throws BacklogException
     */
    ResponseList<IssueComment> getIssueComments(String issueKey) throws BacklogException;

    /**
     * Returns the issue comments.
     *
     * @param issueId     the issue identifier
     * @param queryParams the query parameters
     * @return the issue's comments in a list.
     * @throws BacklogException
     */
    ResponseList<IssueComment> getIssueComments(long issueId, QueryParams queryParams) throws BacklogException;

    /**
     * Returns the issue comments.
     *
     * @param issueKey    the issue identifier
     * @param queryParams the query parameters
     * @return the issue's comments in a list.
     * @throws BacklogException
     */
    ResponseList<IssueComment> getIssueComments(String issueKey, QueryParams queryParams) throws BacklogException;

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
     * @param issueId the issue identifier
     * @return count of the issue comments.
     * @throws BacklogException
     */
    int getIssueCommentCount(long issueId) throws BacklogException;

    /**
     * Returns the count of the issue comments.
     *
     * @param issueKey the issue identifier
     * @return count of the issue comments.
     * @throws BacklogException
     */
    int getIssueCommentCount(String issueKey) throws BacklogException;

    /**
     * Returns the issue comment.
     *
     * @param issueId   the issue identifier
     * @param commentId the comment identifier
     * @return the issue comment
     * @throws BacklogException
     */
    IssueComment getIssueComment(long issueId, long commentId) throws BacklogException;

    /**
     * Returns the issue comment.
     *
     * @param issueKey  the issue identifier
     * @param commentId the comment identifier
     * @return the issue comment
     * @throws BacklogException
     */
    IssueComment getIssueComment(String issueKey, long commentId) throws BacklogException;

    /**
     * Updates an existing issue comment.
     *
     * @param params the issue comment updating parameters.
     * @return the updated IssueComment
     * @throws BacklogException
     */
    IssueComment updateIssueComment(UpdateIssueCommentParams params) throws BacklogException;

    /**
     * Returns all the attachments on the issue.
     *
     * @param issueId the issue identifier
     * @return the attachments in a list.
     */
    ResponseList<Attachment> getIssueAttachments(long issueId);

    /**
     * Returns all the attachments on the issue.
     *
     * @param issueKey the issue identifier
     * @return the attachments in a list.
     */
    ResponseList<Attachment> getIssueAttachments(String issueKey);

    /**
     * Returns the attachment file data on the issue.
     *
     * @param issueId      the issue identifier
     * @param attachmentId the attachment identifier
     * @return the AttachmentData
     */
    AttachmentData downloadIssueAttachment(long issueId, long attachmentId);

    /**
     * Returns the attachment file data on the issue.
     *
     * @param issueKey     the issue identifier
     * @param attachmentId the attachment identifier
     * @return the AttachmentData
     */
    AttachmentData downloadIssueAttachment(String issueKey, long attachmentId);

    /**
     * Returns all the shared files on the issue.
     *
     * @param issueId the issue identifier
     * @return the shared files in a list.
     */
    ResponseList<SharedFile> getIssueSharedFiles(long issueId);

    /**
     * Returns all the shared files on the issue.
     *
     * @param issueKey the issue identifier
     * @return the shared files in a list.
     */
    ResponseList<SharedFile> getIssueSharedFiles(String issueKey);

    /**
     * Links the shared files to the issue.
     *
     * @param issueId the issue identifier
     * @param fileIds the file identifiers in a list
     * @return the shared files in a list.
     */
    ResponseList<SharedFile> linkIssueSharedFile(long issueId, List<Long> fileIds);

    /**
     * links the shared files to the issue.
     *
     * @param issueKey the issue identifier
     * @param fileIds  the file identifiers in a list
     * @return the linked shared files in a list.
     */
    ResponseList<SharedFile> linkIssueSharedFile(String issueKey, List<Long> fileIds);

    /**
     * Deletes link of the shared file from the issue.
     *
     * @param issueId the issue identifier
     * @param fileId  the file identifiers
     * @return the unlinked SharedFile
     */
    SharedFile unlinkIssueSharedFile(long issueId, long fileId);

    /**
     * Deletes link of the shared file from the issue.
     *
     * @param issueKey the issue identifier
     * @param fileId   the file identifiers
     * @return the unlinked SharedFile
     */
    SharedFile unlinkIssueSharedFile(String issueKey, long fileId);

}
