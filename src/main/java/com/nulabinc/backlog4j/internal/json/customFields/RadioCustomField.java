package com.nulabinc.backlog4j.internal.json.customFields;

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
}
