package com.nulabinc.backlog4j;

import java.util.Arrays;
import java.util.List;

/**
 * The error class for Backlog exception.
 * Contains the error messages.
 *
 * @author nulab-inc
 */
public class BacklogAPIError {

    private BacklogAPIErrorMessage[] errors;

    public List<BacklogAPIErrorMessage> getErrors() {
        return Arrays.asList(errors);
    }

}
