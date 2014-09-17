package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Issue;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Parameters for get issue API.
 *
 * @author nulab-inc
 */
public class GetIssuesParams extends GetParams {
    public enum SortKey {
        IssueType("issueType"),
        Category("category"),
        Version("version"),
        Milestone("milestone"),
        Summary("summary"),
        Status("status"),
        Priority("priority"),
        Attachment("attachment"),
        SharedFile("sharedFile"),
        Created("created"),
        CreatedUser("createdUser"),
        Updated("updated"),
        UpdatedUser("updatedUser"),
        Assignee("assignee"),
        StartDate("startDate"),
        DueDate("dueDate"),
        EstimatedHours("estimatedHours"),
        ActualHours("actualHours"),
        ChildIssue("childIssue");

        SortKey(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        private String value;
    }

    public enum Order {
        Asc("asc"),
        Desc("desc");

        Order(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        private String value;
    }

    public enum ParentChildType {
        All(1), NotChild(1), Child(2), NotChildNotParent(3), Parent(4);

        ParentChildType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        private int intValue;
    }

    public GetIssuesParams(List<Long> projectIds){
        for (Long projectId :projectIds) {
            parameters.add(new BasicNameValuePair("projectId[]", projectId.toString()));
        }
    }

    public GetIssuesParams projectIds(List<Long> projectIds) {
        for (Long projectId :projectIds) {
            parameters.add(new BasicNameValuePair("projectId[]", projectId.toString()));
        }
        return this;
    }

    public GetIssuesParams issueTypeIds(List<Long> issueTypeIds) {
        for (Long issueTypeId :issueTypeIds) {
            parameters.add(new BasicNameValuePair("issueTypeId[]", issueTypeId.toString()));
        }
        return this;
    }

    public GetIssuesParams categoryIds(List<Long> categoryIds) {
        for (Long categoryId :categoryIds) {
            parameters.add(new BasicNameValuePair("categoryId[]", categoryId.toString()));
        }
        return this;
    }

    public GetIssuesParams versionIds(List<Long> versionIds) {
        for (Long versionId :versionIds) {
            parameters.add(new BasicNameValuePair("versionId[]", versionId.toString()));
        }
        return this;
    }

    public GetIssuesParams milestoneIds(List<Long> milestoneIds) {
        for (Long milestoneId :milestoneIds) {
            parameters.add(new BasicNameValuePair("milestoneId[]", milestoneId.toString()));
        }
        return this;
    }

    public GetIssuesParams statuses(List<Issue.StatusType> statuses) {
        for (Issue.StatusType status :statuses) {
            parameters.add(new BasicNameValuePair("statusId[]", String.valueOf(status.getIntValue())));
        }
        return this;
    }

    public GetIssuesParams priorities(List<Issue.PriorityType> priorities) {
        for (Issue.PriorityType priority :priorities) {
            parameters.add(new BasicNameValuePair("priorityId[]", String.valueOf(priority.getIntValue())));
        }
        return this;
    }

    public GetIssuesParams assignerIds(List<Long> assignerIds) {
        for (Long assignerId :assignerIds) {
            parameters.add(new BasicNameValuePair("assigneeId[]", assignerId.toString()));
        }
        return this;
    }

    public GetIssuesParams createdUserIds(List<Long> createdUserIds) {
        for (Long createdUserId :createdUserIds) {
            parameters.add(new BasicNameValuePair("createdUserId[]", createdUserId.toString()));
        }
        return this;
    }

    public GetIssuesParams resolutions(List<Issue.ResolutionType> resolutions) {
        for (Issue.ResolutionType resolution :resolutions) {
            parameters.add(new BasicNameValuePair("resolutionId[]", String.valueOf(resolution.getIntValue())));
        }
        return this;
    }

    public GetIssuesParams parentChildType(ParentChildType parentChildType) {
        parameters.add(new BasicNameValuePair("parentChild", String.valueOf(parentChildType.getIntValue())));
        return this;
    }

    public GetIssuesParams attachment(boolean attachment) {
        parameters.add(new BasicNameValuePair("attachment", String.valueOf(attachment)));
        return this;
    }

    public GetIssuesParams sharedFile(boolean sharedFile) {
        parameters.add(new BasicNameValuePair("sharedFile", String.valueOf(sharedFile)));
        return this;
    }

    public GetIssuesParams sort(SortKey sort) {
        parameters.add(new BasicNameValuePair("sort", sort.getStrValue()));
        return this;
    }

    public GetIssuesParams sortByCustomField(long customFieldId) {
        parameters.add(new BasicNameValuePair("sort", "customField_" + String.valueOf(customFieldId)));
        return this;
    }

    public GetIssuesParams order(Order order) {
        parameters.add(new BasicNameValuePair("order", order.getStrValue()));
        return this;
    }

    public GetIssuesParams offset(long offset) {
        parameters.add(new BasicNameValuePair("offset", String.valueOf(offset)));
        return this;
    }

    public GetIssuesParams count(long count) {
        parameters.add(new BasicNameValuePair("count", String.valueOf(count)));
        return this;
    }

    public GetIssuesParams createdSince(String createdSince) {
        parameters.add(new BasicNameValuePair("createdSince", createdSince));
        return this;
    }

    public GetIssuesParams createdUntil(String createdUntil) {
        parameters.add(new BasicNameValuePair("createdUntil", createdUntil));
        return this;
    }

    public GetIssuesParams updatedSince(String updatedSince) {
        parameters.add(new BasicNameValuePair("updatedSince", updatedSince));
        return this;
    }

    public GetIssuesParams updatedUntil(String updatedUntil) {
        parameters.add(new BasicNameValuePair("updatedUntil", updatedUntil));
        return this;
    }

    public GetIssuesParams startDateSince(String startDateSince) {
        parameters.add(new BasicNameValuePair("startDateSince", startDateSince));
        return this;
    }

    public GetIssuesParams startDateUntil(String startDateUntil) {
        parameters.add(new BasicNameValuePair("startDateUntil", startDateUntil));
        return this;
    }

    public GetIssuesParams dueDateSince(String dueDateSince) {
        parameters.add(new BasicNameValuePair("dueDateSince", dueDateSince));
        return this;
    }

    public GetIssuesParams dueDateUntil(String dueDateUntil) {
        parameters.add(new BasicNameValuePair("dueDateUntil", dueDateUntil));
        return this;
    }

    public GetIssuesParams ids(List<Long> ids) {
        for (Long id :ids) {
            parameters.add(new BasicNameValuePair("id[]", id.toString()));
        }
        return this;
    }

    public GetIssuesParams parentIssueIds(List<Long> parentIssueIds) {
        for (Long parentIssueId :parentIssueIds) {
            parameters.add(new BasicNameValuePair("parentIssueId[]", parentIssueId.toString()));
        }
        return this;
    }

    public GetIssuesParams keyword(String keyword) throws BacklogException {
        try {
            parameters.add(new BasicNameValuePair("keyword", URLEncoder.encode(keyword, "utf-8")));
        } catch (UnsupportedEncodingException e) {
            throw new BacklogAPIException(e);
        }
        return this;
    }
}
