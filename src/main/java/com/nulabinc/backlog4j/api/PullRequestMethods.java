package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.*;

/**
 * Executes Backlog Pull Request APIs.
 *
 * @author nulab-inc
 */
public interface PullRequestMethods {

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(Object projectIdOrKey, Object repoIdOrName) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param params         the finding pull request parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(Object projectIdOrKey, Object repoIdOrName, PullRequestQueryParams params) throws BacklogException;

    /**
     * Returns the count of the pull requests.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @return the git pull request.
     * @throws BacklogException
     */
    int getPullRequestCount(Object projectIdOrKey, Object repoIdOrName) throws BacklogException;

    /**
     * Returns the count of the pull requests.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param params         the finding pull request parameters.
     * @return the git pull request.
     * @throws BacklogException
     */
    int getPullRequestCount(Object projectIdOrKey, Object repoIdOrName, PullRequestQueryParams params) throws BacklogException;

    /**
     * Add a pull request.
     *
     * @param params the pull request adding parameters
     * @return the git pull request.
     * @throws BacklogException
     */
    PullRequest addPullRequest(AddPullRequestParams params) throws BacklogException;

    /**
     * Update a pull request.
     *
     * @param params the pull request updating parameters
     * @return the git pull request.
     * @throws BacklogException
     */
    PullRequest updatePullRequest(UpdatePullRequestParams params) throws BacklogException;

    /**
     * Returns the pull request.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param number         the pull request identifier
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    PullRequest getPullRequest(Object projectIdOrKey, Object repoIdOrName, Object number) throws BacklogException;

    /**
     * Returns the comments of pull requests.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param number         the pull request identifier
     * @param params         the finding pull request comments parameters.
     * @return the git pull request comments in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequestComment> getPullRequestComments(Object projectIdOrKey, Object repoIdOrName, Object number, QueryParams params) throws BacklogException;


    /**
     * Add a comment on the pull request.
     *
     * @param params the adding pull request comment parameters.
     * @return the added pull request comment.
     * @throws BacklogException
     */
    PullRequestComment addPullRequestComment(AddPullRequestCommentParams params) throws BacklogException;

    /**
     * Returns the pull request comment count.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param number         the pull request identifier
     * @return the pull request comment count
     * @throws BacklogException
     */
    int getPullRequestCommentCount(Object projectIdOrKey, Object repoIdOrName, Object number) throws BacklogException;

    /**
     * Updates the pull request comment.
     *
     * @param params the pull request comment updating parameters
     * @return the pull request comment.
     * @throws BacklogException
     */
    PullRequestComment updatePullRequestComment(UpdatePullRequestCommentParams params) throws BacklogException;

    /**
     * Returns the pull request attachment list.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param number         the pull request identifier
     * @return the pull request attachment list
     * @throws BacklogException
     */
    ResponseList<Attachment> getPullRequestAttachments(Object projectIdOrKey, Object repoIdOrName, Object number) throws BacklogException;

    /**
     * Returns the attachment file data on the pull request.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param number         the pull request identifier
     * @param attachmentId   the pull request attachment identifier
     * @return the attachment file data
     * @throws BacklogException
     */
    AttachmentData downloadPullRequestAttachment(Object projectIdOrKey, Object repoIdOrName, Object number, Object attachmentId) throws BacklogException;

    /**
     * Deletes the attachment file on the pull request.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @param number         the pull request identifier
     * @param attachmentId   the pull request attachment identifier
     * @return the Attachment
     * @throws BacklogException
     */
    Attachment deletePullRequestAttachment(Object projectIdOrKey, Object repoIdOrName, Object number, Object attachmentId) throws BacklogException;
}
