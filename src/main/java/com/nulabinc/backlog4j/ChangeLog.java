package com.nulabinc.backlog4j;

/**
 * The interface for Backlog changeLog data.
 *
 * @author nulab-inc
 */
public interface ChangeLog {
    String getField();

    String getNewValue();

    String getOriginalValue();

    AttachmentInfo getAttachmentInfo();

    String getAttributeInfo(); // todo change string to model

    NotificationInfo getNotificationInfo();


}
