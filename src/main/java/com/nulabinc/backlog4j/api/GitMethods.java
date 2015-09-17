package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.ResponseList;

/**
 * Executes Backlog Git APIs.
 *
 * @author nulab-inc
 */
public interface GitMethods {

    /**
     * Returns the git repositories in the project.
     *
     * @param projectId the project identifier
     * @return the git repositories in a list.
     * @throws BacklogException
     */
    ResponseList<Repository> getGitRepositories(long projectId) throws BacklogException;

    /**
     * Returns the git repositories in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the git repositories in a list.
     * @throws BacklogException
     */
    ResponseList<Repository> getGitRepositories(String projectIdOrKey) throws BacklogException;

    /**
     * Returns the git repository.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @return the git repository.
     * @throws BacklogException
     */
    Repository getGitRepository(long projectId, long repoId) throws BacklogException;

    /**
     * Returns the git repository.
     *
     * @param projectIdOrKey the project identifier
     * @param repoName the repository name
     * @return the git repository.
     * @throws BacklogException
     */
    Repository getGitRepository(String projectIdOrKey, String repoName) throws BacklogException;
}
