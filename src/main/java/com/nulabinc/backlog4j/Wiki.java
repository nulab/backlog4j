package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * The interface for Backlog Wiki page data.
 *
 * @author nulab-inc
 */
public interface Wiki {
    long getId();

    long getProjectId();

    String getName();

    String getContent();

    List<WikiTag> getTags();

    List<Attachment> getAttachments();

    List<SharedFile> getSharedFiles();

    List<Star> getStars();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();
}
