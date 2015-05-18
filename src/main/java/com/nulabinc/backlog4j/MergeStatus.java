package com.nulabinc.backlog4j;

/**
 * The interface for Backlog pullrequest status data.
 *
 * @author nulab-inc
 */
public interface MergeStatus {
    int getId();

    String getName();

    PullRequest.StatusType getStatus();
}
