package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class IssueJSONImplTest extends AbstractJSONImplTest {
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

    @Test
    public void equalsTest1() throws IOException {
        String fileContentStr = getJsonString("json/issue.json");
        Issue issue1 = factory.createIssue(fileContentStr);
        Issue issue2 = factory.createIssue(fileContentStr);
        assertEquals(issue1, issue2);

    }

    @Test
    public void equalsTest2() throws IOException {
        String fileContentStr = getJsonString("json/custom_field_issue.json");
        Issue issue1 = factory.createIssue(fileContentStr);
        Issue issue2 = factory.createIssue(fileContentStr);
        assertEquals(issue1, issue2);

    }


    @Test
    public void hashCodeTest1() throws IOException {
        String fileContentStr = getJsonString("json/issue.json");
        Issue issue1 = factory.createIssue(fileContentStr);
        Issue issue2 = factory.createIssue(fileContentStr);
        assertEquals(issue1.hashCode(), issue2.hashCode());

    }

    @Test
    public void hashCodeTest2() throws IOException {
        String fileContentStr = getJsonString("json/custom_field_issue.json");
        Issue issue1 = factory.createIssue(fileContentStr);
        Issue issue2 = factory.createIssue(fileContentStr);
        assertEquals(issue1.hashCode(), issue2.hashCode());

    }
}
