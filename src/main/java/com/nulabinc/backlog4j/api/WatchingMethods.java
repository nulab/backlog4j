package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Watch;
import com.nulabinc.backlog4j.api.option.GetWatchesParams;

/**
 * Created by hayashi on 2016/07/26.
 */
public interface WatchingMethods {
    
    /**
     * Returns the Watch.
     * @param watchingId
     * @return the Watch
     * @throws BacklogException
     */
    Watch getWatch(Long watchingId) throws BacklogException;

    /**
     * Returns the received watch count
     *
     * @param numericUserId the user identifier
     * @param params watch count parameters
     * @return the count of received watch
     * @throws BacklogException
     */
    int getUserWatchCount(Long numericUserId, GetWatchesParams params) throws BacklogException;

}
