package com.nulabinc.backlog4j.internal.json.customFields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.nulabinc.backlog4j.CustomField;
import com.nulabinc.backlog4j.CustomFieldSetting;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
    public String getIdAsString() {
        return String.valueOf(this.id);
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



    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("typeId", typeId)
                .append("name", name)
                .append("applicableIssueTypes", applicableIssueTypes)
                .append("description", description)
                .append("required", required)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        CustomFieldSettingJSONImpl rhs = (CustomFieldSettingJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.typeId, rhs.typeId)
                .append(this.name, rhs.name)
                .append(this.applicableIssueTypes, rhs.applicableIssueTypes)
                .append(this.description, rhs.description)
                .append(this.required, rhs.required)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(typeId)
                .append(name)
                .append(applicableIssueTypes)
                .append(description)
                .append(required)
                .toHashCode();
    }
}
