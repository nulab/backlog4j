package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class UpdateIssueParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() {

        // when
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
        params.summary("test issue 1")
                .issueTypeId(2000000001L)
                .priority(Issue.PriorityType.Normal)
                .parentIssueId(3000000001L)
                .description("This is a test issue.")
                .startDate("2014-08-01")
                .dueDate("2014-12-01")
                .estimatedHours(16)
                .actualHours(12.5f)
                .assigneeId(4000000001L)
                .categoryIds(Arrays.asList(5000000001L, 5000000002L))
                .versionIds(Arrays.asList(6000000001L, 6000000002L))
                .milestoneIds(Arrays.asList(7000000001L, 7000000002L))
                .notifiedUserIds(Arrays.asList(8000000001L, 8000000002L))
                .attachmentIds(Arrays.asList(9000000001L, 9000000002L))
                .comment("issue comment")
                .status(Issue.StatusType.Resolved)
                .resolution(Issue.ResolutionType.Fixed);

        // then
        assertEquals("1000000001", params.getIssueIdOrKeyString());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(23, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "summary", "test issue 1"));
        assertTrue(existsOneKeyValue(parameters, "issueTypeId", "2000000001"));
        assertTrue(existsOneKeyValue(parameters, "priorityId", "3"));
        assertTrue(existsOneKeyValue(parameters, "parentIssueId", "3000000001"));
        assertTrue(existsOneKeyValue(parameters, "description", "This is a test issue."));
        assertTrue(existsOneKeyValue(parameters, "startDate", "2014-08-01"));
        assertTrue(existsOneKeyValue(parameters, "dueDate", "2014-12-01"));
        assertTrue(existsOneKeyValue(parameters, "estimatedHours", "16"));
        assertTrue(existsOneKeyValue(parameters, "actualHours", "12.5"));
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
        assertTrue(existsOneKeyValue(parameters, "comment", "issue comment"));
        assertTrue(existsOneKeyValue(parameters, "statusId", "3"));
        assertTrue(existsOneKeyValue(parameters, "resolutionId", "0"));
    }

    @Test
    public void createParamEmptySetTest() {

        // when
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
        params.resolution(null).assigneeId(0L)
                .dueDate(null).startDate(null)
                .categoryIds(null).versionIds(null).milestoneIds(null)
                .estimatedHours(null).actualHours(null);

        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "resolutionId", ""));
        assertTrue(existsOneKeyValue(parameters, "assigneeId", ""));
        assertTrue(existsOneKeyValue(parameters, "dueDate", ""));
        assertTrue(existsOneKeyValue(parameters, "startDate", ""));
        assertTrue(existsOneKeyValue(parameters, "categoryId[]", ""));
        assertTrue(existsOneKeyValue(parameters, "versionId[]", ""));
        assertTrue(existsOneKeyValue(parameters, "milestoneId[]", ""));
        assertTrue(existsOneKeyValue(parameters, "estimatedHours", ""));
        assertTrue(existsOneKeyValue(parameters, "actualHours", ""));

    }


    @Test
    public void createTextCustomFieldParamTest() {
        // when
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
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

    @Test
    public void createIntHoursParamTest() {

        // when
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
        params.estimatedHours(16)
                .actualHours(12);

        // then
        assertEquals("1000000001", params.getIssueIdOrKeyString());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(2, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "estimatedHours", "16"));
        assertTrue(existsOneKeyValue(parameters, "actualHours", "12"));
    }

    @Test
    public void createFloatHoursParamTest() {

        // when
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
        params.estimatedHours(16.00f)
                .actualHours(12.12f);

        // then
        assertEquals("1000000001", params.getIssueIdOrKeyString());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(2, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "estimatedHours", "16.0"));
        assertTrue(existsOneKeyValue(parameters, "actualHours", "12.12"));
    }


    @Test
    public void createBigDecimalHoursParamTest() {

        // when
        UpdateIssueParams params = new UpdateIssueParams(1000000001L);
        params.estimatedHours(new BigDecimal("16.00"))
                .actualHours(new BigDecimal("12.12345"));

        // then
        assertEquals("1000000001", params.getIssueIdOrKeyString());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(2, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "estimatedHours", "16.00"));
        assertTrue(existsOneKeyValue(parameters, "actualHours", "12.12"));
    }

}
