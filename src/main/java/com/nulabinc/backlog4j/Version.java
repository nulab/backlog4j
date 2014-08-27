package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog version data.
 *
 * @author nulab-inc
 */
public interface Version {
    long getId();
    long getProjectId();
    String getName();
    String getDescription();
    Date getStartDate();
    Date getReleaseDueDate();
    Boolean getArchived();
}
