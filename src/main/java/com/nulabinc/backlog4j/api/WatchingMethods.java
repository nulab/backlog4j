package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Watch;
import com.nulabinc.backlog4j.api.option.UpdateWatchParams;

/**
 * Created by hayashi on 2016/07/26.
 */
public interface WatchingMethods {

    /**
     * Returns the Watch.
     *
     * @param watchingId
     * @return the Watch
     * @throws BacklogException
     */
    Watch getWatch(Long watchingId) throws BacklogException;

    /**
     * Adds a watching to the issue.
     *
     * @param watchingId the issue identifier
     * @param note
     * @throws BacklogException
     */
    void addWatchToIssue(Object watchingId, String note) throws BacklogException;

    /**
     * Updates the existing watching.
     *
     * @param params the updating project parameters
     * @return the updated Watching
     * @throws BacklogException
     */
    Watch updateWatch(UpdateWatchParams params) throws BacklogException;

    /**
     * Deletes the existing watching.
     *
     * @param watchingId the watching identifier
     * @return the deleted watching
     * @throws BacklogException
     */
    Watch deleteWatch(Object watchingId) throws BacklogException;

}
