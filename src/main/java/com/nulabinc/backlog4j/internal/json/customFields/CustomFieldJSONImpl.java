package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
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
        CustomFieldJSONImpl rhs = (CustomFieldJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .toHashCode();
    }
}
