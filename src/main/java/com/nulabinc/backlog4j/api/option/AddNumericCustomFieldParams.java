package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add numeric type custom field API.
 *
 * @author nulab-inc
 */
public class AddNumericCustomFieldParams extends AddCustomFieldParams {

    public AddNumericCustomFieldParams(long projectId, String name) {
        super(projectId, CustomFieldSetting.FieldType.Numeric, name);
    }

    public AddNumericCustomFieldParams(String projectKey, String name) {
        super(projectKey, CustomFieldSetting.FieldType.Numeric, name);
    }

    public AddNumericCustomFieldParams min(float min) {
        parameters.add(new NameValuePair("min", String.valueOf(min)));
        return this;
    }

    public AddNumericCustomFieldParams max(float max) {
        parameters.add(new NameValuePair("max", String.valueOf(max)));
        return this;
    }

    public AddNumericCustomFieldParams initialValue(float initialValue) {
        parameters.add(new NameValuePair("initialValue", String.valueOf(initialValue)));
        return this;
    }

    public AddNumericCustomFieldParams unit(String unit) {
        parameters.add(new NameValuePair("unit", unit));
        return this;
    }

    @Override
    public AddNumericCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (AddNumericCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public AddNumericCustomFieldParams description(String description) {
        return (AddNumericCustomFieldParams)super.description(description);
    }

    @Override
    public AddNumericCustomFieldParams required(boolean required) {
        return (AddNumericCustomFieldParams)super.required(required);
    }
}
