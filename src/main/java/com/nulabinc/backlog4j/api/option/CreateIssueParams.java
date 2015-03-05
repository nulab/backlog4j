package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Parameters for create issue API.
 *
 * @author nulab-inc
 */
public class CreateIssueParams extends PostParams {

    /**
     * Constructor
     *
     * @param projectId   the project identifier
     * @param summary     the issue title
     * @param issueTypeId the issue type identifier
     * @param priority    the priority of the issue
     */
    public CreateIssueParams(long projectId, String summary, long issueTypeId, Issue.PriorityType priority) {
        parameters.add(new NameValuePair("projectId", String.valueOf(projectId)));
        parameters.add(new NameValuePair("summary", summary));
        parameters.add(new NameValuePair("issueTypeId", String.valueOf(issueTypeId)));
        parameters.add(new NameValuePair("priorityId", String.valueOf(priority.getIntValue())));
    }

    /**
     * Sets the parent issue parameter.
     *
     * @param parentIssueId the parent issue identifier
     * @return CreateIssueParams instance
     */
    public CreateIssueParams parentIssueId(long parentIssueId) {
        parameters.add(new NameValuePair("parentIssueId", String.valueOf(parentIssueId)));
        return this;
    }

    /**
     * Sets the description.
     *
     * @param description the issue description
     * @return CreateIssueParams instance
     */
    public CreateIssueParams description(String description) {
        parameters.add(new NameValuePair("description", String.valueOf(description)));
        return this;
    }

    /**
     * Sets the issue start date.
     *
     * @param startDate the issue description
     * @return CreateIssueParams instance
     */
    public CreateIssueParams startDate(String startDate) {
        parameters.add(new NameValuePair("startDate", String.valueOf(startDate)));
        return this;
    }

    /**
     * Sets the issue due date.
     *
     * @param dueDate the issue due date
     * @return CreateIssueParams instance
     */
    public CreateIssueParams dueDate(String dueDate) {
        parameters.add(new NameValuePair("dueDate", String.valueOf(dueDate)));
        return this;
    }

    /**
     * Sets the issue estimate hours.
     *
     * @param estimatedHours the issue estimate hours
     * @return CreateIssueParams instance
     */
    public CreateIssueParams estimatedHours(float estimatedHours) {
        parameters.add(new NameValuePair("estimatedHours", String.valueOf(estimatedHours)));
        return this;

    }

    /**
     * Sets the issue estimate hours.
     *
     * @param estimatedHours the issue estimate hours
     * @return CreateIssueParams instance
     */
    public CreateIssueParams estimatedHours(BigDecimal estimatedHours) {
        if (estimatedHours == null) {
            parameters.add(new NameValuePair("estimatedHours", ""));
        } else {
            parameters.add(new NameValuePair("estimatedHours", estimatedHours.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()));
        }
        return this;
    }

    /**
     * Sets the issue actual hours.
     *
     * @param actualHours the issue actual hours
     * @return CreateIssueParams instance
     */
    public CreateIssueParams actualHours(float actualHours) {
        parameters.add(new NameValuePair("actualHours", String.valueOf(actualHours)));
        return this;
    }

    /**
     * Sets the issue actual hours.
     *
     * @param actualHours the issue actual hours
     * @return CreateIssueParams instance
     */
    public CreateIssueParams actualHours(BigDecimal actualHours) {
        if (actualHours == null) {
            parameters.add(new NameValuePair("actualHours", ""));
        } else {
            parameters.add(new NameValuePair("actualHours", actualHours.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()));
        }
        return this;
    }

    /**
     * Sets the categories start date.
     *
     * @param categoryIds the categories start date
     * @return CreateIssueParams instance
     */
    public CreateIssueParams categoryIds(List<Long> categoryIds) {
        for (Long categoryId : categoryIds) {
            parameters.add(new NameValuePair("categoryId[]", categoryId.toString()));
        }
        return this;
    }

    /**
     * Sets the issue versions.
     *
     * @param versionIds the version identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams versionIds(List<Long> versionIds) {
        for (Long versionId : versionIds) {
            parameters.add(new NameValuePair("versionId[]", versionId.toString()));
        }
        return this;
    }

    /**
     * Sets the issue milestones.
     *
     * @param milestoneIds the milestone identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams milestoneIds(List<Long> milestoneIds) {
        for (Long milestoneId : milestoneIds) {
            parameters.add(new NameValuePair("milestoneId[]", milestoneId.toString()));
        }
        return this;
    }

    /**
     * Sets the issue assignee user.
     *
     * @param assigneeId the assignee user id
     * @return CreateIssueParams instance
     */
    public CreateIssueParams assigneeId(long assigneeId) {
        parameters.add(new NameValuePair("assigneeId", String.valueOf(assigneeId)));
        return this;

    }

    /**
     * Sets the issue notified users.
     *
     * @param notifiedUserIds notified user identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams notifiedUserIds(List<Long> notifiedUserIds) {
        for (Long notifiedUserId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", notifiedUserId.toString()));
        }
        return this;

    }

    /**
     * Sets the issue attachment files.
     *
     * @param attachmentIds the attachment file identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams attachmentIds(List<Long> attachmentIds) {
        for (Long attachmentId : attachmentIds) {
            parameters.add(new NameValuePair("attachmentId[]", attachmentId.toString()));
        }
        return this;
    }

    /**
     * Sets the text type custom field.
     *
     * @param customFieldId    the identifier of custom field
     * @param customFieldValue the value of custom field
     * @return CreateIssueParams instance
     */
    public CreateIssueParams textCustomField(long customFieldId, String customFieldValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    /**
     * Sets the text type custom field with Map.
     *
     * @param customFieldMap set of the identifiers and the values
     * @return CreateIssueParams instance
     */
    public CreateIssueParams textCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    /**
     * Sets the text type custom field.
     *
     * @param customFieldId    the identifier of custom field
     * @param customFieldValue the value of custom field
     * @return CreateIssueParams instance
     */
    public CreateIssueParams textAreaCustomField(long customFieldId, String customFieldValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    /**
     * Sets the text type custom field with Map.
     *
     * @param customFieldMap set of the identifiers and the values
     * @return CreateIssueParams instance
     */
    public CreateIssueParams textAreaCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    /**
     * Sets the textarea type custom field.
     *
     * @param customFieldId    the identifier of custom field
     * @param customFieldValue the value of custom field
     * @return CreateIssueParams instance
     */
    public CreateIssueParams numericCustomField(long customFieldId, float customFieldValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    /**
     * Sets the textarea type custom field with Map.
     *
     * @param customFieldMap set of the identifiers and the values
     * @return CreateIssueParams instance
     */
    public CreateIssueParams numericCustomFieldMap(Map<Long, Float> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    /**
     * Sets the date type custom field.
     *
     * @param customFieldId    the identifier of custom field
     * @param customFieldValue the value of custom field
     * @return CreateIssueParams instance
     */
    public CreateIssueParams dateCustomField(long customFieldId, String customFieldValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    /**
     * Sets the date type custom field with Map.
     *
     * @param customFieldMap set of the identifiers and the values
     * @return CreateIssueParams instance
     */
    public CreateIssueParams dateCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    /**
     * Sets the single list type custom field.
     *
     * @param customFieldId     the identifier of custom field
     * @param customFieldItemId the identifier of custom field item
     * @return CreateIssueParams instance
     */
    public CreateIssueParams singleListCustomField(long customFieldId, long customFieldItemId) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldItemId)));
        return this;
    }

    /**
     * Sets the single list type custom field with Map.
     *
     * @param customFieldMap set of the custom field identifiers and custom field item identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams singleListCustomFieldMap(Map<Long, Long> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    /**
     * Sets the radio type custom field.
     *
     * @param customFieldId     the identifier of custom field
     * @param customFieldItemId the identifier of custom field item
     * @return CreateIssueParams instance
     */
    public CreateIssueParams radioCustomField(long customFieldId, long customFieldItemId) {
        return singleListCustomField(customFieldId, customFieldItemId);
    }

    /**
     * Sets the radio type custom field with Map.
     *
     * @param customFieldMap set of the custom field identifiers and custom field item identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams radioCustomFieldMap(Map<Long, Long> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    /**
     * Sets the multiple list type custom field.
     *
     * @param customFieldId      the identifier of custom field
     * @param customFieldItemIds the identifiers of custom field items
     * @return CreateIssueParams instance
     */
    public CreateIssueParams multipleListCustomField(long customFieldId, List<Long> customFieldItemIds) {
        for (Long customFieldItemId : customFieldItemIds) {
            parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                    String.valueOf(customFieldItemId)));
        }
        return this;
    }

    /**
     * Sets the multiple list type custom field with Map.
     *
     * @param customFieldMap set of the custom field identifiers and custom field item identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams multipleListCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for (Long value : customFieldMap.get(key)) {
                parameters.add(new NameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    /**
     * Sets the checkbox type custom field.
     *
     * @param customFieldId      the identifier of custom field
     * @param customFieldItemIds the identifiers of custom field items
     * @return CreateIssueParams instance
     */
    public CreateIssueParams checkBoxCustomField(long customFieldId, List<Long> customFieldItemIds) {
        return multipleListCustomField(customFieldId, customFieldItemIds);
    }

    /**
     * Sets the checkbox type custom field with Map.
     *
     * @param customFieldMap set of the custom field identifiers and custom field item identifiers
     * @return CreateIssueParams instance
     */
    public CreateIssueParams checkBoxCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for (Long value : customFieldMap.get(key)) {
                parameters.add(new NameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    /**
     * Sets the other value for radio or checkbox type custom field.
     *
     * @param customFieldId the identifier of custom field
     * @param otherValue    the other value
     * @return CreateIssueParams instance
     */
    public CreateIssueParams customFieldOtherValue(long customFieldId, String otherValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId) + "_otherValue",
                otherValue));
        return this;
    }

    /**
     * Sets the other value for radio or checkbox type custom field with Map
     *
     * @param customFieldOtherValueMap set of the custom field identifiers and the other value
     * @return CreateIssueParams instance
     */
    public CreateIssueParams customFieldOtherValueMap(Map<Long, String> customFieldOtherValueMap) {
        Set<Long> keySet = customFieldOtherValueMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString() + "_otherValue", customFieldOtherValueMap.get(key)));
        }
        return this;
    }
}
