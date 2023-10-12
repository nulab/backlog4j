package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for update single list type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateSingleListCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateSingleListCustomFieldParams(Object projectIdOrKey, long customFiledId) {
        super(projectIdOrKey, customFiledId);
    }

    public UpdateSingleListCustomFieldParams items(List<String> items) {
        if (items != null && items.size() > 0) {
            for (String item : items) {
                parameters.add(new NameValuePair("items[]", item));
            }
        } else {
            parameters.add(new NameValuePair("items[]", ""));
        }
        return this;
    }

    public UpdateSingleListCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new NameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public UpdateSingleListCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new NameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public UpdateSingleListCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (UpdateSingleListCustomFieldParams) super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public UpdateSingleListCustomFieldParams description(String description) {
        return (UpdateSingleListCustomFieldParams) super.description(description);
    }

    @Override
    public UpdateSingleListCustomFieldParams required(boolean required) {
        return (UpdateSingleListCustomFieldParams) super.required(required);
    }
}
