package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog Document page's attachment data.
 *
 * @author nulab-inc
 */
public interface DocumentAttachment {

    long getId();

    String getIdAsString();

    String getDocumentId();

    String getName();

    long getSize();

    Long getCreatedUserId();

    Date getCreated();

    Long getUpdatedUserId();

    Date getUpdated();
}
