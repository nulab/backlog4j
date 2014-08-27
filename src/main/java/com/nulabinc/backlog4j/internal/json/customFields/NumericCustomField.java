package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomBigdecimalDeserializer;

import java.math.BigDecimal;

/**
 * @author nulab-inc
 */
public class NumericCustomField extends CustomFieldJSONImpl {

    private int fieldTypeId = 3;
    @JsonDeserialize(using = JacksonCustomBigdecimalDeserializer.class)
    private BigDecimal value;

    @Override
    public int getFieldTypeId() {
        return fieldTypeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(fieldTypeId);
    }

    public float getFloatValue() {
        return value.floatValue();
    }

    public int getIntValue() {
        return value.intValue();
    }

    public long getLongValue() {
        return value.longValue();
    }
}
