package com.nulabinc.backlog4j.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionalTest {
    @Test
    public void withValue() {
        Optional<Long> val = Optional.of((long) 5);

        assertTrue(val.nonEmpty(), "should be non empty");
        assertEquals(Long.valueOf(5), val.get());
    }

    @Test
    public void withoutValue() {
        Optional<Long> val = Optional.empty();

        assertTrue(val.isEmpty(), "should be empty");
    }
}
