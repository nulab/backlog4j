package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomDateDeserializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class DateCustomFieldSetting extends CustomFieldSettingJSONImpl {

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("typeId", typeId)
                .append("applicableIssueTypes", applicableIssueTypes)
                .append("min", min)
                .append("max", max)
                .append("initialDate", initialDate)
                .toString();
    }

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

    public java.util.Date getMin() {
        return min;
    }

    public java.util.Date getMax() {
        return max;
    }

    public DateValueSetting getInitialDate() {
        return initialDate;
    }

}
