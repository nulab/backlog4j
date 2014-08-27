package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Priority;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class PriorityJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createPriorityListTest() throws IOException {
        String fileContentStr = getJsonString("json/priorities.json");
        ResponseList<Priority> priorities = factory.createPriorityList(fileContentStr);

        assertEquals(3, priorities.size());

        Priority priority = priorities.get(0);
        assertEquals(2, priority.getId());
        assertEquals("高", priority.getName());
        assertEquals(Issue.PriorityType.High, priority.getPriority());

        priority = priorities.get(1);
        assertEquals(3, priority.getId());
        assertEquals("中", priority.getName());
        assertEquals(Issue.PriorityType.Normal, priority.getPriority());

        priority = priorities.get(2);
        assertEquals(4, priority.getId());
        assertEquals("低", priority.getName());
        assertEquals(Issue.PriorityType.Low, priority.getPriority());

    }
}
