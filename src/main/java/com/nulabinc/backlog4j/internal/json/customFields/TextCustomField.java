package com.nulabinc.backlog4j.internal.json.customFields;

/**
 * @author nulab-inc
 */
public class TextCustomField extends CustomFieldJSONImpl {

    private int fieldTypeId = 1;
    private String value;

    @Override
    public int getFieldTypeId() {
        return fieldTypeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(fieldTypeId);
    }

    public String getValue() {
        return value;
    }
}
