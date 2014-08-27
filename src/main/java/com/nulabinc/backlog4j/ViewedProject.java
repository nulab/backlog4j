package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog viewed project data.
 *
 * @author nulab-inc
 */
public interface ViewedProject {
    Project getProject();

    Date getUpdated();
}
