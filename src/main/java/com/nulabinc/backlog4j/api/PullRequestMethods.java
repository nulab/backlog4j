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

}
