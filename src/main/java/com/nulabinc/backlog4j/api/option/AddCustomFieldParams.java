package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.CustomFieldSetting;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add custom field API.
 *
 * @author nulab-inc
 */
public abstract class AddCustomFieldParams extends PostParams {

    private Object projectIdOrKey;

    public AddCustomFieldParams(Object projectIdOrKey, CustomFieldSetting.FieldType fieldType, String name){
        this.projectIdOrKey = projectIdOrKey;
        parameters.add(new NameValuePair("typeId", String.valueOf(fieldType.getIntValue())));
        parameters.add(new NameValuePair("name", name));
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public AddCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        for (Long applicableIssueType :applicableIssueTypes) {
            parameters.add(new NameValuePair("applicableIssueTypes[]", String.valueOf(applicableIssueType)));
        }
        return this;
    }

    public AddCustomFieldParams description(String description) {
        parameters.add(new NameValuePair("description", description));
        return this;
    }

    public AddCustomFieldParams required(boolean required) {
        parameters.add(new NameValuePair("required", String.valueOf(required)));
        return this;
    }

}
