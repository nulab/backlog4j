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
        String expected = "https://test.com/api/v2";
        assertEquals(expected, configure.getRestBaseURL());

        // when
        testUrl = "https://test.com/abcd/";
        configure = new BacklogPackageConfigure(testUrl);

        // then
        expected =  "https://test.com/abcd/api/v2";
        assertEquals(expected, configure.getRestBaseURL());

    }
}
