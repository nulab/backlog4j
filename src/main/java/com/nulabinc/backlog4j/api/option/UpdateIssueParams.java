package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Parameters for update issue API.
 *
 * @author nulab-inc
 */
public class UpdateIssueParams extends PatchParams {

    private long issueId;
    private String issueKey;

    public UpdateIssueParams(long issueId){
        this.issueId = issueId;
    }
    public UpdateIssueParams(String issueKey){
        this.issueKey = issueKey;
    }

    public String getIssueIdOrKeyString() {
        if(issueKey != null){
            return issueKey;
        }else{
            return String.valueOf(issueId);
        }
    }

    public UpdateIssueParams summary(String summary) {
        parameters.add(new BasicNameValuePair("summary", summary));
        return this;
    }

    public UpdateIssueParams parentIssueId(long parentIssueId) {
        parameters.add(new BasicNameValuePair("parentIssueId", String.valueOf(parentIssueId)));
        return this;
    }

    public UpdateIssueParams description(String description) {
        parameters.add(new BasicNameValuePair("description", String.valueOf(description)));
        return this;
    }

    public UpdateIssueParams status(Issue.StatusType statusType) {
        parameters.add(new BasicNameValuePair("statusId", String.valueOf(statusType.getIntValue())));
        return this;
    }

    public UpdateIssueParams resolution(Issue.ResolutionType resolutionType) {
        parameters.add(new BasicNameValuePair("resolutionId", String.valueOf(resolutionType.getIntValue())));
        return this;
    }

    public UpdateIssueParams startDate(String startDate) {
        parameters.add(new BasicNameValuePair("startDate", String.valueOf(startDate)));
        return this;
    }

    public UpdateIssueParams dueDate(String dueDate) {
        parameters.add(new BasicNameValuePair("dueDate", String.valueOf(dueDate)));
        return this;
    }

    public UpdateIssueParams estimatedHours(float estimatedHours) {
        parameters.add(new BasicNameValuePair("estimatedHours", String.valueOf(estimatedHours)));
        return this;
    }

    public UpdateIssueParams actualHours(float actualHours) {
        parameters.add(new BasicNameValuePair("actualHours", String.valueOf(actualHours)));
        return this;
    }

    public UpdateIssueParams issueTypeId(long issueTypeId) {
        parameters.add(new BasicNameValuePair("issueTypeId", String.valueOf(issueTypeId)));
        return this;
    }

    public UpdateIssueParams categoryIds(List<Long> categoryIds) {
        for (Long categoryId : categoryIds) {
            parameters.add(new BasicNameValuePair("categoryId[]", categoryId.toString()));
        }
        return this;
    }

    public UpdateIssueParams versionIds(List<Long> versionIds) {
        for (Long versionId : versionIds) {
            parameters.add(new BasicNameValuePair("versionId[]", versionId.toString()));
        }
        return this;
    }

    public UpdateIssueParams milestoneIds(List<Long> milestoneIds) {
        for (Long milestoneId : milestoneIds) {
            parameters.add(new BasicNameValuePair("milestoneId[]", milestoneId.toString()));
        }
        return this;
    }

    public UpdateIssueParams priority(Issue.PriorityType priority) {
        parameters.add(new BasicNameValuePair("priorityId", String.valueOf(priority.getIntValue())));
        return this;
    }

    public UpdateIssueParams assigneeId(long assigneeId) {
        parameters.add(new BasicNameValuePair("assigneeId", String.valueOf(assigneeId)));
        return this;
    }

    public UpdateIssueParams notifiedUserIds(List<Long> notifiedUserIds) {
        for (Long notifiedUserId : notifiedUserIds) {
            parameters.add(new BasicNameValuePair("notifiedUserId[]", notifiedUserId.toString()));
        }
        return this;
    }

    public UpdateIssueParams attachmentIds(List<Long> attachmentIds) {
        for (Long attachmentId : attachmentIds) {
            parameters.add(new BasicNameValuePair("attachmentId[]", attachmentId.toString()));
        }
        return this;
    }



    public UpdateIssueParams textCustomField(long customFieldId, String customFieldValue) {
        parameters.add(new BasicNameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    public UpdateIssueParams textCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new BasicNameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    public UpdateIssueParams textAreaCustomField(long customFieldId, String customFieldValue) {
        parameters.add(new BasicNameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    public UpdateIssueParams textAreaCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new BasicNameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    public UpdateIssueParams numericCustomField(long customFieldId, float customFieldValue){
        parameters.add(new BasicNameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    public UpdateIssueParams numericCustomFieldMap(Map<Long, Float> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new BasicNameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    public UpdateIssueParams dateCustomField(long customFieldId, String customFieldValue){
        parameters.add(new BasicNameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldValue)));
        return this;
    }

    public UpdateIssueParams dateCustomFieldMap(Map<Long, String> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new BasicNameValuePair("customField_" + key.toString(), customFieldMap.get(key)));
        }
        return this;
    }

    public UpdateIssueParams singleListCustomField(long customFieldId, long customFieldItemId){
        parameters.add(new BasicNameValuePair("customField_" + String.valueOf(customFieldId),
                String.valueOf(customFieldItemId)));
        return this;
    }

    public UpdateIssueParams singleListCustomFieldMap(Map<Long, Long> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new BasicNameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    public UpdateIssueParams radioCustomField(long customFieldId, long customFieldItemId){
        return singleListCustomField(customFieldId, customFieldItemId);
    }

    public UpdateIssueParams radioCustomFieldMap(Map<Long, Long> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            parameters.add(new BasicNameValuePair("customField_" + key.toString(), customFieldMap.get(key).toString()));
        }
        return this;
    }

    public UpdateIssueParams multipleListCustomField(long customFieldId, List<Long> customFieldItemIds){
        for (Long customFieldItemId : customFieldItemIds) {
            parameters.add(new BasicNameValuePair("customField_" + String.valueOf(customFieldId),
                    String.valueOf(customFieldItemId)));
        }
        return this;
    }

    public UpdateIssueParams multipleListCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for(Long value: customFieldMap.get(key)){
                parameters.add(new BasicNameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams checkBoxCustomField(long customFieldId, List<Long> customFieldItemIds){
        return multipleListCustomField(customFieldId, customFieldItemIds);
    }

    public UpdateIssueParams checkBoxCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for(Long value: customFieldMap.get(key)){
                parameters.add(new BasicNameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams listCustomFieldMap(Map<Long, List<Long>> customFieldMap) {
        Set<Long> keySet = customFieldMap.keySet();
        for (Long key : keySet) {
            for(Long value: customFieldMap.get(key)){
                parameters.add(new BasicNameValuePair("customField_" + key.toString(), value.toString()));
            }
        }
        return this;
    }

    public UpdateIssueParams customFieldOtherValue(long customFieldId, String otherValue) {
        parameters.add(new BasicNameValuePair("customField_" + String.valueOf(customFieldId) + "_otherValue",
                otherValue));
        return this;
    }

    public UpdateIssueParams customFieldOtherValueMap(Map<Long, String> customFieldOtherValueMap) {
        Set<Long> keySet = customFieldOtherValueMap.keySet();
        for (Long key : keySet) {
            parameters.add(new BasicNameValuePair("customField_" + key.toString() + "_otherValue", customFieldOtherValueMap.get(key)));
        }
        return this;
    }

    public UpdateIssueParams comment(String comment) {
        parameters.add(new BasicNameValuePair("comment", comment));
        return this;
    }
}
