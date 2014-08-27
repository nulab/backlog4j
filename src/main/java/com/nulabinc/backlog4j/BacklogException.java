package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.internal.http.InternalHttpResponse;
import com.nulabinc.backlog4j.internal.json.Jackson;

/**
 * Exception thrown when a api response contains error.
 *
 * @author nulab-inc
 */
public class BacklogException extends RuntimeException {

    protected InternalHttpResponse response;
    private int statusCode = -1;
    private BacklogError backlogError;

    public BacklogException(String message, Throwable cause) {
        super(message, cause);
        decode(message);
    }

    public BacklogException(String message, Exception cause, int statusCode) {
        this(message, cause);
        decode(message);
        this.statusCode = statusCode;
    }

    public BacklogException(String message, InternalHttpResponse response) {
        this(message);
        decode(response.asString());
        this.response = response;
        this.statusCode = response.getStatusCode();
    }

    public BacklogException(String s) {
        super(s);
    }

    public BacklogException(Throwable throwable) {
        super(throwable);
    }

    @Override
    public String getMessage() {
        StringBuilder value = new StringBuilder();
        value.append(super.getMessage());
        if (backlogError != null) {
            for (BacklogErrorMessage errorMessage: backlogError.getErrors()) {

                value.append("\n");
                value.append("message - ").append(errorMessage.getMessage()).append("\n");
                value.append("code - ").append(errorMessage.getCode()).append("\n");
                String info = errorMessage.getErrorInfo();
                if (info != null && info.length() > 0) {
                    value.append("errorInfo - ").append(info).append("\n");
                }
                String moreInfo = errorMessage.getMoreInfo();
                if (moreInfo != null && moreInfo.length() > 0) {
                    value.append("moreInfo - ").append(moreInfo).append("\n");
                }
            }
        }
        return value.toString();
    }

    public BacklogError getBacklogError() {
        return backlogError;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    protected void decode(String str) {
        if (str != null && str.startsWith("{")) {
            backlogError = Jackson.fromJsonString(str, BacklogError.class);
        }
    }
}
