package com.nulabinc.backlog4j.conf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class BacklogToolConfigureTest {

    @Test
    public void getOAuthAuthorizationURLTest() throws Exception {

        // when
        String testSpace = "test";
       BacklogConfigure configure = new BacklogToolConfigure(testSpace);

        // then
        String expected = "https://" + testSpace + ".backlogtool.com/api/v2";
        assertEquals(expected , configure.getRestBaseURL());

    }
}
