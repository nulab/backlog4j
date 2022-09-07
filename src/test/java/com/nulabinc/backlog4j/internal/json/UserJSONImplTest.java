package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.User;
import org.exparity.hamcrest.date.DateMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author nulab-inc
 */
public class UserJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createUserListTest() throws IOException {
        String fileContentStr = getJsonString("json/users.json");
        ResponseList<User> users = factory.createUserList(fileContentStr);

        assertEquals(2, users.size());

        User user = users.get(0);
        assertEquals(1073910170, user.getId());
        assertEquals("test1", user.getName());
        assertEquals(User.RoleType.Admin, user.getRoleType());
        assertNull(user.getLang());
        assertEquals("test1@xxxxxxxx.xx", user.getMailAddress());

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(2022, Calendar.SEPTEMBER, 7, 11, 33, 45);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), user.getLastLoginTime());

        user = users.get(1);
        assertEquals(1073910171, user.getId());
        assertEquals("test2", user.getName());
        assertEquals(User.RoleType.User, user.getRoleType());
        assertEquals("ja", user.getLang());
        assertEquals("test2@xxxxxxxx.xx", user.getMailAddress());
        assertNull(user.getLastLoginTime());
    }

    @Test
    public void createUserTest() throws IOException {
        String fileContentStr = getJsonString("json/user.json");
        User user = factory.createUser(fileContentStr);

        assertEquals(1073936936, user.getId());
        assertEquals("test", user.getName());
        assertEquals(User.RoleType.Admin, user.getRoleType());
        assertNull(user.getLang());
        assertEquals("test@xxxxxxxx.xx", user.getMailAddress());
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/user.json");
        User user1 = factory.createUser(fileContentStr);
        User user2 = factory.createUser(fileContentStr);
        assertEquals(user1, user2);

    }

    @Test
    public void hashCodeTest() throws IOException {
        String fileContentStr = getJsonString("json/user.json");
        User user1 = factory.createUser(fileContentStr);
        User user2 = factory.createUser(fileContentStr);
        assertEquals(user1.hashCode(), user2.hashCode());

    }
}
