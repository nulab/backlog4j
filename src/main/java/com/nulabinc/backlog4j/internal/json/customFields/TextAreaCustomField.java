package com.nulabinc.backlog4j.internal.json.customFields;

/**
 * @author nulab-inc
 */
public class TextAreaCustomField extends CustomFieldJSONImpl {

    private int fieldTypeId = 2;
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
