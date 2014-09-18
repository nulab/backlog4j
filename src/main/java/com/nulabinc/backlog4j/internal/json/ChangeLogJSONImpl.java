package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.AttachmentInfo;
import com.nulabinc.backlog4j.AttributeInfo;
import com.nulabinc.backlog4j.ChangeLog;
import com.nulabinc.backlog4j.NotificationInfo;
import org.w3c.dom.Attr;

/**
 * @author nulab-inc
 */
public class ChangeLogJSONImpl implements ChangeLog {

    private String field;
    private String newValue;
    private String originalValue;
    @JsonDeserialize(as=AttachmentInfoJSONImpl.class)
    private AttachmentInfo attachmentInfo;
    @JsonDeserialize(as=AttributeInfoJSONImpl.class)
    private AttributeInfo attributeInfo;
    @JsonDeserialize(as=NotificationInfoJSONImpl.class)
    private NotificationInfo notificationInfo;

    @Override
    public String getField() {
        return field;
    }

    @Override
    public String getNewValue() {
        return newValue;
    }

    @Override
    public String getOriginalValue() {
        return originalValue;
    }

    @Override
    public AttachmentInfo getAttachmentInfo() {
        return attachmentInfo;
    }

    @Override
    public AttributeInfo getAttributeInfo() {
        return attributeInfo;
    }

    @Override
    public NotificationInfo getNotificationInfo() {
        return notificationInfo;
    }
}
