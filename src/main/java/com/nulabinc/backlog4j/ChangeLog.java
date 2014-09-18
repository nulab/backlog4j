package com.nulabinc.backlog4j;

/**
 * The interface for Backlog changeLog data.
 *
 * @author nulab-inc
 */
public interface ChangeLog {

    // status assigner resolution priority component milestone version issueType
    String getField();

    String getNewValue();

    String getOriginalValue();

    AttachmentInfo getAttachmentInfo();

    AttributeInfo getAttributeInfo();

    NotificationInfo getNotificationInfo();


}
