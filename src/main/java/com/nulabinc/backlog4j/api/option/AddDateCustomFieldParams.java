package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.CustomFieldSetting;
import com.nulabinc.backlog4j.internal.json.customFields.DateCustomFieldSetting;
import com.nulabinc.backlog4j.http.NameValuePair;

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

    public AddDateCustomFieldParams(String projectIdOrKey, String name) {
        super(projectIdOrKey, CustomFieldSetting.FieldType.Date, name);
    }

    public AddDateCustomFieldParams min(String min) {
        parameters.add(new NameValuePair("min", min));
        return this;
    }

    public AddDateCustomFieldParams max(String max) {
        parameters.add(new NameValuePair("max", max));
        return this;
    }

    public AddDateCustomFieldParams initialValueType(DateCustomFieldSetting.InitialValueType initialValueType) {
        parameters.add(new NameValuePair("initialValueType", String.valueOf(initialValueType.getIntValue())));
        return this;
    }

    public AddDateCustomFieldParams initialDate(String initialDate) {
        parameters.add(new NameValuePair("initialDate", initialDate));
        return this;
    }

    public AddDateCustomFieldParams initialShift(int initialShift) {
        parameters.add(new NameValuePair("initialShift", String.valueOf(initialShift)));
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
