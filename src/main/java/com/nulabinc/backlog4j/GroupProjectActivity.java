package com.nulabinc.backlog4j;

/**
 * The interface for Backlog group project activity data.
 *
 * @author nulab-inc
 */
public interface GroupProjectActivity {

    long getId();

    String getIdAsString();

    Activity.Type getType();

}
