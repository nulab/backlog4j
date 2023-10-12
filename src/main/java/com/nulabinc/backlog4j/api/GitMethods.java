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
     * @param projectIdOrKey the project identifier
     * @return the git repositories in a list.
     * @throws BacklogException
     */
    ResponseList<Repository> getGitRepositories(Object projectIdOrKey) throws BacklogException;

    /**
     * Returns the git repository.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName   the repository name
     * @return the git repository.
     * @throws BacklogException
     */
    Repository getGitRepository(Object projectIdOrKey, Object repoIdOrName) throws BacklogException;
}
