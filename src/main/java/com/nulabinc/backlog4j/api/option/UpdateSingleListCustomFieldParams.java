package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for update single list type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateSingleListCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateSingleListCustomFieldParams(long projectId, long customFiledId) {
        super(projectId, customFiledId);
    }

    public UpdateSingleListCustomFieldParams(String projectKey, long customFiledId) {
        super(projectKey, customFiledId);
    }

    public UpdateSingleListCustomFieldParams items(List<String> items) {
        if(items != null && items.size() > 0) {
            for (String item : items) {
                parameters.add(new BasicNameValuePair("items[]", item));
            }
        }else{
            parameters.add(new BasicNameValuePair("items[]", ""));
        }
        return this;
    }

    public UpdateSingleListCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new BasicNameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public UpdateSingleListCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new BasicNameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public UpdateSingleListCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (UpdateSingleListCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public UpdateSingleListCustomFieldParams description(String description) {
        return (UpdateSingleListCustomFieldParams)super.description(description);
    }

    @Override
    public UpdateSingleListCustomFieldParams required(boolean required) {
        return (UpdateSingleListCustomFieldParams)super.required(required);
    }
}
