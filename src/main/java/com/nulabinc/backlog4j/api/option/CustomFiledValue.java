package com.nulabinc.backlog4j.api.option;

/**
 * Created by yuhkim on 2015/09/17.
 */
public class CustomFiledValue {
    private Object customFieldId;
    private Object customFieldValue;

    public CustomFiledValue(Object customFieldId, Object customFieldValue){
        this.customFieldId = customFieldId;
        this.customFieldValue = customFieldValue;
    }

    public String getCustomFieldId() {
        return customFieldId.toString();
    }

    public String getCustomFieldValue() {
        return customFieldValue == null ? "" : customFieldValue.toString();
    }
}
