package com.nulabinc.backlog4j;

/**
 * The interface for Backlog attachment file.
 *
 * @author nulab-inc
 */
public interface AttachmentInfo {

    long getId();

    String getIdAsString();

    String getName();

    boolean isImage();
}
