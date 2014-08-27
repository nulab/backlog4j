package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nulabinc.backlog4j.CustomFieldSetting;

/**
 * @author nulab-inc
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "typeId")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextCustomFieldSetting.class, name = "1"),
        @JsonSubTypes.Type(value = TextAreaCustomFieldSetting.class, name = "2"),
        @JsonSubTypes.Type(value = NumericCustomFieldSetting.class, name = "3"),
        @JsonSubTypes.Type(value = DateCustomFieldSetting.class, name = "4"),
        @JsonSubTypes.Type(value = SingleListCustomFieldSetting.class, name = "5"),
        @JsonSubTypes.Type(value = MultipleListCustomFieldSetting.class, name = "6"),
        @JsonSubTypes.Type(value = CheckBoxCustomFieldSetting.class, name = "7"),
        @JsonSubTypes.Type(value = RadioCustomFieldSetting.class, name = "8") })
public abstract class CustomFieldSettingJSONImpl implements CustomFieldSetting {

    private long id;
    private int typeId;
    private String name;
    private long[] applicableIssueTypes;
    private String description;
    private Boolean required;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long[] getApplicableIssueTypes() {
        return applicableIssueTypes;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

}
