package com.nulabinc.backlog4j;

/**
 * The interface for Backlog posted attachment file.
 *
 * @author nulab-inc
 */
public interface PostedAttachment {

    long getId();

    String getIdAsString();

    String getName();

    long getSize();

}
