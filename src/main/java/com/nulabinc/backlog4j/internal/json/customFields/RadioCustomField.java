package com.nulabinc.backlog4j.internal.json.customFields;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class RadioCustomField extends CustomFieldJSONImpl {

    private int fieldTypeId = 8;
    private ListItem value;
    private String otherValue;

    @Override
    public int getFieldTypeId() {
        return fieldTypeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(fieldTypeId);
    }

    public ListItem getValue() {
        return value;
    }

    public String getOtherValue() {
        return otherValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("fieldTypeId", fieldTypeId)
                .append("value", value)
                .append("otherValue", otherValue)
                .toString();
    }
}
