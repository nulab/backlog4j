package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog Document page's comment reply data.
 *
 * @author nulab-inc
 */
public interface DocumentCommentReply {

    String getId();

    String getDocumentId();

    String getCommentId();

    String getContent();

    String getPlain();

    User getCreatedUser();

    Date getCreated();

    Date getUpdated();
}
