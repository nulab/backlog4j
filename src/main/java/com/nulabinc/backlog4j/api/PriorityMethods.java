package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Priority;
import com.nulabinc.backlog4j.ResponseList;

/**
 * Executes Backlog Priority APIs.
 *
 * @author nulab-inc
 */
public interface PriorityMethods {

    /**
     * Returns the priorities.
     *
     * @return the priorities in a list.
     * @throws BacklogException
     */
    ResponseList<Priority> getPriorities() throws BacklogException;

}
