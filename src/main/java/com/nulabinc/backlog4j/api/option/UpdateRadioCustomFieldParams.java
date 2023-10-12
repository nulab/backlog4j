package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for update radio type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateRadioCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateRadioCustomFieldParams(Object projectIdOrKey, Object customFiledId) {
        super(projectIdOrKey, customFiledId);
    }

    public UpdateRadioCustomFieldParams items(List<String> items) {
        if (items != null && items.size() > 0) {
            for (String item : items) {
                parameters.add(new NameValuePair("items[]", item));
            }
        } else {
            parameters.add(new NameValuePair("items[]", ""));
        }
        return this;
    }

    public UpdateRadioCustomFieldParams allowInput(boolean allowInput) {
        parameters.add(new NameValuePair("allowInput", String.valueOf(allowInput)));
        return this;
    }

    public UpdateRadioCustomFieldParams allowAddItem(boolean allowAddItem) {
        parameters.add(new NameValuePair("allowAddItem", String.valueOf(allowAddItem)));
        return this;
    }

    @Override
    public UpdateRadioCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (UpdateRadioCustomFieldParams) super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public UpdateRadioCustomFieldParams description(String description) {
        return (UpdateRadioCustomFieldParams) super.description(description);
    }

    @Override
    public UpdateRadioCustomFieldParams required(boolean required) {
        return (UpdateRadioCustomFieldParams) super.required(required);
    }
}
