package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.AttachmentInfo;
import com.nulabinc.backlog4j.ChangeLog;

/**
 * @author nulab-inc
 */
public class ChangeLogJSONImpl implements ChangeLog {

    private String field;
    @JsonProperty("new_value")
    private String newValue;
    @JsonProperty("old_value")
    private String oldValue;
    private AttachmentInfo attachmentInfo;
    private String attributeInfo;
    private String notificationInfo;

    @Override
    public String getField() {
        return field;
    }

    @Override
    public String getNewValue() {
        return newValue;
    }

    @Override
    public String getOldValue() {
        return oldValue;
    }

    @Override
    public AttachmentInfo getAttachmentInfo() {
        return attachmentInfo;
    }

    @Override
    public String getAttributeInfo() {
        return attributeInfo;
    }

    @Override
    public String getNotificationInfo() {
        return notificationInfo;
    }
}
