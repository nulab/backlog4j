package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;

/**
 * Executes Backlog Star APIs.
 *
 * @author nulab-inc
 */
public interface StarMethods {

    /**
     * Adds a star to the issue.
     *
     * @param issueId the issue identifier
     * @throws BacklogException
     */
    void addStarToIssue(long issueId) throws BacklogException;

    /**
     * Adds a star to the comment.
     *
     * @param commentId the comment identifier
     * @throws BacklogException
     */
    void addStarToComment(long commentId) throws BacklogException;

    /**
     * Adds a star to the wiki.
     *
     * @param wikiId the wiki identifier
     * @throws BacklogException
     */
    void addStarToWiki(long wikiId) throws BacklogException;
}
