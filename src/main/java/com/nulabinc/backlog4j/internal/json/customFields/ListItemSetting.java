package com.nulabinc.backlog4j.internal.json.customFields;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class ListItemSetting {

    private long id;
    private String name;
    private Boolean allowInput;
    private int displayOrder;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getAllowInput() {
        return allowInput;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("allowInput", allowInput)
                .append("displayOrder", displayOrder)
                .toString();
    }
}
