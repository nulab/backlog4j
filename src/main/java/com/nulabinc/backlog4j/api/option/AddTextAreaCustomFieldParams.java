package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;

/**
 * Parameters for add text area type custom field API.
 *
 * @author nulab-inc
 */
public class AddTextAreaCustomFieldParams extends AddCustomFieldParams {

    public AddTextAreaCustomFieldParams(Object projectIdOrKey, String name) {
        super(projectIdOrKey, CustomFieldSetting.FieldType.TextArea, name);
    }
}
