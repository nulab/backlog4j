package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Parameters for update issue API.
 *
 * @author nulab-inc
 */
public class UpdateIssueParams extends PatchParams {

    public static final long PARENT_ISSUE_NOT_SET = -1;

    private Object issueIdOrKey;

    public UpdateIssueParams(Object issueIdOrKey) {
        this.issueIdOrKey = issueIdOrKey;
    }

    public String getIssueIdOrKeyString() {
        return issueIdOrKey.toString();
    }

    public UpdateIssueParams summary(String summary) {
        parameters.add(new NameValuePair("summary", summary));
        return this;
    }

    public UpdateIssueParams parentIssueId(long parentIssueId) {
        if (parentIssueId == PARENT_ISSUE_NOT_SET) {
            parameters.add(new NameValuePair("parentIssueId", ""));
        } else {
            parameters.add(new NameValuePair("parentIssueId", String.valueOf(parentIssueId)));
        }
        return this;
    }

    public UpdateIssueParams description(String description) {
        parameters.add(new NameValuePair("description", String.valueOf(description)));
        return this;
    }

    public UpdateIssueParams status(Issue.StatusType statusType) {
        parameters.add(new NameValuePair("statusId", String.valueOf(statusType.getIntValue())));
        return this;
    }

    public UpdateIssueParams resolution(Issue.ResolutionType resolutionType) {
        if (resolutionType == null || resolutionType.equals(Issue.ResolutionType.NotSet)) {
            parameters.add(new NameValuePair("resolutionId", ""));
        } else {
            parameters.add(new NameValuePair("resolutionId", String.valueOf(resolutionType.getIntValue())));
        }
        return this;
    }

    public UpdateIssueParams startDate(String startDate) {
        if (startDate == null) {
            parameters.add(new NameValuePair("startDate", ""));
        } else {
            parameters.add(new NameValuePair("startDate", String.valueOf(startDate)));
        }
        return this;
    }

    public UpdateIssueParams dueDate(String dueDate) {
        if (dueDate == null) {
            parameters.add(new NameValuePair("dueDate", ""));
        } else {
            parameters.add(new NameValuePair("dueDate", String.valueOf(dueDate)));
        }
        return this;
    }

    public UpdateIssueParams estimatedHours(int estimatedHours) {
        parameters.add(new NameValuePair("estimatedHours", String.valueOf(estimatedHours)));
        return this;
    }

    public UpdateIssueParams estimatedHours(float estimatedHours) {
        parameters.add(new NameValuePair("estimatedHours", Float.toString(estimatedHours)));
        return this;
    }

    public UpdateIssueParams estimatedHours(BigDecimal estimatedHours) {
        if (estimatedHours == null) {
            parameters.add(new NameValuePair("estimatedHours", ""));
        } else {
            parameters.add(new NameValuePair("estimatedHours", estimatedHours.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()));
        }
        return this;
    }

    public UpdateIssueParams actualHours(int actualHours) {
        parameters.add(new NameValuePair("actualHours", String.valueOf(actualHours)));
        return this;
    }

    public UpdateIssueParams actualHours(float actualHours) {
        parameters.add(new NameValuePair("actualHours", Float.toString(actualHours)));
        return this;
    }

    public UpdateIssueParams actualHours(BigDecimal actualHours) {
        if (actualHours == null) {
            parameters.add(new NameValuePair("actualHours", ""));
        } else {
            parameters.add(new NameValuePair("actualHours", actualHours.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()));
        }
        return this;
    }

    public UpdateIssueParams issueTypeId(Object issueTypeId) {
        parameters.add(new NameValuePair("issueTypeId", issueTypeId.toString()));
        return this;
    }

    public UpdateIssueParams categoryIds(List categoryIds) {
        if (categoryIds == null) {
            parameters.add(new NameValuePair("categoryId[]", ""));
        } else {
            for (Object categoryId : categoryIds) {
                parameters.add(new NameValuePair("categoryId[]", categoryId.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams versionIds(List versionIds) {
        if (versionIds == null) {
            parameters.add(new NameValuePair("versionId[]", ""));
        } else {
            for (Object versionId : versionIds) {
                parameters.add(new NameValuePair("versionId[]", versionId.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams milestoneIds(List milestoneIds) {
        if (milestoneIds == null) {
            parameters.add(new NameValuePair("milestoneId[]", ""));
        } else {
            for (Object milestoneId : milestoneIds) {
                parameters.add(new NameValuePair("milestoneId[]", milestoneId.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams priority(Issue.PriorityType priority) {
        parameters.add(new NameValuePair("priorityId", String.valueOf(priority.getIntValue())));
        return this;
    }

    public UpdateIssueParams assigneeId(long assigneeId) {
        String assigneeIdStr = "";
        if(assigneeId <= 0) {
            assigneeIdStr = "";
        }
        parameters.add(new NameValuePair("assigneeId", assigneeIdStr));
        return this;
    }

    public UpdateIssueParams notifiedUserIds(List notifiedUserIds) {
        for (Object notifiedUserId : notifiedUserIds) {
            parameters.add(new NameValuePair("notifiedUserId[]", notifiedUserId.toString()));
        }
        return this;
    }

    public UpdateIssueParams attachmentIds(List attachmentIds) {
        for (Object attachmentId : attachmentIds) {
            parameters.add(new NameValuePair("attachmentId[]", attachmentId.toString()));
        }
        return this;
    }

    public UpdateIssueParams textCustomField(CustomFiledValue customFieldValue) {
        parameters.add(new NameValuePair("customField_" + customFieldValue.getCustomFieldId(),
                customFieldValue.getCustomFieldValue()));
        return this;
    }

    public UpdateIssueParams textCustomFields(List<CustomFiledValue> customFieldValueList) {
        for (CustomFiledValue customFiledValue : customFieldValueList) {
            textCustomField(customFiledValue);
        }
        return this;
    }

    public UpdateIssueParams textAreaCustomField(CustomFiledValue customFieldValue) {
        return textCustomField(customFieldValue);
    }

    public UpdateIssueParams textAreaCustomFields(List<CustomFiledValue> customFieldValueList) {
        return textCustomFields(customFieldValueList);
    }

    public UpdateIssueParams numericCustomField(CustomFiledValue customFieldValue) {
        return textCustomField(customFieldValue);
    }

    public UpdateIssueParams numericCustomFields(List<CustomFiledValue> customFieldValueList) {
        return textCustomFields(customFieldValueList);
    }

    public UpdateIssueParams dateCustomField(CustomFiledValue customFieldValue) {
        return textCustomField(customFieldValue);
    }

    public UpdateIssueParams dateCustomFields(List<CustomFiledValue> customFieldValueList) {
        return textCustomFields(customFieldValueList);
    }

    public UpdateIssueParams singleListCustomField(CustomFiledItem customFiledItem) {
        parameters.add(new NameValuePair("customField_" + customFiledItem.getCustomFieldId(),
                customFiledItem.getCustomFieldItemId()));
        return this;
    }

    public UpdateIssueParams singleListCustomFields(List<CustomFiledItem> customFiledItemList) {
        for (CustomFiledItem customFiledItem : customFiledItemList) {
            singleListCustomField(customFiledItem);
        }
        return this;
    }

    public UpdateIssueParams radioCustomField(CustomFiledItem customFiledItem) {
        return singleListCustomField(customFiledItem);
    }

    public UpdateIssueParams radioCustomFields(List<CustomFiledItem> customFiledItemList) {
        return singleListCustomFields(customFiledItemList);
    }

    public UpdateIssueParams multipleListCustomField(CustomFiledItems customFiledItems) {
        for (Object id : customFiledItems.getCustomFieldItemIds()) {
            parameters.add(new NameValuePair("customField_" + customFiledItems.getCustomFieldId(),
                    id.toString()));
        }
        return this;
    }

    public UpdateIssueParams multipleListCustomFields(List<CustomFiledItems> customFiledItemsList) {
        for (CustomFiledItems customFiledItems : customFiledItemsList) {
            multipleListCustomField(customFiledItems);
        }
        return this;
    }

    public UpdateIssueParams checkBoxCustomField(CustomFiledItems customFiledItems) {
        return multipleListCustomField(customFiledItems);
    }

    public UpdateIssueParams checkBoxCustomFields(List<CustomFiledItems> customFiledItemsList) {
        return multipleListCustomFields(customFiledItemsList);
    }

    public UpdateIssueParams customFieldOtherValue(CustomFiledValue customFieldValue) {
        return textCustomField(customFieldValue);
    }

    public UpdateIssueParams customFieldOtherValues(List<CustomFiledValue> customFieldValueList) {
        return textCustomFields(customFieldValueList);
    }

    public UpdateIssueParams comment(String comment) {
        parameters.add(new NameValuePair("comment", comment));
        return this;
    }

    public UpdateIssueParams textCustomField(long customFieldId, String customFieldValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    public UpdateIssueParams textCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    public UpdateIssueParams textAreaCustomField(long customFieldId, String customFieldValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    public UpdateIssueParams textAreaCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    public UpdateIssueParams numericCustomField(long customFieldId, float customFieldValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                Float.toString(customFieldValue)));
        return this;
    }

    public UpdateIssueParams numericCustomField(long customFieldId, BigDecimal customFieldValue) {
        if(customFieldValue == null){
            parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                    ""));
        }else {
            parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                    customFieldValue.setScale(4, BigDecimal.ROUND_HALF_UP).toPlainString()));
        }
        return this;
    }

    public UpdateIssueParams numericCustomFieldMap(Map<Long, Float> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), Float.toString(customFieldMap.get(key))));
        }
        return this;
    }

    public UpdateIssueParams dateCustomField(long customFieldId, String customFieldValue) {
        if (customFieldValue == null) {
            parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId), ""));
        } else {
            parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                    customFieldValue));
        }
        return this;
    }

    public UpdateIssueParams dateCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            String customFieldValue = customFieldMap.get(key);
            if (customFieldValue == null) {
                parameters.add(new NameValuePair("customField_" + key.toString(), ""));
            }else {
                parameters.add(new NameValuePair("customField_" + key.toString(), customFieldValue));
            }
        }
        return this;
    }

    public UpdateIssueParams singleListCustomField(long customFieldId, long customFieldItemId) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldItemId)));
        return this;
    }

    public UpdateIssueParams singleListCustomFieldMap(Map<Long, Long> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    public UpdateIssueParams radioCustomField(long customFieldId, long customFieldItemId) {
        return singleListCustomField(customFieldId, customFieldItemId);
    }

    public UpdateIssueParams radioCustomFieldMap(Map<Long, Long> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    public UpdateIssueParams multipleListCustomField(long customFieldId, List<Long> customFieldItemIds) {
        for (Long customFieldItemId : customFieldItemIds) {
            parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId),
                    String.valueOf(customFieldItemId)));
        }
        return this;
    }

    public UpdateIssueParams multipleListCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for (Long value : customFieldMap.get(key)) {
                parameters.add(new NameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams checkBoxCustomField(long customFieldId, List<Long> customFieldItemIds) {
        return multipleListCustomField(customFieldId, customFieldItemIds);
    }

    public UpdateIssueParams checkBoxCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for (Long value : customFieldMap.get(key)) {
                parameters.add(new NameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams listCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for (Long value : customFieldMap.get(key)) {
                parameters.add(new NameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams customFieldOtherValue(long customFieldId, String otherValue) {
        parameters.add(new NameValuePair("customField_" + String.valueOf(customFieldId) + "_otherValue",
                otherValue));
        return this;
    }

    public UpdateIssueParams customFieldOtherValueMap(Map<Long, String> customFieldOtherValueMap) {
        Set<Long> keySet = customFieldOtherValueMap.keySet();
        for (Long key : keySet) {
            parameters.add(new NameValuePair("customField_" + key.toString() + "_otherValue", customFieldOtherValueMap.get(key)));
        }
        return this;
    }

}
