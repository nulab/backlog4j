package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.Version;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.DateMatchers;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author nulab-inc
 */
public class VersionJSONImplTest extends AbstractJSONImplTest{

    @Test
    public void createVersionListTest() throws IOException {
        String fileContentStr = getJsonString("json/versions.json");
        ResponseList<Version> versions = factory.createVersionList(fileContentStr);

        assertEquals(2, versions.size());
        Version version = versions.get(0);
        assertEquals(1073893928, version.getId());
        assertEquals(1073836557, version.getProjectId());
        assertEquals("スプリント1", version.getName());
        assertEquals("スプリント１週目です", version.getDescription());
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.set(2014, 6, 1, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(version.getStartDate()));
        calendar.set(2014, 6, 31, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(version.getReleaseDueDate()));
        assertEquals(false, version.getArchived());

        version = versions.get(1);
        assertEquals(1073893929, version.getId());
        assertEquals(1073836557, version.getProjectId());
        assertEquals("スプリント2", version.getName());
        assertEquals("スプリント2週目です", version.getDescription());
        calendar = Calendar.getInstance(timeZone);
        calendar.set(2014, 7, 1, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(version.getStartDate()));
        calendar.set(2014, 7, 31, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(version.getReleaseDueDate()));
        assertEquals(true, version.getArchived());

    }

    @Test
    public void createVersionTest() throws IOException {
        String fileContentStr = getJsonString("json/version.json");
        Version version = factory.createVersion(fileContentStr);


        assertEquals(1073893928, version.getId());
        assertEquals(1073836557, version.getProjectId());
        assertEquals("スプリント1", version.getName());
        assertEquals("スプリント１週目です", version.getDescription());
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.set(2014, 6, 1, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(version.getStartDate()));
        calendar.set(2014, 6, 31, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(version.getReleaseDueDate()));
        assertEquals(false, version.getArchived());

    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/version.json");
        Version version1 = factory.createVersion(fileContentStr);
        Version version2 = factory.createVersion(fileContentStr);
        assertEquals(version1, version2);

    }

    @Test
    public void hashCodeTest() throws IOException {
        String fileContentStr = getJsonString("json/version.json");
        Version version1 = factory.createVersion(fileContentStr);
        Version version2 = factory.createVersion(fileContentStr);
        assertEquals(version1.hashCode(), version2.hashCode());

    }
}
