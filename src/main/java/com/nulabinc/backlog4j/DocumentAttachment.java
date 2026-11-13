package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog Document page's attachment data.
 * <p>
 * The add document attachment API returns the same fields as the attachments of the get document API:
 * {@code id}, {@code name}, {@code size}, {@code createdUser} and {@code created}.
 *
 * @author nulab-inc
 */
public interface DocumentAttachment extends Attachment {

    long getId();

    String getIdAsString();

    /**
     * @return {@code null} with the current API, which no longer returns this field
     * @deprecated The API does not return the document ID. Use the document ID you passed to the API.
     */
    @Deprecated
    String getDocumentId();

    String getName();

    long getSize();

    /**
     * Returns the user who added the attachment.
     *
     * @return the user who added the attachment
     */
    User getCreatedUser();

    /**
     * @return the ID of {@link #getCreatedUser()}
     * @deprecated Use {@link #getCreatedUser()} instead.
     */
    @Deprecated
    Long getCreatedUserId();

    Date getCreated();

    /**
     * @return {@code null} with the current API, which no longer returns this field
     * @deprecated The API does not return this field.
     */
    @Deprecated
    Long getUpdatedUserId();

    /**
     * @return {@code null} with the current API, which no longer returns this field
     * @deprecated The API does not return this field.
     */
    @Deprecated
    Date getUpdated();
}
