package com.nulabinc.backlog4j.core;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionalTest {
    @Test
    public void withValue() {
        Optional<Long> val = Optional.of((long)5);

        assertTrue("should be non empty", val.nonEmpty());
        assertEquals(Long.valueOf(5), val.get());
    }

    @Test
    public void withoutValue() {
        Optional<Long> val = Optional.empty();

        assertTrue("should be empty", val.isEmpty());
    }
}
