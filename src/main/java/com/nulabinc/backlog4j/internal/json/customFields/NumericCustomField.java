package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomBigdecimalDeserializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public BigDecimal getValue() {
        return value;
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        NumericCustomField rhs = (NumericCustomField) obj;
        return new EqualsBuilder()
                .append(this.fieldTypeId, rhs.fieldTypeId)
                .append(this.value, rhs.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(fieldTypeId)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fieldTypeId", fieldTypeId)
                .append("value", value)
                .toString();
    }
}
