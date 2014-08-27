package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Resolution;
import com.nulabinc.backlog4j.ResponseList;

/**
 * Executes Backlog Resolution APIs.
 *
 * @author nulab-inc
 */
public interface ResolutionMethods {

    /**
     * Returns the resolutions.
     *
     * @return the resolutions in a list
     * @throws BacklogException
     */
    ResponseList<Resolution> getResolutions() throws BacklogException;

}
