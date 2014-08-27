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
     * @param projectKey the project identifier
     * @return the git repositories in a list.
     * @throws BacklogException
     */
    ResponseList<Repository> getGitRepositories(String projectKey) throws BacklogException;

}
