package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.Watch;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class WatchingJSONImplTest extends AbstractJSONImplTest{

    @Test
    public void createWatchTest() throws IOException {
        String fileContentStr = getJsonString("json/watch.json");
        Watch watch = factory.createWatch(fileContentStr);

        assertEquals(1000, watch.getId());
        assertEquals(4531, watch.getIssue().getId());
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/watch.json");
        Watch watch1 = factory.createWatch(fileContentStr);
        Watch watch2 = factory.createWatch(fileContentStr);
        assertEquals(watch1, watch2);

    }

    @Test
    public void hashCodeTest() throws IOException {
        String fileContentStr = getJsonString("json/watch.json");
        Watch watch1 = factory.createWatch(fileContentStr);
        Watch watch2 = factory.createWatch(fileContentStr);
        assertEquals(watch1.hashCode(), watch2.hashCode());

    }
    
}
