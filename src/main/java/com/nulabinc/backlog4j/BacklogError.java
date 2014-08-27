package com.nulabinc.backlog4j;

import java.util.Arrays;
import java.util.List;

/**
 * The error class for Backlog exception.
 * Contains the error massages.
 *
 * @author nulab-inc
 */
public class BacklogError {

    private BacklogErrorMessage[] errors;

    public List<BacklogErrorMessage> getErrors() {
        return Arrays.asList(errors);
    }

}
