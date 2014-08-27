package com.nulabinc.backlog4j.internal.json;

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
        assertEquals(Issue.StatusType.Open, status.getStatus());

        status = statuses.get(1);
        assertEquals(2, status.getId());
        assertEquals("処理中", status.getName());
        assertEquals(Issue.StatusType.InProgress, status.getStatus());

        status = statuses.get(2);
        assertEquals(3, status.getId());
        assertEquals("処理済み", status.getName());
        assertEquals(Issue.StatusType.Resolved, status.getStatus());

        status = statuses.get(3);
        assertEquals(4, status.getId());
        assertEquals("完了", status.getName());
        assertEquals(Issue.StatusType.Closed, status.getStatus());

    }
}
