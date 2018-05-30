package com.nulabinc.backlog4j.http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BacklogClientImplTest {

    @Test
    public void userAgentTest() {
        BacklogHttpClient client = new BacklogHttpClientImpl();

        // default
        assertEquals(client.getUserAgent(), "backlog4jv2");

        // set the new value
        client.setUserAgent("test-agent");
        assertEquals(client.getUserAgent(), "test-agent");
    }
}
