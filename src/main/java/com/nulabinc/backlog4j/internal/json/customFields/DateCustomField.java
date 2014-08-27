package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.internal.json.JacksonCustomDateDeserializer;

import java.util.Date;

/**
 * @author nulab-inc
 */
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
}
