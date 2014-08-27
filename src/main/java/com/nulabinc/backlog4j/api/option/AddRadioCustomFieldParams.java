package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for add radio type custom field API.
 *
 * @author nulab-inc
 */
public class AddRadioCustomFieldParams extends AddCustomFieldParams {

    public AddRadioCustomFieldParams(long projectId, String name) {
        super(projectId, CustomFieldSetting.FieldType.Radio, name);
    }

    public AddRadioCustomFieldParams(String projectKey, String name) {
        super(projectKey, CustomFieldSetting.FieldType.Radio, name);
    }

    public AddRadioCustomFieldParams items(List<String> items) {
        for (String item : items) {
            parameters.add(new BasicNameValuePair("items[]", item));
        }
        return this;
    }

    public AddRadioCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new BasicNameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public AddRadioCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new BasicNameValuePair("allowAddItem", String.valueOf(allowAddItem)));
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
