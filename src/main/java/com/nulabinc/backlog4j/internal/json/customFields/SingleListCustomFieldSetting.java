package com.nulabinc.backlog4j.internal.json.customFields;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class SingleListCustomFieldSetting extends CustomFieldSettingJSONImpl {

    private int typeId = 5;
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
}
