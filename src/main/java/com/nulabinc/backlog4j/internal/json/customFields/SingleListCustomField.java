package com.nulabinc.backlog4j.internal.json.customFields;

/**
 * @author nulab-inc
 */
public class SingleListCustomField extends CustomFieldJSONImpl {

    private int fieldTypeId = 5;
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
