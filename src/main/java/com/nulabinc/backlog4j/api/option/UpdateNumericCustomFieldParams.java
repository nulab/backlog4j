package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for update numeric type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateNumericCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateNumericCustomFieldParams(long projectId, long customFiledId) {
        super(projectId, customFiledId);
    }

    public UpdateNumericCustomFieldParams(String projectKey, long customFiledId) {
        super(projectKey, customFiledId);
    }

    public UpdateNumericCustomFieldParams min(float min) {
        parameters.add(new NameValuePair("min", Float.toString(min)));
        return this;
    }

    public UpdateNumericCustomFieldParams max(float max) {
        parameters.add(new NameValuePair("max", Float.toString(max)));
        return this;
    }

    public UpdateNumericCustomFieldParams initialValue(float initialValue) {
        parameters.add(new NameValuePair("initialValue", Float.toString(initialValue)));
        return this;
    }

    public UpdateNumericCustomFieldParams unit(String unit) {
        parameters.add(new NameValuePair("unit", unit));
        return this;
    }

    @Override
    public UpdateNumericCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (UpdateNumericCustomFieldParams)super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public UpdateNumericCustomFieldParams description(String description) {
        return (UpdateNumericCustomFieldParams)super.description(description);
    }

    @Override
    public UpdateNumericCustomFieldParams required(boolean required) {
        return (UpdateNumericCustomFieldParams)super.required(required);
    }
}
