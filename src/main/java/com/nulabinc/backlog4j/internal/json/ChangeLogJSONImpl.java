package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
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

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof ChangeLog) {
            ChangeLog other = (ChangeLog)obj;
            result = new EqualsBuilder().append( field, other.getField() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("field", field)
                .append("newValue", newValue)
                .append("originalValue", originalValue)
                .append("attachmentInfo", attachmentInfo)
                .append("attributeInfo", attributeInfo)
                .append("notificationInfo", notificationInfo)
                .toString();
    }
}
