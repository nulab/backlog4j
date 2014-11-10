package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Parameters for get issue API.
 *
 * @author nulab-inc
 */
public class GetIssuesParams extends GetIssuesCountParams {
    public GetIssuesParams(List<Long> projectIds) {
        super(projectIds);
    }

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


    public GetIssuesParams sort(SortKey sort) {
        parameters.add(new NameValuePair("sort", sort.getStrValue()));
        return this;
    }

    public GetIssuesParams sortByCustomField(long customFieldId) {
        parameters.add(new NameValuePair("sort", "customField_" + String.valueOf(customFieldId)));
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
}
