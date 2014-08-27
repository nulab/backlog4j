package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog notification data.
 *
 * @author nulab-inc
 */
public interface Notification {
    long getId();

    boolean isAlreadyRead();

    int getReason();

    boolean isResourceAlreadyRead();

    User getSender();

    User getUser();

    Project getProject();

    Issue getIssue();

    IssueComment getComment();

    Date getCreated();

}
