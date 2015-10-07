package com.nulabinc.backlog4j.api.option;

/**
 * Created by yuhkim on 2015/09/17.
 */
public class CustomFiledItem {
    private Object customFieldId;
    private Object customFieldItemId;

    public CustomFiledItem(Object customFieldId, Object customFieldItemId){
        this.customFieldId = customFieldId;
        this.customFieldItemId = customFieldItemId;
    }

    public String getCustomFieldId() {
        return customFieldId.toString();
    }

    public String getCustomFieldItemId() {
        return customFieldItemId.toString();
    }
}
