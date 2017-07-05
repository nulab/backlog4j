package com.nulabinc.backlog4j.core;

import java.util.NoSuchElementException;

/**
 * @author nulab-inc
 * Optional exist in Java8 but for compatibility with Android
 * we implement a light version of Optional
 */
public class Optional<T> {
    private T value;

    private Optional(T value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public boolean nonEmpty() {
        return this.value != null;
    }

    public T get() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        } else {
            return this.value;
        }
    }

    public static  <T> Optional<T> ofNullable(T value) {
        if (value == null) {
            return empty();
        } else {
            return of(value);
        }
    }

    public static <T> Optional<T> empty() {
        return Optional.of(null);
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<T>(value);
    }
}
