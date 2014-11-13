package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.w3c.dom.Attr;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ChangeLogJSONImpl rhs = (ChangeLogJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.field, rhs.field)
                .append(this.newValue, rhs.newValue)
                .append(this.originalValue, rhs.originalValue)
                .append(this.attachmentInfo, rhs.attachmentInfo)
                .append(this.attributeInfo, rhs.attributeInfo)
                .append(this.notificationInfo, rhs.notificationInfo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(field)
                .append(newValue)
                .append(originalValue)
                .append(attachmentInfo)
                .append(attributeInfo)
                .append(notificationInfo)
                .toHashCode();
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
