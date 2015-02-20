package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RadioCustomFieldSetting extends CustomFieldSettingJSONImpl {

    private int typeId = 8;
    private ListItemSetting[] items;
    private Boolean allowInput;
    private Boolean allowAddItem;

    @Override
    public int getFieldTypeId() {
        return typeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(typeId);
    }

    public List<ListItemSetting> getItems() {
        return Arrays.asList(items);
    }

    public boolean isAllowInput() {
        return allowInput;
    }

    public boolean isAllowAddItem() {
        return allowAddItem;
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
        RadioCustomFieldSetting rhs = (RadioCustomFieldSetting) obj;
        return new EqualsBuilder()
                .append(getId(), rhs.getId())
                .append(getName(), rhs.getName())
                .append(this.typeId, rhs.typeId)
                .append(this.items, rhs.items)
                .append(this.allowInput, rhs.allowInput)
                .append(this.allowAddItem, rhs.allowAddItem)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getName())
                .append(typeId)
                .append(items)
                .append(allowInput)
                .append(allowAddItem)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("name", getName())
                .append("typeId", typeId)
                .append("items", items)
                .append("allowInput", allowInput)
                .append("allowAddItem", allowAddItem)
                .toString();
    }
}
