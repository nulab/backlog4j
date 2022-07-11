package com.nulabinc.backlog4j.conf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class BacklogComConfigureTest {

    @Test
    public void getOAuthAuthorizationURLTest() throws Exception {

        // when
        String testSpace = "test";
        BacklogConfigure configure = new BacklogComConfigure(testSpace);

        // then
        String expected = "https://" + testSpace + ".backlog.com/api/v2";
        assertEquals(expected, configure.getRestBaseURL());

    }
}
