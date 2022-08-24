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
public class CreateIssueParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() {

        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.parentIssueId(3000000001L)
                .description("This is a test issue.")
                .startDate("2014-08-01")
                .dueDate("2014-12-01")
                .estimatedHours(16)
                .actualHours(12.51f)
                .assigneeId(4000000001L)
                .categoryIds(Arrays.asList(5000000001L, 5000000002L))
                .versionIds(Arrays.asList(6000000001L, 6000000002L))
                .milestoneIds(Arrays.asList(7000000001L, 7000000002L))
                .notifiedUserIds(Arrays.asList(8000000001L, 8000000002L))
                .attachmentIds(Arrays.asList(9000000001L, 9000000002L));


        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(21, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "projectId", "1000000001"));
        assertTrue(existsOneKeyValue(parameters, "summary", "test issue 1"));
        assertTrue(existsOneKeyValue(parameters, "issueTypeId", "2000000001"));
        assertTrue(existsOneKeyValue(parameters, "priorityId", "2"));
        assertTrue(existsOneKeyValue(parameters, "parentIssueId", "3000000001"));
        assertTrue(existsOneKeyValue(parameters, "description", "This is a test issue."));
        assertTrue(existsOneKeyValue(parameters, "startDate", "2014-08-01"));
        assertTrue(existsOneKeyValue(parameters, "dueDate", "2014-12-01"));
        assertTrue(existsOneKeyValue(parameters, "estimatedHours", "16.0"));
        assertTrue(existsOneKeyValue(parameters, "actualHours", "12.51"));
        assertTrue(existsOneKeyValue(parameters, "assigneeId", "4000000001"));
        assertTrue(existsOneKeyValue(parameters, "categoryId[]", "5000000001"));
        assertTrue(existsOneKeyValue(parameters, "categoryId[]", "5000000002"));
        assertTrue(existsOneKeyValue(parameters, "versionId[]", "6000000001"));
        assertTrue(existsOneKeyValue(parameters, "versionId[]", "6000000002"));
        assertTrue(existsOneKeyValue(parameters, "milestoneId[]", "7000000001"));
        assertTrue(existsOneKeyValue(parameters, "milestoneId[]", "7000000002"));
        assertTrue(existsOneKeyValue(parameters, "notifiedUserId[]", "8000000001"));
        assertTrue(existsOneKeyValue(parameters, "notifiedUserId[]", "8000000002"));
        assertTrue(existsOneKeyValue(parameters, "attachmentId[]", "9000000001"));
        assertTrue(existsOneKeyValue(parameters, "attachmentId[]", "9000000002"));
    }

    @Test
    public void createTextCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.textCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001L, "egg"),
                new CustomFiledValue(3000000002L, "rice")));

        params.textCustomField(new CustomFiledValue(3000000003L, "tea"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "egg"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "rice"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "tea"));
    }

    @Test
    public void createTextAreaCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.textAreaCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001L, "egg"),
                new CustomFiledValue(3000000002L, "rice")));

        params.textAreaCustomField(new CustomFiledValue(3000000003L, "tea"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "egg"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "rice"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "tea"));
    }

    @Test
    public void createNumericCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.numericCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001L, -111f),
                new CustomFiledValue(3000000002L, 5555.121f)));

        params.numericCustomField(new CustomFiledValue(3000000003L, 123.61f));
        params.numericCustomField(new CustomFiledValue(3000000004L, 123.67777));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "-111.0"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "5555.121"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "123.61"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000004", "123.67777"));
    }

    @Test
    public void createDateCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.dateCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001L, "2008-10-01"),
                new CustomFiledValue(3000000002L, "2008-10-02")));

        params.dateCustomField(new CustomFiledValue(3000000003L, "2008-10-10"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "2008-10-01"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "2008-10-02"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "2008-10-10"));
    }

    @Test
    public void createSingleListCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.singleListCustomFields(Arrays.asList(
                new CustomFiledItem(3000000001L, 4000000001L),
                new CustomFiledItem(3000000002L, 4000000002L)));

        params.singleListCustomField(new CustomFiledItem(3000000003L, 4000000003L));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "4000000002"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "4000000003"));
    }

    @Test
    public void createRadioCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.radioCustomFields(Arrays.asList(
                new CustomFiledItem(3000000001L, 4000000001L),
                new CustomFiledItem(3000000002L, 4000000002L)));

        params.radioCustomField(new CustomFiledItem(3000000003L, 4000000003L));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "4000000002"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "4000000003"));
    }

    @Test
    public void createMultipleListCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.multipleListCustomFields(Arrays.asList(
                new CustomFiledItems(3000000001L, Arrays.asList(4000000001L, 4000000002L)),
                new CustomFiledItems(3000000002L, Arrays.asList(4000000003L, 4000000004L))));

        params.multipleListCustomField(new CustomFiledItems(3000000003L, Arrays.asList(4000000005L, 4000000006L)));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "4000000002"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "4000000003"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "4000000004"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "4000000005"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "4000000006"));
    }

    @Test
    public void createCheckBoxListCustomFieldParamTest() {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001L, "test issue 1", 2000000001L, Issue.PriorityType.High);
        params.checkBoxCustomFields(Arrays.asList(
                new CustomFiledItems(3000000001L, Arrays.asList(4000000001L, 4000000002L)),
                new CustomFiledItems(3000000002L, Arrays.asList(4000000003L, 4000000004L))));

        params.checkBoxCustomField(new CustomFiledItems(3000000003L, Arrays.asList(4000000005L, 4000000006L)));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000001", "4000000002"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "4000000003"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000002", "4000000004"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "4000000005"));
        assertTrue(existsOneKeyValue(parameters, "customField_3000000003", "4000000006"));
    }
}
