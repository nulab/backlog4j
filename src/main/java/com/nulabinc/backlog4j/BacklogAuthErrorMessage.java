package com.nulabinc.backlog4j;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The error message class for Backlog auth exception.
 *
 * @author nulab-inc
 */
public class BacklogAuthErrorMessage {

    private String error;
    @JsonProperty("error_description")
    private String description;

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }
}
