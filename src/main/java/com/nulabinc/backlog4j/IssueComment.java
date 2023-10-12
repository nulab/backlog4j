package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * The interface for Backlog issue comment data.
 *
 * @author nulab-inc
 */
public interface IssueComment extends Comment {

    List<ChangeLog> getChangeLog();

    User getCreatedUser();

    Date getCreated();

    Date getUpdated();

    List<Star> getStars();

    List<Notification> getNotifications();
}
