package com.nulabinc.backlog4j;

/**
 * The error message class for Backlog exception.
 *
 * @author nulab-inc
 */
public class BacklogAPIErrorMessage {

    private String message;
    private int code;
    private String errorInfo;
    private String moreInfo;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public String getMoreInfo() {
        return moreInfo;
    }
}
