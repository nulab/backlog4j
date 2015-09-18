package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class CreateIssueParamsTest extends AbstractParamsTest{
    @Test
    public void createParamTest() throws UnsupportedEncodingException {

        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.parentIssueId(3000000001l)
                .description("This is a test issue.")
                .startDate("2014-08-01")
                .dueDate("2014-12-01")
                .estimatedHours(16)
                .actualHours(12.51f)
                .assigneeId(4000000001l)
                .categoryIds(Arrays.asList(5000000001l, 5000000002l))
                .versionIds(Arrays.asList(6000000001l, 6000000002l))
                .milestoneIds(Arrays.asList(7000000001l, 7000000002l))
                .notifiedUserIds(Arrays.asList(8000000001l, 8000000002l))
                .attachmentIds(Arrays.asList(9000000001l, 9000000002l));


        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(21, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "projectId", "1000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "summary", "test issue 1"));
        assertEquals(true, existsOneKeyValue(parameters, "issueTypeId", "2000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "priorityId", "2"));
        assertEquals(true, existsOneKeyValue(parameters, "parentIssueId", "3000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "description", "This is a test issue."));
        assertEquals(true, existsOneKeyValue(parameters, "startDate", "2014-08-01"));
        assertEquals(true, existsOneKeyValue(parameters, "dueDate", "2014-12-01"));
        assertEquals(true, existsOneKeyValue(parameters, "estimatedHours", "16.0"));
        assertEquals(true, existsOneKeyValue(parameters, "actualHours", "12.51"));
        assertEquals(true, existsOneKeyValue(parameters, "assigneeId", "4000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "categoryId[]", "5000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "categoryId[]", "5000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "versionId[]", "6000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "versionId[]", "6000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "milestoneId[]", "7000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "milestoneId[]", "7000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "notifiedUserId[]", "8000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "notifiedUserId[]", "8000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "attachmentId[]", "9000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "attachmentId[]", "9000000002"));
    }

    @Test
    public void createTextCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.textCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001l, "egg"),
                new CustomFiledValue(3000000002l, "rice")));

        params.textCustomField(new CustomFiledValue(3000000003l, "tea"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "egg"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "rice"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "tea"));
    }

    @Test
    public void createTextAreaCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.textAreaCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001l, "egg"),
                new CustomFiledValue(3000000002l, "rice")));

        params.textAreaCustomField(new CustomFiledValue(3000000003l, "tea"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "egg"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "rice"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "tea"));
    }

    @Test
    public void createNumericCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.numericCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001l, -111f),
                new CustomFiledValue(3000000002l, 5555.121f)));

        params.numericCustomField(new CustomFiledValue(3000000003l, 123.61f));
        params.numericCustomField(new CustomFiledValue(3000000004l, 123.67777));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "-111.0"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "5555.121"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "123.61"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000004", "123.67777"));
    }

    @Test
    public void createDateCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.dateCustomFields(Arrays.asList(
                new CustomFiledValue(3000000001l, "2008-10-01"),
                new CustomFiledValue(3000000002l, "2008-10-02")));

        params.dateCustomField(new CustomFiledValue(3000000003l, "2008-10-10"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "2008-10-01"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "2008-10-02"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "2008-10-10"));
    }

    @Test
    public void createSingleListCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.singleListCustomFields(Arrays.asList(
                new CustomFiledItem(3000000001l, 4000000001l),
                new CustomFiledItem(3000000002l, 4000000002l)));

        params.singleListCustomField(new CustomFiledItem(3000000003l, 4000000003l));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "4000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "4000000003"));
    }

    @Test
    public void createRadioCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.radioCustomFields(Arrays.asList(
                new CustomFiledItem(3000000001l, 4000000001l),
                new CustomFiledItem(3000000002l, 4000000002l)));

        params.radioCustomField(new CustomFiledItem(3000000003l, 4000000003l));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "4000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "4000000003"));
    }

    @Test
    public void createMultipleListCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.multipleListCustomFields(Arrays.asList(
                new CustomFiledItems(3000000001l, Arrays.asList(4000000001l, 4000000002l)),
                new CustomFiledItems(3000000002l, Arrays.asList(4000000003l,4000000004l))));

        params.multipleListCustomField(new CustomFiledItems(3000000003l, Arrays.asList(4000000005l, 4000000006l)));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "4000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "4000000003"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "4000000004"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "4000000005"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "4000000006"));
    }

    @Test
    public void createCheckBoxListCustomFieldParamTest() throws UnsupportedEncodingException {
        // when
        CreateIssueParams params = new CreateIssueParams(1000000001l, "test issue 1", 2000000001l, Issue.PriorityType.High);
        params.checkBoxCustomFields(Arrays.asList(
                new CustomFiledItems(3000000001l, Arrays.asList(4000000001l, 4000000002l)),
                new CustomFiledItems(3000000002l, Arrays.asList(4000000003l, 4000000004l))));

        params.checkBoxCustomField(new CustomFiledItems(3000000003l, Arrays.asList(4000000005l, 4000000006l)));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "4000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000001", "4000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "4000000003"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000002", "4000000004"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "4000000005"));
        assertEquals(true, existsOneKeyValue(parameters, "customField_3000000003", "4000000006"));
    }
}
