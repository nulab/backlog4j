package com.nulabinc.backlog4j.core;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class UnionTest {

    @Test
    public void useLeft() {
        Union<String, Integer> strOrInt = Union.left("test");

        assertEquals("test", strOrInt.toString());
    }

    @Test
    public void recursiveUnion() {
        Union<String, Union<String, Long>> nestedUnion =
                Union.right(Union.<String, Long>right((long)5));

        assertEquals("5", nestedUnion.toString());
    }

    @Test(expected = InvalidParameterException.class)
    public void leftShouldThrowInvalidParameterException() {
        Union<String, Long> invalid = Union.left(null);
    }

    @Test(expected = InvalidParameterException.class)
    public void rightShouldThrowInvalidParameterException() {
        Union<String, Long> invalid = Union.right(null);
    }
}
