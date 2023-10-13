package com.nulabinc.backlog4j.conf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class BacklogJpConfigureTest {

    @Test
    public void getOAuthAuthorizationURLTest() {

        // when
        String testSpace = "test";
        BacklogConfigure configure = new BacklogJpConfigure(testSpace);

        // then
        String expected = "https://" + testSpace + ".backlog.jp/api/v2";
        assertEquals(expected, configure.getRestBaseURL());

    }
}
