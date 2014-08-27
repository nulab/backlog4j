package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class IssueJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createIssueListTest() throws IOException {
        String fileContentStr = getJsonString("json/issues.json");
        ResponseList<Issue> issues = factory.createIssueList(fileContentStr);

        assertEquals(2, issues.size());

        Issue issue = issues.get(0);
        assertEquals(1079196895, issue.getId());
        assertEquals(1073835361, issue.getProjectId());

        issue = issues.get(1);
        assertEquals(1079097008, issue.getId());
        assertEquals(1073835361, issue.getProjectId());

    }

    @Test
    public void createIssueTest() throws IOException {
        String fileContentStr = getJsonString("json/issue.json");
        Issue issue = factory.createIssue(fileContentStr);

        assertEquals(1079313630, issue.getId());
        assertEquals(1073836557, issue.getProjectId());
    }



    @Test
    public void createCustomFiledIssueTest() throws IOException {
        String fileContentStr = getJsonString("json/custom_field_issue.json");
        Issue issue = factory.createIssue(fileContentStr);

        assertEquals(1073804154, issue.getId());
    }
}
