package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.CustomFieldListItemSetting;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextAreaCustomFieldSetting extends CustomFieldSettingJSONImpl {

    private int typeId = 2;

    @Override
    public int getFieldTypeId() {
        return typeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(typeId);
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
        TextAreaCustomFieldSetting rhs = (TextAreaCustomFieldSetting) obj;
        return new EqualsBuilder()
                .append(getId(), rhs.getId())
                .append(getName(), rhs.getName())
                .append(this.typeId, rhs.typeId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getName())
                .append(typeId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("name", getName())
                .append("typeId", typeId)
                .toString();
    }

    @Override
    public List<? extends CustomFieldListItemSetting> getItems() {
        return null;
    }
}
