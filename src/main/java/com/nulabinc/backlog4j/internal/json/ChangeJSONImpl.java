package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Change;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class ChangeJSONImpl implements Change {

    private String field;
    @JsonProperty("new_value")
    private String newValue;
    @JsonProperty("old_value")
    private String oldValue;
    private String type;

    @Override
    public String getField() {
        return field;
    }

    @Override
    public String getNewValue() {
        return newValue;
    }

    @Override
    public String getOldValue() {
        return oldValue;
    }

    @Override
    public String getType() {
        return type;
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
        ChangeJSONImpl rhs = (ChangeJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.field, rhs.field)
                .append(this.newValue, rhs.newValue)
                .append(this.oldValue, rhs.oldValue)
                .append(this.type, rhs.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(field)
                .append(newValue)
                .append(oldValue)
                .append(type)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("field", field)
                .append("newValue", newValue)
                .append("oldValue", oldValue)
                .append("type", type)
                .toString();
    }
}
