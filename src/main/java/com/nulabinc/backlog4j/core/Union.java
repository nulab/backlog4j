package com.nulabinc.backlog4j.core;

import java.security.InvalidParameterException;
import java.util.Optional;

/**
 * @author nulab-inc
 */
public class Union<T1, T2> {
    private T1 t1;
    private T2 t2;

    private Union(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public String toString() {
        if (this.t1 != null) {
            return this.t1.toString();
        } else {
            return this.t2.toString();
        }
    }

    public Optional<T1> left() {
        return Optional.ofNullable(this.t1);
    }

    public Optional<T2> right() {
        return Optional.ofNullable(this.t2);
    }

    public static <T, U> Union<T, U> left(T t1) throws InvalidParameterException {
        if (t1 == null) {
            throw new InvalidParameterException("value can't be null");
        }
        return new Union<T, U>(t1, null);
    }

    public static <T, U> Union<T, U> right(U t2) throws InvalidParameterException {
        if (t2 == null) {
            throw new InvalidParameterException("value can't be null");
        }
        return new Union<T, U>(null, t2);
    }
}
