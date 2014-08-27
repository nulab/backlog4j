package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

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
        parameters.add(new BasicNameValuePair("min", String.valueOf(min)));
        return this;
    }

    public UpdateNumericCustomFieldParams max(float max) {
        parameters.add(new BasicNameValuePair("max", String.valueOf(max)));
        return this;
    }

    public UpdateNumericCustomFieldParams initialValue(float initialValue) {
        parameters.add(new BasicNameValuePair("initialValue", String.valueOf(initialValue)));
        return this;
    }

    public UpdateNumericCustomFieldParams unit(String unit) {
        parameters.add(new BasicNameValuePair("unit", unit));
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
