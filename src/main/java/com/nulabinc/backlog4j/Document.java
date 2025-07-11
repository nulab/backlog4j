package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * The interface for Backlog Document page data.
 *
 * @author nulab-inc
 */
public interface Document {

    String getId();

    long getProjectId();

    String getProjectIdAsString();

    String getTitle();

    String getJson();

    String getPlain();

    long getStatusId();

    String getEmoji();

    List<DocumentTag> getTags();

    List<Attachment> getAttachments();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();
}
