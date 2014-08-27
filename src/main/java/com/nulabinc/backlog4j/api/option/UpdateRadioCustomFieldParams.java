package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for update radio type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateRadioCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateRadioCustomFieldParams(long projectId, long customFiledId) {
        super(projectId, customFiledId);
    }

    public UpdateRadioCustomFieldParams(String projectKey, long customFiledId) {
        super(projectKey, customFiledId);
    }

    public UpdateRadioCustomFieldParams items(List<String> items) {
        if(items != null && items.size() > 0) {
            for (String item : items) {
                parameters.add(new BasicNameValuePair("items[]", item));
            }
        }else{
            parameters.add(new BasicNameValuePair("items[]", ""));
        }
        return this;
    }

    public UpdateRadioCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new BasicNameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public UpdateRadioCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new BasicNameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public UpdateRadioCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (UpdateRadioCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public UpdateRadioCustomFieldParams description(String description) {
        return (UpdateRadioCustomFieldParams)super.description(description);
    }

    @Override
    public UpdateRadioCustomFieldParams required(boolean required) {
        return (UpdateRadioCustomFieldParams)super.required(required);
    }
}
