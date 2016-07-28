package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Watch;

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
    
}
