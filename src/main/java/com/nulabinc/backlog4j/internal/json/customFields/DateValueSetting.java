package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomDateDeserializer;

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
}
