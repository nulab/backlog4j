package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.Status;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class StatusJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createStatusListTest() throws IOException {
        String fileContentStr = getJsonString("json/statuses.json");
        ResponseList<Status> statuses = factory.createStatusList(fileContentStr);

        assertEquals(4, statuses.size());

        Status status = statuses.get(0);
        assertEquals(1, status.getId());
        assertEquals("未対応", status.getName());
        assertEquals(Issue.StatusType.Open, status.getStatusType());

        assertEquals(null, status.getColor());
        assertEquals(0, status.getProjectId());
        assertEquals("0", status.getProjectIdAsString());
        assertEquals(0, status.getDisplayOrder());

        status = statuses.get(1);
        assertEquals(2, status.getId());
        assertEquals("処理中", status.getName());
        assertEquals(Issue.StatusType.InProgress, status.getStatusType());

        status = statuses.get(2);
        assertEquals(3, status.getId());
        assertEquals("処理済み", status.getName());
        assertEquals(Issue.StatusType.Resolved, status.getStatusType());

        status = statuses.get(3);
        assertEquals(4, status.getId());
        assertEquals("完了", status.getName());
        assertEquals(Issue.StatusType.Closed, status.getStatusType());
    }


    @Test
    public void createCustomStatusListTest() throws IOException {
        String fileContentStr = getJsonString("json/custom_statuses.json");
        ResponseList<Status> statuses = factory.createStatusList(fileContentStr);

        assertEquals(3, statuses.size());

        Status status = statuses.get(0);
        assertEquals(100, status.getId());
        assertEquals("保留中 / Pending", status.getName());
        assertEquals(Issue.StatusType.Custom, status.getStatusType());
        assertEquals(Project.CustomStatusColor.Color1, status.getColor());
        assertEquals(1, status.getProjectId());
        assertEquals("1", status.getProjectIdAsString());
        assertEquals(1000, status.getDisplayOrder());

        status = statuses.get(1);
        assertEquals(101, status.getId());
        assertEquals("調査中 / Researching", status.getName());
        assertEquals(Issue.StatusType.Custom, status.getStatusType());
        assertEquals(Project.CustomStatusColor.Color7, status.getColor());
        assertEquals(2, status.getProjectId());
        assertEquals("2", status.getProjectIdAsString());
        assertEquals(1001, status.getDisplayOrder());

        status = statuses.get(2);
        assertEquals(102, status.getId());
        assertEquals("リリース待ち / Waiting For Release", status.getName());
        assertEquals(Issue.StatusType.Custom, status.getStatusType());
        assertEquals(Project.CustomStatusColor.Color2, status.getColor());
        assertEquals(2, status.getProjectId());
        assertEquals("2", status.getProjectIdAsString());
        assertEquals(1002, status.getDisplayOrder());
    }
}
