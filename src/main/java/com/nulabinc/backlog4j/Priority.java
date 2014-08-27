package com.nulabinc.backlog4j;

/**
 * The interface for Backlog priority data.
 *
 * @author nulab-inc
 */
public interface Priority {
    long getId();

    String getName();

    Issue.PriorityType getPriority();
}
