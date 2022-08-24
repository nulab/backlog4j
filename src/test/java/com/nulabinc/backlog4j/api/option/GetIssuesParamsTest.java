package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class GetIssuesParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() {

        // when
        GetIssuesParams params = new GetIssuesParams(Arrays.asList(1000000001L, 1000000002L));
        params.assigneeIds(Arrays.asList(2000000001L, 2000000002L))
                .attachment(true)
                .categoryIds(Arrays.asList(3000000001L, 3000000002L))
                .count(9999)
                .createdSince("2014-07-01")
                .createdUntil("2014-08-01")
                .createdUserIds(Arrays.asList(4000000001L, 4000000002L))
                .dueDateSince("2014-09-01")
                .dueDateUntil("2014-10-01")
                .ids(Arrays.asList(5000000001L, 5000000002L))
                .issueTypeIds(Arrays.asList(6000000001L, 6000000002L))
                .keyword("beer noodle")
                .milestoneIds(Arrays.asList(7000000001L, 7000000002L))
                .offset(100)
                .order(GetIssuesParams.Order.Desc)
                .parentChildType(GetIssuesParams.ParentChildType.NotChildNotParent)
                .parentIssueIds(Arrays.asList(8000000001L, 8000000002L))
                .priorities(Arrays.asList(Issue.PriorityType.High, Issue.PriorityType.Low))
                .resolutions(Arrays.asList(Issue.ResolutionType.Fixed, Issue.ResolutionType.Invalid))
                .sharedFile(true)
                .sort(GetIssuesParams.SortKey.Category)
                .startDateSince("2014-11-01")
                .startDateUntil("2014-12-01")
                .statuses(Arrays.asList(Issue.StatusType.Closed, Issue.StatusType.InProgress))
                .updatedSince("2015-01-01")
                .updatedUntil("2015-02-01")
                .versionIds(Arrays.asList(11000000001L, 11000000002L))
                .keywordByCustomField(12000000000L, "ビール")
                .minNumOfCustomField(12000000001L, 10.123f)
                .maxNumOfCustomField(12000000002L, -11.999f)
                .minDateOfCustomField(12000000003L, "2014-11-10")
                .maxDateOfCustomField(12000000004L, "2014-11-12")
                .itemsOfCustomField(12000000005L, Arrays.asList(13000000001L, 13000000002L));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(47, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "projectId[]", "1000000001"));
        assertTrue(existsOneKeyValue(parameters, "projectId[]", "1000000002"));
        assertTrue(existsOneKeyValue(parameters, "assigneeId[]", "2000000001"));
        assertTrue(existsOneKeyValue(parameters, "assigneeId[]", "2000000002"));
        assertTrue(existsOneKeyValue(parameters, "attachment", "true"));
        assertTrue(existsOneKeyValue(parameters, "categoryId[]", "3000000001"));
        assertTrue(existsOneKeyValue(parameters, "categoryId[]", "3000000002"));
        assertTrue(existsOneKeyValue(parameters, "count", "9999"));
        assertTrue(existsOneKeyValue(parameters, "createdSince", "2014-07-01"));
        assertTrue(existsOneKeyValue(parameters, "createdUntil", "2014-08-01"));
        assertTrue(existsOneKeyValue(parameters, "createdUserId[]", "4000000001"));
        assertTrue(existsOneKeyValue(parameters, "createdUserId[]", "4000000002"));
        assertTrue(existsOneKeyValue(parameters, "dueDateSince", "2014-09-01"));
        assertTrue(existsOneKeyValue(parameters, "dueDateUntil", "2014-10-01"));
        assertTrue(existsOneKeyValue(parameters, "id[]", "5000000001"));
        assertTrue(existsOneKeyValue(parameters, "id[]", "5000000002"));
        assertTrue(existsOneKeyValue(parameters, "issueTypeId[]", "6000000001"));
        assertTrue(existsOneKeyValue(parameters, "issueTypeId[]", "6000000002"));
        assertTrue(existsOneKeyValue(parameters, "keyword", "beer noodle"));
        assertTrue(existsOneKeyValue(parameters, "milestoneId[]", "7000000001"));
        assertTrue(existsOneKeyValue(parameters, "milestoneId[]", "7000000002"));
        assertTrue(existsOneKeyValue(parameters, "offset", "100"));
        assertTrue(existsOneKeyValue(parameters, "order", "desc"));
        assertTrue(existsOneKeyValue(parameters, "parentChild", "3"));
        assertTrue(existsOneKeyValue(parameters, "parentIssueId[]", "8000000001"));
        assertTrue(existsOneKeyValue(parameters, "parentIssueId[]", "8000000002"));
        assertTrue(existsOneKeyValue(parameters, "priorityId[]", "2"));
        assertTrue(existsOneKeyValue(parameters, "priorityId[]", "4"));
        assertTrue(existsOneKeyValue(parameters, "resolutionId[]", "0"));
        assertTrue(existsOneKeyValue(parameters, "resolutionId[]", "2"));
        assertTrue(existsOneKeyValue(parameters, "sharedFile", "true"));
        assertTrue(existsOneKeyValue(parameters, "sort", "category"));
        assertTrue(existsOneKeyValue(parameters, "updatedSince", "2015-01-01"));
        assertTrue(existsOneKeyValue(parameters, "updatedUntil", "2015-02-01"));
        assertTrue(existsOneKeyValue(parameters, "versionId[]", "11000000001"));
        assertTrue(existsOneKeyValue(parameters, "versionId[]", "11000000002"));
        assertTrue(existsOneKeyValue(parameters, "customField_12000000000", "ビール"));
        assertTrue(existsOneKeyValue(parameters, "customField_12000000001_min", "10.123"));
        assertTrue(existsOneKeyValue(parameters, "customField_12000000002_max", "-11.999"));
        assertTrue(existsOneKeyValue(parameters, "customField_12000000003_min", "2014-11-10"));
        assertTrue(existsOneKeyValue(parameters, "customField_12000000004_max", "2014-11-12"));
        assertTrue(existsOneKeyValue(parameters, "customField_12000000005[]", "13000000001"));
        assertTrue(existsOneKeyValue(parameters, "customField_12000000005[]", "13000000002"));
    }

    @Test
    public void createParamWithCustomStatusTest() {

        // when
        GetIssuesParams params = new GetIssuesParams(Arrays.asList(1000000001L, 1000000002L));
        params.statusIds(Arrays.asList(9000000001L, 9000000002L));

        // then
        List<NameValuePair> parameters = params.getParamList();
        System.out.println(parameters);
        assertEquals(4, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "projectId[]", "1000000001"));
        assertTrue(existsOneKeyValue(parameters, "projectId[]", "1000000002"));
        assertTrue(existsOneKeyValue(parameters, "statusId[]", "9000000001"));
        assertTrue(existsOneKeyValue(parameters, "statusId[]", "9000000002"));
    }
}
