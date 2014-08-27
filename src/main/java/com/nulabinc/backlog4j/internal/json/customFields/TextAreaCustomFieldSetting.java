package com.nulabinc.backlog4j.internal.json.customFields;

/**
 * @author nulab-inc
 */
public class TextAreaCustomFieldSetting extends CustomFieldSettingJSONImpl {

    private int typeId = 2;
    @Override
    public int getFieldTypeId() {
        return typeId;
    }

    @Override
    public FieldType getFieldType() {
        return FieldType.valueOf(typeId);
    }


}
