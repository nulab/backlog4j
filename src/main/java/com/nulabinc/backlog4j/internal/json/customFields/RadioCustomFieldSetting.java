package com.nulabinc.backlog4j.internal.json.customFields;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class RadioCustomFieldSetting extends CustomFieldSettingJSONImpl {

    private int typeId = 8;
    private ListItemSetting[] items;
    private Boolean allowInput;
    private Boolean allowAddItem;

    @Override
    public int getFieldTypeId() {
        return typeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(typeId);
    }

    public List<ListItemSetting> getItems() {
        return Arrays.asList(items);
    }

    public boolean isAllowInput() {
        return allowInput;
    }

    public boolean isAllowAddItem() {
        return allowAddItem;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("typeId", typeId)
                .append("items", items)
                .append("allowInput", allowInput)
                .append("allowAddItem", allowAddItem)
                .toString();
    }
}
