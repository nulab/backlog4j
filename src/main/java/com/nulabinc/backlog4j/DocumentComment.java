package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * The interface for Backlog Document page's comment data.
 *
 * @author nulab-inc
 */
public interface DocumentComment {

    String getId();

    String getDocumentId();

    long getStatusId();

    String getContent();

    String getPlain();

    String getCommentType();

    User getCreatedUser();

    Date getCreated();

    Date getUpdated();

    List<DocumentCommentReply> getReplies();
}
