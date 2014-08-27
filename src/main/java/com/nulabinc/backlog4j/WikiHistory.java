package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog Wiki page history data.
 *
 * @author nulab-inc
 */
public interface WikiHistory {
    long getPageId();

    int getVersion();

    String getName();

    String getContent();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();
}
