package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for add single list type custom field API.
 *
 * @author nulab-inc
 */
public class AddSingleListCustomFieldParams extends AddCustomFieldParams {

    public AddSingleListCustomFieldParams(long projectId, String name) {
        super(projectId, CustomFieldSetting.FieldType.SingleList, name);
    }

    public AddSingleListCustomFieldParams(String projectKey, String name) {
        super(projectKey, CustomFieldSetting.FieldType.SingleList, name);
    }

    public AddSingleListCustomFieldParams items(List<String> items) {
        for (String item : items) {
            parameters.add(new BasicNameValuePair("items[]", item));
        }
        return this;
    }

    public AddSingleListCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new BasicNameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public AddSingleListCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new BasicNameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public AddSingleListCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (AddSingleListCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public AddSingleListCustomFieldParams description(String description) {
        return (AddSingleListCustomFieldParams)super.description(description);
    }

    @Override
    public AddSingleListCustomFieldParams required(boolean required) {
        return (AddSingleListCustomFieldParams)super.required(required);
    }
}
