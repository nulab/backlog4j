package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.IssueType;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class IssueTypeJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createIssueTypeListTest() throws IOException {
        String fileContentStr = getJsonString("json/issue_types.json");
        ResponseList<IssueType> issueTypes = factory.createIssueTypeList(fileContentStr);

        assertEquals(4, issueTypes.size());

        IssueType issueType = issueTypes.get(0);
        assertEquals(1074178332, issueType.getId());
        assertEquals(1073836557, issueType.getProjectId());
        assertEquals("バグ", issueType.getName());
        assertEquals(Project.IssueTypeColor.Color2, issueType.getColor());

        issueType = issueTypes.get(1);
        assertEquals(1074178333, issueType.getId());
        assertEquals(1073836557, issueType.getProjectId());
        assertEquals("タスク", issueType.getName());
        assertEquals(Project.IssueTypeColor.Color7, issueType.getColor());

        issueType = issueTypes.get(2);
        assertEquals(1074178334, issueType.getId());
        assertEquals(1073836557, issueType.getProjectId());
        assertEquals("要望", issueType.getName());
        assertEquals(Project.IssueTypeColor.Color8, issueType.getColor());

        issueType = issueTypes.get(3);
        assertEquals(1074178335, issueType.getId());
        assertEquals(1073836557, issueType.getProjectId());
        assertEquals("その他", issueType.getName());
        assertEquals(Project.IssueTypeColor.Color5, issueType.getColor());

    }

    @Test
    public void createIssueTypeTest() throws IOException {
        String fileContentStr = getJsonString("json/issue_type.json");
        IssueType issueType = factory.createIssueType(fileContentStr);

        assertEquals(1074178332, issueType.getId());
        assertEquals(1073836557, issueType.getProjectId());
        assertEquals("バグ", issueType.getName());
        assertEquals(Project.IssueTypeColor.Color2, issueType.getColor());
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/issue_type.json");
        IssueType issueType1 = factory.createIssueType(fileContentStr);
        IssueType issueType2 = factory.createIssueType(fileContentStr);
        assertEquals(issueType1, issueType2);

    }
}
