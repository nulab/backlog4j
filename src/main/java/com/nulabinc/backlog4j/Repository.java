package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog repository data.
 *
 * @author nulab-inc
 */
public interface Repository {
    long getId();

    long getProjectId();

    String getName();

    String getDescription();

    String getHookUrl();

    String getHttpUrl();

    String getSshUrl();

    long getDisplayOrder();

    Date getPushedAt();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();
}
