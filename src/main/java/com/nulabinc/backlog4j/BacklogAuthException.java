package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.http.BacklogHttpResponse;
import com.nulabinc.backlog4j.internal.json.Jackson;

/**
 * Exception thrown when a auth api response contains error.
 *
 * @author nulab-inc
 */
public class BacklogAuthException extends BacklogException {

    protected BacklogHttpResponse response;
    private int statusCode = -1;
    private BacklogAuthErrorMessage errorMessage;

    public BacklogAuthException(String message, Throwable cause) {
        super(message, cause);
        decode(message);
    }

    public BacklogAuthException(String message, Exception cause, int statusCode) {
        this(message, cause);
        decode(message);
        this.statusCode = statusCode;
    }

    public BacklogAuthException(String message, BacklogHttpResponse response) {
        this(message);
        decode(response.asString());
        this.response = response;
        this.statusCode = response.getStatusCode();
    }

    public BacklogAuthException(String s) {
        super(s);
    }

    public BacklogAuthException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        StringBuilder value = new StringBuilder();
        value.append(super.getMessage());
        if (errorMessage != null) {
            value.append("\n");
            value.append("message - ").append(errorMessage.getError()).append("\n");
            value.append("description - ").append(errorMessage.getDescription()).append("\n");
        }
        return value.toString();
    }

    public BacklogAuthErrorMessage getBacklogAuthErrorMessage() {
        return errorMessage;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    private void decode(String str) {
        if (str != null && str.startsWith("{")) {
            errorMessage = Jackson.fromJsonString(str, BacklogAuthErrorMessage.class);
        }
    }
}
