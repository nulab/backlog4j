package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.CustomFieldListItemSetting;
import com.nulabinc.backlog4j.internal.json.JacksonCustomBigdecimalDeserializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
        NumericCustomFieldSetting rhs = (NumericCustomFieldSetting) obj;
        return new EqualsBuilder()
                .append(getId(), rhs.getId())
                .append(getName(), rhs.getName())
                .append(this.typeId, rhs.typeId)
                .append(this.min, rhs.min)
                .append(this.max, rhs.max)
                .append(this.initialValue, rhs.initialValue)
                .append(this.unit, rhs.unit)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getName())
                .append(typeId)
                .append(min)
                .append(max)
                .append(initialValue)
                .append(unit)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("name", getName())
                .append("typeId", typeId)
                .append("min", min)
                .append("max", max)
                .append("initialValue", initialValue)
                .append("unit", unit)
                .toString();
    }

    @Override
    public List<? extends CustomFieldListItemSetting> getItems() {
        return null;
    }
}
