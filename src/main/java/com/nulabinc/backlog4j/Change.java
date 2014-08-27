package com.nulabinc.backlog4j;

/**
 * The interface for Backlog change data.
 *
 * @author nulab-inc
 */
public interface Change {
    String getField();

    String getNewValue();

    String getOldValue();

    String getType();


}
