package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * The interface for Backlog webhook data.
 *
 * @author nulab-inc
 */
public interface Webhook {

    long getId();

    String getName();

    String getDescription();

    String getHookUrl();

    boolean isAllEvent();

    List<Activity.Type> getActivityTypeIds();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();
}
