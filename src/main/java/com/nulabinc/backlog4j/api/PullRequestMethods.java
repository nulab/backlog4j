package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.*;
import com.nulabinc.backlog4j.internal.json.customFields.*;

/**
 * Executes Backlog Pull Request APIs.
 *
 * @author nulab-inc
 */
public interface PullRequestMethods {

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(long projectId, long repoId) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(String projectKey, String repoName) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param params the finding pull request parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(long projectId, long repoId, PullRequestQueryParams params) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param params the finding pull request parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(String projectKey, String repoName, PullRequestQueryParams params) throws BacklogException;

    /**
     * Returns the count of the pull requests.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @return the git pull request.
     * @throws BacklogException
     */
    int getPullRequestCount(long projectId, long repoId) throws BacklogException;

    /**
     * Returns the count of the pull requests.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @return the git pull request.
     * @throws BacklogException
     */
    int getPullRequestCount(String projectKey, String repoName) throws BacklogException;

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
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    PullRequest getPullRequest(long projectId, long repoId, long number) throws BacklogException;

    /**
     * Returns the pull request.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    PullRequest getPullRequest(String projectKey, String repoName, long number) throws BacklogException;

    /**
     * Returns the comments of pull requests.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @param params the finding pull request comments parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequestComment> getPullRequestComments(long projectId, long repoId, long number, QueryParams params) throws BacklogException;

    /**
     * Returns the comments of pull requests.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @param params the finding pull request comments parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequestComment> getPullRequestComments(String projectKey, String repoName, long number, QueryParams params) throws BacklogException;


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
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @return the pull request comment count
     * @throws BacklogException
     */
    int getPullRequestCommentCount(long projectId, long repoId, long number) throws BacklogException;

    /**
     * Returns the pull request comment count.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @return the pull request comment count
     * @throws BacklogException
     */
    int getPullRequestCommentCount(String projectKey, String repoName, long number) throws BacklogException;

    /**
     * Updates the pull request comment.
     *
     * @param params  the pull request comment updating parameters
     * @return the pull request comment.
     * @throws BacklogException
     */
    PullRequestComment updatePullRequestComment(UpdatePullRequestCommentParams params) throws BacklogException;

    /**
     * Returns the pull request attachment list.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @return the pull request attachment list
     * @throws BacklogException
     */
    ResponseList<Attachment> getPullRequestAttachments(long projectId, long repoId, long number) throws BacklogException;

    /**
     * Returns the pull request attachment list.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @return the pull request attachment list
     * @throws BacklogException
     */
    ResponseList<Attachment> getPullRequestAttachments(String projectKey, String repoName, long number) throws BacklogException;

    /**
     * Returns the attachment file data on the pull request.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @param attachmentId the pull request attachment identifier
     * @return the attachment file data
     * @throws BacklogException
     */
    AttachmentData downloadPullRequestAttachment(long projectId, long repoId, long number, long attachmentId) throws BacklogException;

    /**
     * Returns the attachment file data on the pull request.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @param attachmentId the pull request attachment identifier
     * @return the attachment file data
     * @throws BacklogException
     */
    AttachmentData downloadPullRequestAttachment(String projectKey, String repoName, long number, long attachmentId) throws BacklogException;

    /**
     * Returns the endpoint of attachment file.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @param attachmentId the pull request attachment identifier
     * @return the endpoint
     */
    String getPullRequestAttachmentEndpoint(long projectId, long repoId, long number, long attachmentId);

    /**
     * Returns the endpoint of attachment file.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @param attachmentId the pull request attachment identifier
     * @return the endpoint
     */
    String getPullRequestAttachmentEndpoint(String projectKey, String repoName, long number, long attachmentId);

    /**
     * Deletes the attachment file on the pull request.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @param attachmentId the pull request attachment identifier
     * @return the Attachment
     * @throws BacklogException
     */
    Attachment deletePullRequestAttachment(long projectId, long repoId, long number, long attachmentId) throws BacklogException;

    /**
     * Deletes the attachment file on the pull request.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @param attachmentId the pull request attachment identifier
     * @return the Attachment
     * @throws BacklogException
     */
    Attachment deletePullRequestAttachment(String projectKey, String repoName, long number, long attachmentId) throws BacklogException;
}
