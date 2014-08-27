package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for add multiple list type custom field API.
 *
 * @author nulab-inc
 */
public class AddMultipleListCustomFieldParams extends AddCustomFieldParams {

    public AddMultipleListCustomFieldParams(long projectId, String name) {
        super(projectId, CustomFieldSetting.FieldType.MultipleList, name);
    }

    public AddMultipleListCustomFieldParams(String projectKey, String name) {
        super(projectKey, CustomFieldSetting.FieldType.MultipleList, name);
    }

    public AddMultipleListCustomFieldParams items(List<String> items) {
        for (String item : items) {
            parameters.add(new BasicNameValuePair("items[]", item));
        }
        return this;
    }

    public AddMultipleListCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new BasicNameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public AddMultipleListCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new BasicNameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public AddMultipleListCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (AddMultipleListCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public AddMultipleListCustomFieldParams description(String description) {
        return (AddMultipleListCustomFieldParams)super.description(description);
    }

    @Override
    public AddMultipleListCustomFieldParams required(boolean required) {
        return (AddMultipleListCustomFieldParams)super.required(required);
    }
}
