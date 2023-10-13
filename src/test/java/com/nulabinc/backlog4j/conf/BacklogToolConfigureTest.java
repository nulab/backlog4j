package com.nulabinc.backlog4j.conf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class BacklogToolConfigureTest {

    @Test
    public void getOAuthAuthorizationURLTest() {

        // when
        String testSpace = "test";
        BacklogConfigure configure = new BacklogToolConfigure(testSpace);

        // then
        String expected = "https://" + testSpace + ".backlogtool.com/api/v2";
        assertEquals(expected, configure.getRestBaseURL());

    }
}
