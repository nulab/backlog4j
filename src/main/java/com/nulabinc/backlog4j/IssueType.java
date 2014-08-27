package com.nulabinc.backlog4j;

/**
 * The interface for Backlog issue type data.
 *
 * @author nulab-inc
 */
public interface IssueType {
    long getId();

    long getProjectId();

    String getName();

    Project.IssueTypeColor getColor();
}
