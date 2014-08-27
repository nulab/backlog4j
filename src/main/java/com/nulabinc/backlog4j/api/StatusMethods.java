package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.Status;

/**
 * Executes Backlog Status APIs.
 *
 * @author nulab-inc
 */
public interface StatusMethods {

    /**
     * Returns the statuses.
     *
     * @return the statuses in a list
     * @throws BacklogException
     */
    ResponseList<Status> getStatuses() throws BacklogException;

}
