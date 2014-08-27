package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for add checkbox type custom field API.
 *
 * @author nulab-inc
 */
public class AddCheckBoxCustomFieldParams extends AddCustomFieldParams {

    public AddCheckBoxCustomFieldParams(long projectId, String name) {
        super(projectId, CustomFieldSetting.FieldType.CheckBox, name);
    }

    public AddCheckBoxCustomFieldParams(String projectKey, String name) {
        super(projectKey, CustomFieldSetting.FieldType.CheckBox, name);
    }

    public AddCheckBoxCustomFieldParams items(List<String> items) {
        for (String item : items) {
            parameters.add(new BasicNameValuePair("items[]", item));
        }
        return this;
    }

    public AddCheckBoxCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new BasicNameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public AddCheckBoxCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new BasicNameValuePair("allowAddItem", String.valueOf(allowAddItem)));
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
