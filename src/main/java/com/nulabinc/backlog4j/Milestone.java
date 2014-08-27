package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog milestone data.
 *
 * @author nulab-inc
 */
public interface Milestone {
    long getId();
    long getProjectId();
    String getName();
    String getDescription();
    Date getStartDate();
    Date getReleaseDueDate();
    Boolean getArchived();
}
