package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nulabinc.backlog4j.*;

/**
 * @author nulab-inc
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "fieldTypeId")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextCustomField.class, name = "1"),
        @JsonSubTypes.Type(value = TextAreaCustomField.class, name = "2"),
        @JsonSubTypes.Type(value = NumericCustomField.class, name = "3"),
        @JsonSubTypes.Type(value = DateCustomField.class, name = "4"),
        @JsonSubTypes.Type(value = SingleListCustomField.class, name = "5"),
        @JsonSubTypes.Type(value = MultipleListCustomField.class, name = "6"),
        @JsonSubTypes.Type(value = CheckBoxCustomField.class, name = "7"),
        @JsonSubTypes.Type(value = RadioCustomField.class, name = "8") })
public abstract class CustomFieldJSONImpl implements CustomField {

    private int id;
    private String name;

    @Override
    public long getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
}
