package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class ProjectJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createProjectListTest() throws IOException {
        String fileContentStr = getJsonString("json/projects.json");
        ResponseList<Project> projects = factory.createProjectList(fileContentStr);

        assertEquals(2, projects.size());

        Project project = projects.get(0);
        assertEquals(1073835211, project.getId());
        assertEquals("TST_PRJ", project.getProjectKey());
        assertEquals("テストプロジェクト", project.getName());
        assertEquals(true, project.isUseGantt());
        assertEquals(true, project.isUseBurndown());
        assertEquals(true, project.isChartEnabled());
        assertEquals(true, project.isSubtaskingEnabled());
        assertEquals(Project.TextFormattingRule.Backlog, project.getTextFormattingRule());
        assertEquals(false, project.isArchived());

        project = projects.get(1);
        assertEquals(1073835220, project.getId());
        assertEquals("TEST_PRJ_2", project.getProjectKey());
        assertEquals("API v2 から作成したテストプロジェクト", project.getName());
        assertEquals(false, project.isUseGantt());
        assertEquals(false, project.isUseBurndown());
        assertEquals(false, project.isChartEnabled());
        assertEquals(true, project.isSubtaskingEnabled());
        assertEquals(Project.TextFormattingRule.Markdown, project.getTextFormattingRule());
        assertEquals(false, project.isArchived());

    }

    @Test
    public void createProjectTest() throws IOException {
        String fileContentStr = getJsonString("json/project.json");
        Project project = factory.createProject(fileContentStr);

        assertEquals(1073835211, project.getId());
        assertEquals("TST_PRJ", project.getProjectKey());
        assertEquals("テストプロジェクト", project.getName());
        assertEquals(false, project.isUseGantt());
        assertEquals(true, project.isUseBurndown());
        assertEquals(false, project.isChartEnabled());
        assertEquals(true, project.isSubtaskingEnabled());
        assertEquals(Project.TextFormattingRule.Backlog, project.getTextFormattingRule());
        assertEquals(false, project.isArchived());
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
