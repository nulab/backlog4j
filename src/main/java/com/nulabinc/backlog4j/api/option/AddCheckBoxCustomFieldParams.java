package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.CustomFieldSetting;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add checkbox type custom field API.
 *
 * @author nulab-inc
 */
public class AddCheckBoxCustomFieldParams extends AddCustomFieldParams {

    public AddCheckBoxCustomFieldParams(Object projectIdOrKey, String name) {
        super(projectIdOrKey, CustomFieldSetting.FieldType.CheckBox, name);
    }

    public AddCheckBoxCustomFieldParams items(List<String> items) {
        for (String item : items) {
            parameters.add(new NameValuePair("items[]", item));
        }
        return this;
    }

    public AddCheckBoxCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new NameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public AddCheckBoxCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new NameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }


    @Override
    public AddCheckBoxCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (AddCheckBoxCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public AddCheckBoxCustomFieldParams description(String description) {
        return (AddCheckBoxCustomFieldParams)super.description(description);
    }

    @Override
    public AddCheckBoxCustomFieldParams required(boolean required) {
        return (AddCheckBoxCustomFieldParams)super.required(required);
    }
}
