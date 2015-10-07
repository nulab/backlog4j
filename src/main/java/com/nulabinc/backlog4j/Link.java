package com.nulabinc.backlog4j;

/**
 * The interface for Backlog link data.
 *
 * @author nulab-inc
 */
public interface Link {

    long getId();

    String getIdAsString();

    long getKeyId();

    String getKeyIdAsString();

    String getTitle();

}
