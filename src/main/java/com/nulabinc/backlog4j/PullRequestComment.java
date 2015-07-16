package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * Created by yuhkim on 2015/05/18.
 */
public interface PullRequestComment {
    long getId();

    String getContent();

    List<ChangeLog> getChangeLog();

    User getCreatedUser();

    Date getCreated();

    Date getUpdated();

    List<Star> getStars();

    List<Notification> getNotifications();

}
