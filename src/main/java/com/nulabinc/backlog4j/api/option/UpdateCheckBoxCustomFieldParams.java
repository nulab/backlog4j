package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for update checkbox type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateCheckBoxCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateCheckBoxCustomFieldParams(long projectId, long customFiledId) {
        super(projectId, customFiledId);
    }

    public UpdateCheckBoxCustomFieldParams(String projectKey, long customFiledId) {
        super(projectKey, customFiledId);
    }

    public UpdateCheckBoxCustomFieldParams items(List<String> items) {
        if(items != null && items.size() > 0) {
            for (String item : items) {
                parameters.add(new NameValuePair("items[]", item));
            }
        }else{
            parameters.add(new NameValuePair("items[]", ""));
        }
        return this;
    }

    public UpdateCheckBoxCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new NameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public UpdateCheckBoxCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new NameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public UpdateCheckBoxCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (UpdateCheckBoxCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public UpdateCheckBoxCustomFieldParams description(String description) {
        return (UpdateCheckBoxCustomFieldParams)super.description(description);
    }

    @Override
    public UpdateCheckBoxCustomFieldParams required(boolean required) {
        return (UpdateCheckBoxCustomFieldParams)super.required(required);
    }
}
