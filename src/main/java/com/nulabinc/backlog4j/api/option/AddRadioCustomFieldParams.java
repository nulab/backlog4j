package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add radio type custom field API.
 *
 * @author nulab-inc
 */
public class AddRadioCustomFieldParams extends AddCustomFieldParams {

    public AddRadioCustomFieldParams(Object projectIdOrKey, String name) {
        super(projectIdOrKey, CustomFieldSetting.FieldType.Radio, name);
    }

    public AddRadioCustomFieldParams items(List<String> items) {
        for (String item : items) {
            parameters.add(new NameValuePair("items[]", item));
        }
        return this;
    }

    public AddRadioCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new NameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public AddRadioCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new NameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public AddRadioCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (AddRadioCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public AddRadioCustomFieldParams description(String description) {
        return (AddRadioCustomFieldParams)super.description(description);
    }

    @Override
    public AddRadioCustomFieldParams required(boolean required) {
        return (AddRadioCustomFieldParams)super.required(required);
    }
}
