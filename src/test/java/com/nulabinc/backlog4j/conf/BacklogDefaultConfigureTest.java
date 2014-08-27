package com.nulabinc.backlog4j.conf;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class BacklogDefaultConfigureTest {

    @Test
    public void getOAuthAuthorizationURLTest() throws Exception {

        // when
        String testSpace = "test";
       BacklogConfigure configure = new BacklogDefaultConfigure(testSpace);

        // then
        String expected = "https://" + testSpace + ".backlog.jp/api/v2";
        assertEquals(expected , configure.getRestBaseURL());

    }
}
