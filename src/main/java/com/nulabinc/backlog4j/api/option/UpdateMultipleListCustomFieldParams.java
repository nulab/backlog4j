package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for update multiple list type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateMultipleListCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateMultipleListCustomFieldParams(long projectId, long customFiledId) {
        super(projectId, customFiledId);
    }

    public UpdateMultipleListCustomFieldParams(String projectKey, long customFiledId) {
        super(projectKey, customFiledId);
    }

    public UpdateMultipleListCustomFieldParams items(List<String> items) {
        if(items != null && items.size() > 0) {
            for (String item : items) {
                parameters.add(new BasicNameValuePair("items[]", item));
            }
        }else{
            parameters.add(new BasicNameValuePair("items[]", ""));
        }
        return this;
    }

    public UpdateMultipleListCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new BasicNameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public UpdateMultipleListCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new BasicNameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public UpdateMultipleListCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (UpdateMultipleListCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public UpdateMultipleListCustomFieldParams description(String description) {
        return (UpdateMultipleListCustomFieldParams)super.description(description);
    }

    @Override
    public UpdateMultipleListCustomFieldParams required(boolean required) {
        return (UpdateMultipleListCustomFieldParams)super.required(required);
    }
}
