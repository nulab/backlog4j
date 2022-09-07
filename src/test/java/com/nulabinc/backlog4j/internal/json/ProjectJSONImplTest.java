package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class ProjectJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createProjectListTest() throws IOException {
        String fileContentStr = getJsonString("json/projects.json");
        ResponseList<Project> projects = factory.createProjectList(fileContentStr);

        assertEquals(2, projects.size());

        Project project = projects.get(0);
        assertEquals(1073835211, project.getId());
        assertEquals("TST_PRJ", project.getProjectKey());
        assertEquals("テストプロジェクト", project.getName());
        assertTrue(project.isChartEnabled());
        assertTrue(project.isSubtaskingEnabled());
        assertFalse(project.isProjectLeaderCanEditProjectLeader());
        assertEquals(Project.TextFormattingRule.Backlog, project.getTextFormattingRule());
        assertFalse(project.isArchived());
        assertTrue(project.getUseWiki());
        assertTrue(project.getUseFileSharing());
        assertTrue(project.getUseDevAttributes());
        assertTrue(project.getUseResolvedForChart());
        assertTrue(project.getUseWikiTreeView());
        assertTrue(project.getUseOriginalImageSizeAtWiki());

        project = projects.get(1);
        assertEquals(1073835220, project.getId());
        assertEquals("TEST_PRJ_2", project.getProjectKey());
        assertEquals("API v2 から作成したテストプロジェクト", project.getName());
        assertFalse(project.isChartEnabled());
        assertTrue(project.isSubtaskingEnabled());
        assertEquals(Project.TextFormattingRule.Markdown, project.getTextFormattingRule());
        assertFalse(project.getUseWiki());
        assertFalse(project.getUseFileSharing());
        assertFalse(project.isArchived());
        assertFalse(project.getUseDevAttributes());
        assertFalse(project.getUseResolvedForChart());
        assertFalse(project.getUseWikiTreeView());
        assertFalse(project.getUseOriginalImageSizeAtWiki());

    }

    @Test
    public void createProjectTest() throws IOException {
        String fileContentStr = getJsonString("json/project.json");
        Project project = factory.createProject(fileContentStr);

        assertEquals(1073835211, project.getId());
        assertEquals("TST_PRJ", project.getProjectKey());
        assertEquals("テストプロジェクト", project.getName());
        assertFalse(project.isChartEnabled());
        assertTrue(project.isSubtaskingEnabled());
        assertEquals(Project.TextFormattingRule.Backlog, project.getTextFormattingRule());
        assertFalse(project.isArchived());
        assertTrue(project.getUseWiki());
        assertTrue(project.getUseFileSharing());
        assertTrue(project.getUseDevAttributes());
        assertTrue(project.getUseResolvedForChart());
        assertTrue(project.getUseWikiTreeView());
        assertTrue(project.getUseOriginalImageSizeAtWiki());
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/project.json");
        Project project1 = factory.createProject(fileContentStr);
        Project project2 = factory.createProject(fileContentStr);
        assertEquals(project1, project2);

    }

    @Test
    public void hashCodeTest1() throws IOException {
        String fileContentStr = getJsonString("json/project.json");
        Project project1 = factory.createProject(fileContentStr);
        Project project2 = factory.createProject(fileContentStr);
        assertEquals(project1.hashCode(), project2.hashCode());

    }
}
