package com.nulabinc.backlog4j;

/**
 * The interface for Backlog status data.
 *
 * @author nulab-inc
 */
public interface Status {
    int getId();

    String getName();

    Issue.StatusType getStatus();
}
