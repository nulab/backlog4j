package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomDateDeserializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class DateValueSetting {

    private long id;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private java.util.Date date;
    private int shift;

    public long getId() {
        return id;
    }

    public java.util.Date getDate() {
        return date;
    }

    public int getShift() {
        return shift;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("date", date)
                .append("shift", shift)
                .toString();
    }
}
