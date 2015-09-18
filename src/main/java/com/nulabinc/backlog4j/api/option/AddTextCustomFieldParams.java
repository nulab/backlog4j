package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;

/**
 * Parameters for add text type custom field API.
 *
 * @author nulab-inc
 */
public class AddTextCustomFieldParams extends AddCustomFieldParams {

    public AddTextCustomFieldParams(Object projectIdOrKey, String name) {
        super(projectIdOrKey, CustomFieldSetting.FieldType.Text, name);
    }
}
