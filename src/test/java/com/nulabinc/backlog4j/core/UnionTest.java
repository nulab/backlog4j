package com.nulabinc.backlog4j.core;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
                Union.right(Union.right((long) 5));

        assertEquals("5", nestedUnion.toString());
    }

    @Test
    public void leftShouldThrowInvalidParameterException() {
        assertThrows(InvalidParameterException.class, () -> Union.left(null));
    }

    @Test
    public void rightShouldThrowInvalidParameterException() {
        assertThrows(InvalidParameterException.class, () -> Union.right(null));
    }
}
