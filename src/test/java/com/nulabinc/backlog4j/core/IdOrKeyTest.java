package com.nulabinc.backlog4j.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class IdOrKeyTest {

    @Test
    public void useKey() {
        IdOrKey keyVal = IdOrKey.key("test");

        assertEquals("test", keyVal.toString());
    }

    @Test
    public void useId() {
        IdOrKey idVal = IdOrKey.id(5);

        assertEquals("5", idVal.toString());
    }
}
