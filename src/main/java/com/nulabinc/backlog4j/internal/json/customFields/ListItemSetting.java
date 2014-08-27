package com.nulabinc.backlog4j.internal.json.customFields;

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
}
