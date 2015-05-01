package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog attachment file.
 *
 * @author nulab-inc
 */
public interface Attachment {

    long getId();

    String getName();

    long getSize();

    User getCreatedUser();

    Date getCreated();

    boolean isImage();

}
