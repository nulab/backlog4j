package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog viewed issue data.
 *
 * @author nulab-inc
 */
public interface ViewedIssue {
    Issue getIssue();

    Date getUpdated();
}
