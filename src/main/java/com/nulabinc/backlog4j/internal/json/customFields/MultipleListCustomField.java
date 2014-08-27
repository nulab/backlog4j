package com.nulabinc.backlog4j.internal.json.customFields;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class MultipleListCustomField extends CustomFieldJSONImpl {

    private int fieldTypeId = 6;
    private ListItem[] value;
    private String otherValue;


    @Override
    public int getFieldTypeId() {
        return fieldTypeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(fieldTypeId);
    }

    public List<ListItem> getValue() {
        return Arrays.asList(value);
    }

    public String getOtherValue() {
        return otherValue;
    }
}
