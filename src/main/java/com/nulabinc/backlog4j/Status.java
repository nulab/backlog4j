package com.nulabinc.backlog4j;

/**
 * The interface for Backlog status data.
 *
 * @author nulab-inc
 */
public interface Status {

    int getId();

    String getIdAsString();

    String getName();

    Issue.StatusType getStatusType();

    Project.CustomStatusColor getColor();

    long getProjectId();

    String getProjectIdAsString();

    int getDisplayOrder();
}
