package com.nulabinc.backlog4j;

/**
 * The interface for Backlog resolution data.
 *
 * @author nulab-inc
 */
public interface Resolution {

    long getId();

    String getIdAsString();

    String getName();

    Issue.ResolutionType getResolutionType();
}
