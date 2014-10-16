package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomBigdecimalDeserializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("fieldTypeId", fieldTypeId)
                .append("value", value)
                .toString();
    }
}
