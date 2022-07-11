package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.User;
import org.exparity.hamcrest.date.DateMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author nulab-inc
 */
public class SharedFileJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createSharedFileListTest() throws IOException {
        String fileContentStr = getJsonString("json/shared_files.json");
        ResponseList<SharedFile> sharedFiles = factory.createSharedFileList(fileContentStr);

        assertEquals(2, sharedFiles.size());

        SharedFile sharedFile = sharedFiles.get(0);
        assertEquals(1074321611, sharedFile.getId());
        assertEquals("file", sharedFile.getType());
        assertEquals("/test/", sharedFile.getDir());
        assertEquals("backlog_icon.png", sharedFile.getName());
        assertEquals(5050, sharedFile.getSize());

        User createdUser = sharedFile.getCreatedUser();
        assertEquals(1073751781, createdUser.getId());
        assertEquals("test_admin", createdUser.getUserId());
        assertEquals("あどみにさん", createdUser.getName());
        assertEquals(User.RoleType.Admin, createdUser.getRoleType());
        assertNull(createdUser.getLang());
        assertEquals("test@test.test", createdUser.getMailAddress());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.AUGUST, 4, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(sharedFile.getCreated()));

    }

    @Test
    public void createSharedFileTest() throws IOException {
        String fileContentStr = getJsonString("json/shared_file.json");
        SharedFile sharedFile = factory.createSharedFile(fileContentStr);

        assertEquals(1074321611, sharedFile.getId());
        assertEquals("file", sharedFile.getType());
        assertEquals("/test/", sharedFile.getDir());
        assertEquals("backlog_icon.png", sharedFile.getName());
        assertEquals(5050, sharedFile.getSize());

        User createdUser = sharedFile.getCreatedUser();
        assertEquals(1073751781, createdUser.getId());
        assertEquals("test_admin", createdUser.getUserId());
        assertEquals("あどみにさん", createdUser.getName());
        assertEquals(User.RoleType.Admin, createdUser.getRoleType());
        assertNull(createdUser.getLang());
        assertEquals("test@test.test", createdUser.getMailAddress());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.AUGUST, 4, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(sharedFile.getCreated()));
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/shared_file.json");
        SharedFile sharedFile1 = factory.createSharedFile(fileContentStr);
        SharedFile sharedFile2 = factory.createSharedFile(fileContentStr);
        assertEquals(sharedFile1, sharedFile2);

    }

    @Test
    public void hashCodeTest() throws IOException {
        String fileContentStr = getJsonString("json/shared_file.json");
        SharedFile sharedFile1 = factory.createSharedFile(fileContentStr);
        SharedFile sharedFile2 = factory.createSharedFile(fileContentStr);
        assertEquals(sharedFile1.hashCode(), sharedFile2.hashCode());

    }
}
