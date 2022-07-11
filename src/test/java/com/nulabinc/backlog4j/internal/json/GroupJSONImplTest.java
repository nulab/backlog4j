package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Group;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class GroupJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createPriorityListTest() throws IOException {
        String fileContentStr = getJsonString("json/groups.json");
        ResponseList<Group> groups = factory.createGroupList(fileContentStr);

        assertEquals(2, groups.size());

        Group group = groups.get(0);
        assertEquals(123, group.getId());
        assertEquals("test-group1", group.getName());
        assertEquals(21, group.getDisplayOrder());
        List<User> members = group.getMembers();
        assertEquals(3, members.size());
    }

}
