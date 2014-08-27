package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Change;

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
    public String toString() {
        return "ProjectJSONImpl extends " + super.toString();
    }


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


}
