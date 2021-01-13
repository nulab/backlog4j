package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

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
        All(0), NotChild(1), Child(2), NotChildNotParent(3), Parent(4);

        ParentChildType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        private int intValue;
    }

    public GetIssuesParams(List projectIds) {
        for (Object projectId : projectIds) {
            parameters.add(new NameValuePair("projectId[]", projectId.toString()));
        }
    }

    public GetIssuesParams issueTypeIds(List issueTypeIds) {
        for (Object issueTypeId : issueTypeIds) {
            parameters.add(new NameValuePair("issueTypeId[]", issueTypeId.toString()));
        }
        return this;
    }

    public GetIssuesParams categoryIds(List categoryIds) {
        for (Object categoryId : categoryIds) {
            parameters.add(new NameValuePair("categoryId[]", categoryId.toString()));
        }
        return this;
    }

    public GetIssuesParams versionIds(List versionIds) {
        for (Object versionId : versionIds) {
            parameters.add(new NameValuePair("versionId[]", versionId.toString()));
        }
        return this;
    }

    public GetIssuesParams milestoneIds(List milestoneIds) {
        for (Object milestoneId : milestoneIds) {
            parameters.add(new NameValuePair("milestoneId[]", milestoneId.toString()));
        }
        return this;
    }

    public GetIssuesParams statuses(List<Issue.StatusType> statuses) {
        for (Issue.StatusType status : statuses) {
            parameters.add(new NameValuePair("statusId[]", String.valueOf(status.getIntValue())));
        }
        return this;
    }

    public GetIssuesParams statusIds(List statusIds) {
        for (Object statusId : statusIds) {
            parameters.add(new NameValuePair("statusId[]", statusId.toString()));
        }
        return this;
    }

    public GetIssuesParams priorities(List<Issue.PriorityType> priorities) {
        for (Issue.PriorityType priority : priorities) {
            parameters.add(new NameValuePair("priorityId[]", String.valueOf(priority.getIntValue())));
        }
        return this;
    }

    public GetIssuesParams assigneeIds(List assigneeIds) {
        for (Object assigneeId : assigneeIds) {
            parameters.add(new NameValuePair("assigneeId[]", assigneeId.toString()));
        }
        return this;
    }

    public GetIssuesParams createdUserIds(List createdUserIds) {
        for (Object createdUserId : createdUserIds) {
            parameters.add(new NameValuePair("createdUserId[]", createdUserId.toString()));
        }
        return this;
    }

    public GetIssuesParams resolutions(List<Issue.ResolutionType> resolutions) {
        for (Issue.ResolutionType resolution : resolutions) {
            parameters.add(new NameValuePair("resolutionId[]", String.valueOf(resolution.getIntValue())));
        }
        return this;
    }

    public GetIssuesParams parentChildType(ParentChildType parentChildType) {
        parameters.add(new NameValuePair("parentChild", String.valueOf(parentChildType.getIntValue())));
        return this;
    }

    public GetIssuesParams attachment(boolean attachment) {
        parameters.add(new NameValuePair("attachment", String.valueOf(attachment)));
        return this;
    }

    public GetIssuesParams sharedFile(boolean sharedFile) {
        parameters.add(new NameValuePair("sharedFile", String.valueOf(sharedFile)));
        return this;
    }

    public GetIssuesParams sort(SortKey sort) {
        parameters.add(new NameValuePair("sort", sort.getStrValue()));
        return this;
    }

    public GetIssuesParams sortByCustomField(Object customFieldId) {
        parameters.add(new NameValuePair("sort", "customField_" + customFieldId.toString()));
        return this;
    }

    public GetIssuesParams order(Order order) {
        parameters.add(new NameValuePair("order", order.getStrValue()));
        return this;
    }

    public GetIssuesParams offset(long offset) {
        parameters.add(new NameValuePair("offset", String.valueOf(offset)));
        return this;
    }

    public GetIssuesParams count(long count) {
        parameters.add(new NameValuePair("count", String.valueOf(count)));
        return this;
    }

    public GetIssuesParams count(int count) {
        parameters.add(new NameValuePair("count", String.valueOf(count)));
        return this;
    }

    public GetIssuesParams createdSince(String createdSince) {
        parameters.add(new NameValuePair("createdSince", createdSince));
        return this;
    }

    public GetIssuesParams createdUntil(String createdUntil) {
        parameters.add(new NameValuePair("createdUntil", createdUntil));
        return this;
    }

    public GetIssuesParams updatedSince(String updatedSince) {
        parameters.add(new NameValuePair("updatedSince", updatedSince));
        return this;
    }

    public GetIssuesParams updatedUntil(String updatedUntil) {
        parameters.add(new NameValuePair("updatedUntil", updatedUntil));
        return this;
    }

    public GetIssuesParams startDateSince(String startDateSince) {
        parameters.add(new NameValuePair("startDateSince", startDateSince));
        return this;
    }

    public GetIssuesParams startDateUntil(String startDateUntil) {
        parameters.add(new NameValuePair("startDateUntil", startDateUntil));
        return this;
    }

    public GetIssuesParams dueDateSince(String dueDateSince) {
        parameters.add(new NameValuePair("dueDateSince", dueDateSince));
        return this;
    }

    public GetIssuesParams dueDateUntil(String dueDateUntil) {
        parameters.add(new NameValuePair("dueDateUntil", dueDateUntil));
        return this;
    }

    public GetIssuesParams ids(List ids) {
        for (Object id : ids) {
            parameters.add(new NameValuePair("id[]", id.toString()));
        }
        return this;
    }

    public GetIssuesParams parentIssueIds(List parentIssueIds) {
        for (Object parentIssueId : parentIssueIds) {
            parameters.add(new NameValuePair("parentIssueId[]", parentIssueId.toString()));
        }
        return this;
    }

    public GetIssuesParams keyword(String keyword) throws BacklogException {
        parameters.add(new NameValuePair("keyword", keyword));
        return this;
    }

    public GetIssuesParams keywordByCustomField(Object customFieldId, String keyword) throws BacklogException {
        parameters.add(new NameValuePair("customField_" + customFieldId.toString(),
                keyword));

        return this;
    }

    public GetIssuesParams minNumOfCustomField(Object customFieldId, float min) throws BacklogException {
        parameters.add(new NameValuePair("customField_" + customFieldId.toString() + "_min",
                String.valueOf(min)));
        return this;
    }

    public GetIssuesParams maxNumOfCustomField(Object customFieldId, float max) throws BacklogException {
        parameters.add(new NameValuePair("customField_" + customFieldId.toString() + "_max",
                String.valueOf(max)));
        return this;
    }

    public GetIssuesParams minDateOfCustomField(Object customFieldId, String min) throws BacklogException {
        parameters.add(new NameValuePair("customField_" + customFieldId.toString() + "_min",
                min));
        return this;
    }

    public GetIssuesParams maxDateOfCustomField(Object customFieldId, String max) throws BacklogException {
        parameters.add(new NameValuePair("customField_" + customFieldId.toString() + "_max",
                max));
        return this;
    }

    public GetIssuesParams itemsOfCustomField(Object customFieldId, List itemIds) {
        for (Object itemId : itemIds) {
            parameters.add(new NameValuePair("customField_" + customFieldId.toString() + "[]",
                    itemId.toString()));
        }
        return this;
    }
}
