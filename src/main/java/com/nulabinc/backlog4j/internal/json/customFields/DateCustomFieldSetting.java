package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.CustomFieldListItemSetting;
import com.nulabinc.backlog4j.internal.json.JacksonCustomDateDeserializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateCustomFieldSetting extends CustomFieldSettingJSONImpl {

    public enum InitialValueType {
        Today(1), TodayPlusShiftDays(2), FixedDate(3);

        InitialValueType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static InitialValueType valueOf(final int anIntValue) {
            for (InitialValueType d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return null;
        }

        private int intValue;
    }

    private int typeId = 4;
    private long[] applicableIssueTypes;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private java.util.Date min;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private java.util.Date max;
    private DateValueSetting initialDate;

    @Override
    public int getFieldTypeId() {
        return typeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(typeId);
    }

    @Override
    public long[] getApplicableIssueTypes() {
        return applicableIssueTypes;
    }

    @Override
    public List<? extends CustomFieldListItemSetting> getItems() {
        return null;
    }

    public java.util.Date getMin() {
        return min;
    }

    public java.util.Date getMax() {
        return max;
    }

    public DateValueSetting getInitialDate() {
        return initialDate;
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
        DateCustomFieldSetting rhs = (DateCustomFieldSetting) obj;
        return new EqualsBuilder()
                .append(getId(), rhs.getId())
                .append(getName(), rhs.getName())
                .append(this.typeId, rhs.typeId)
                .append(this.applicableIssueTypes, rhs.applicableIssueTypes)
                .append(this.min, rhs.min)
                .append(this.max, rhs.max)
                .append(this.initialDate, rhs.initialDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getName())
                .append(typeId)
                .append(applicableIssueTypes)
                .append(min)
                .append(max)
                .append(initialDate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("name", getName())
                .append("typeId", typeId)
                .append("applicableIssueTypes", applicableIssueTypes)
                .append("min", min)
                .append("max", max)
                .append("initialDate", initialDate)
                .toString();
    }


}
