package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.Status;
import com.nulabinc.backlog4j.api.option.AddStatusParams;
import com.nulabinc.backlog4j.api.option.UpdateStatusParams;

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

    /**
     * Add status in the project.
     *
     * @param params the adding status parameters.
     * @return the added status
     * @throws BacklogException
     */
    Status addStatus(AddStatusParams params) throws BacklogException;

    /**
     * Updates the existing status in the project.
     *
     * @param params the updating status parameters.
     * @return the updated status
     * @throws BacklogException
     */
    Status updateStatus(UpdateStatusParams params) throws BacklogException;

}
