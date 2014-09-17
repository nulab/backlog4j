package com.nulabinc.backlog4j;

/**
 * Exception thrown when a api response contains error.
 *
 * @author nulab-inc
 */
public abstract class BacklogException extends RuntimeException {

    public BacklogException(String message, Throwable cause) {
        super(message, cause);
    }

    public BacklogException(String message) {
        super(message);
    }

    public BacklogException(Throwable cause) {
        super(cause);
    }
}
