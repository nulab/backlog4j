package com.nulabinc.backlog4j.api.option;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhkim on 2015/09/17.
 */
public class CustomFiledItems {
    private Object customFieldId;
    private List<String> customFieldItemIds;

    public CustomFiledItems(Object customFieldId, List ids) {
        this.customFieldId = customFieldId;
        this.customFieldItemIds = new ArrayList<>();
        for (Object id : ids) {
            this.customFieldItemIds.add(id.toString());
        }
    }

    public String getCustomFieldId() {
        return customFieldId.toString();
    }

    public List<String> getCustomFieldItemIds() {
        return customFieldItemIds;
    }
}
