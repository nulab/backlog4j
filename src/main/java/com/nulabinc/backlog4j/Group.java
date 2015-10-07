package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * The interface for Backlog group data.
 *
 * @author nulab-inc
 */
public interface Group {

    long getId();

    String getIdAsString();

    String getName();

    List<User> getMembers();

    long getDisplayOrder();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();

}
