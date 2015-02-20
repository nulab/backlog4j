package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomDateDeserializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateCustomField extends CustomFieldJSONImpl {

    private int fieldTypeId = 4;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date value;

    @Override
    public int getFieldTypeId() {
        return fieldTypeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(fieldTypeId);
    }

    public Date getValue() {
        return value;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("name", getName())
                .append("fieldTypeId", fieldTypeId)
                .append("value", value)
                .toString();
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
        DateCustomField rhs = (DateCustomField) obj;
        return new EqualsBuilder()
                .append(getId(), rhs.getId())
                .append(getName(), rhs.getName())
                .append(this.fieldTypeId, rhs.fieldTypeId)
                .append(this.value, rhs.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getName())
                .append(fieldTypeId)
                .append(value)
                .toHashCode();
    }
}
