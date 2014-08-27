package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomBigdecimalDeserializer;

import java.math.BigDecimal;

/**
 * @author nulab-inc
 */
public class NumericCustomFieldSetting extends CustomFieldSettingJSONImpl {

    private int typeId = 3;
    @JsonDeserialize(using = JacksonCustomBigdecimalDeserializer.class)
    private BigDecimal min;
    @JsonDeserialize(using = JacksonCustomBigdecimalDeserializer.class)
    private BigDecimal max;
    @JsonDeserialize(using = JacksonCustomBigdecimalDeserializer.class)
    private BigDecimal initialValue;
    private String unit;

    @Override
    public int getFieldTypeId() {
        return typeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(typeId);
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public BigDecimal getInitialValue() {
        return initialValue;
    }

    public String getUnit() {
        return unit;
    }
}
