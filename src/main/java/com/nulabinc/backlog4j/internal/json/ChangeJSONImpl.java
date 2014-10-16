package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Change;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
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
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Change) {
            Change other = (Change)obj;
            result = new EqualsBuilder().append( field, other.getField())
                    .append( type, other.getType() )
                    .isEquals();
        }
        return result;
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
