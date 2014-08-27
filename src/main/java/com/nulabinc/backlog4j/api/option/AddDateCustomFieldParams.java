package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import com.nulabinc.backlog4j.internal.json.customFields.DateCustomFieldSetting;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for add date type custom field API.
 *
 * @author nulab-inc
 */
public class AddDateCustomFieldParams extends AddCustomFieldParams {

    public AddDateCustomFieldParams(long projectId, String name) {
        super(projectId, CustomFieldSetting.FieldType.Date, name);
    }

    public AddDateCustomFieldParams(String projectKey, String name) {
        super(projectKey, CustomFieldSetting.FieldType.Date, name);
    }

    public AddDateCustomFieldParams min(String min) {
        parameters.add(new BasicNameValuePair("min", min));
        return this;
    }

    public AddDateCustomFieldParams max(String max) {
        parameters.add(new BasicNameValuePair("max", max));
        return this;
    }

    public AddDateCustomFieldParams initialValueType(DateCustomFieldSetting.InitialValueType initialValueType) {
        parameters.add(new BasicNameValuePair("initialValueType", String.valueOf(initialValueType.getIntValue())));
        return this;
    }

    public AddDateCustomFieldParams initialDate(String initialDate) {
        parameters.add(new BasicNameValuePair("initialDate", initialDate));
        return this;
    }

    public AddDateCustomFieldParams initialShift(int initialShift) {
        parameters.add(new BasicNameValuePair("initialShift", String.valueOf(initialShift)));
        return this;
    }

    @Override
    public AddDateCustomFieldParams applicableIssueTypes(List<Long> applicableIssueTypes) {
        return (AddDateCustomFieldParams) super.applicableIssueTypes(applicableIssueTypes);
    }

    @Override
    public AddDateCustomFieldParams description(String description) {
        return (AddDateCustomFieldParams) super.description(description);
    }

    @Override
    public AddDateCustomFieldParams required(boolean required) {
        return (AddDateCustomFieldParams) super.required(required);
    }
}
