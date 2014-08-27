package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import org.apache.http.NameValuePair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class GetIssuesParamsTest extends AbstractParamsTest{
    @Test
    public void createParamTest() throws UnsupportedEncodingException {

        // when
        GetIssuesParams params = new GetIssuesParams(Arrays.asList(1000000001l, 1000000002l));
        params.assignerIds(Arrays.asList(2000000001l, 2000000002l))
                .attachment(true)
                .categoryIds(Arrays.asList(3000000001l, 3000000002l))
                .count(9999)
                .createdSince("2014-07-01")
                .createdUntil("2014-08-01")
                .createdUserIds(Arrays.asList(4000000001l, 4000000002l))
                .dueDateSince("2014-09-01")
                .dueDateUntil("2014-10-01")
                .ids(Arrays.asList(5000000001l, 5000000002l))
                .issueTypeIds(Arrays.asList(6000000001l, 6000000002l))
                .keyword("beer noodle")
                .milestoneIds(Arrays.asList(7000000001l, 7000000002l))
                .offset(100)
                .order(GetIssuesParams.Order.Desc)
                .parentChildType(GetIssuesParams.ParentChildType.NotChildNotParent)
                .parentIssueIds(Arrays.asList(8000000001l, 8000000002l))
                .priorities(Arrays.asList(Issue.PriorityType.High, Issue.PriorityType.Low))
                .projectIds(Arrays.asList(9000000001l, 9000000002l))
                .resolutions(Arrays.asList(Issue.ResolutionType.Fixed, Issue.ResolutionType.Invalid))
                .sharedFile(true)
                .sort(GetIssuesParams.SortKey.Category)
                .startDateSince("2014-11-01")
                .startDateUntil("2014-12-01")
                .statuses(Arrays.asList(Issue.StatusType.Closed, Issue.StatusType.InProgress))
                .updatedSince("2015-01-01")
                .updatedUntil("2015-02-01")
                .versionIds(Arrays.asList(11000000001l, 11000000002l));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(42, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "projectId[]", "1000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "projectId[]", "1000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "assigneeId[]", "2000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "assigneeId[]", "2000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "attachment", "true"));
        assertEquals(true, existsOneKeyValue(parameters, "categoryId[]", "3000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "categoryId[]", "3000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "count", "9999"));
        assertEquals(true, existsOneKeyValue(parameters, "createdSince", "2014-07-01"));
        assertEquals(true, existsOneKeyValue(parameters, "createdUntil", "2014-08-01"));
        assertEquals(true, existsOneKeyValue(parameters, "createdUserId[]", "4000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "createdUserId[]", "4000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "dueDateSince", "2014-09-01"));
        assertEquals(true, existsOneKeyValue(parameters, "dueDateUntil", "2014-10-01"));
        assertEquals(true, existsOneKeyValue(parameters, "id[]", "5000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "id[]", "5000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "issueTypeId[]", "6000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "issueTypeId[]", "6000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "keyword", URLEncoder.encode("beer noodle", "utf-8")));
        assertEquals(true, existsOneKeyValue(parameters, "milestoneId[]", "7000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "milestoneId[]", "7000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "offset", "100"));
        assertEquals(true, existsOneKeyValue(parameters, "order", "desc"));
        assertEquals(true, existsOneKeyValue(parameters, "parentChild", "3"));
        assertEquals(true, existsOneKeyValue(parameters, "parentIssueId[]", "8000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "parentIssueId[]", "8000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "priorityId[]", "2"));
        assertEquals(true, existsOneKeyValue(parameters, "priorityId[]", "4"));
        assertEquals(true, existsOneKeyValue(parameters, "projectId[]", "9000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "projectId[]", "9000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "resolutionId[]", "0"));
        assertEquals(true, existsOneKeyValue(parameters, "resolutionId[]", "2"));
        assertEquals(true, existsOneKeyValue(parameters, "sharedFile", "true"));
        assertEquals(true, existsOneKeyValue(parameters, "sort", "category"));
        assertEquals(true, existsOneKeyValue(parameters, "updatedSince", "2015-01-01"));
        assertEquals(true, existsOneKeyValue(parameters, "updatedUntil", "2015-02-01"));
        assertEquals(true, existsOneKeyValue(parameters, "versionId[]", "11000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "versionId[]", "11000000002"));
    }
}
