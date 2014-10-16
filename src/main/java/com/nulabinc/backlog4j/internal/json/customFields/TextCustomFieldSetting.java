package com.nulabinc.backlog4j.internal.json.customFields;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class TextCustomFieldSetting extends CustomFieldSettingJSONImpl {

    private int typeId = 1;

    @Override
    public int getFieldTypeId() {
        return typeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(typeId);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("typeId", typeId)
                .toString();
    }
}
