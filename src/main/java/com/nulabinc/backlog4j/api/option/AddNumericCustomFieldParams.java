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

    public AddNumericCustomFieldParams(String projectIdOrKey, String name) {
        super(projectIdOrKey, CustomFieldSetting.FieldType.Numeric, name);
    }

    public AddNumericCustomFieldParams min(float min) {
        parameters.add(new NameValuePair("min", Float.toString(min)));
        return this;
    }

    public AddNumericCustomFieldParams max(float max) {
        parameters.add(new NameValuePair("max", Float.toString(max)));
        return this;
    }

    public AddNumericCustomFieldParams initialValue(float initialValue) {
        parameters.add(new NameValuePair("initialValue", Float.toString(initialValue)));
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
