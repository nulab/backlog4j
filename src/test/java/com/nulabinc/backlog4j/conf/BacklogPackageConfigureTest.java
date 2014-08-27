package com.nulabinc.backlog4j.conf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class BacklogPackageConfigureTest {

    @Test
    public void getOAuthAuthorizationURLTest() throws Exception {

        // when
        String testUrl = "https://test.com";
       BacklogConfigure configure = new BacklogPackageConfigure(testUrl);

        // then
        String expected = testUrl + "/api/v2";
        assertEquals(expected , configure.getRestBaseURL());

    }
}
