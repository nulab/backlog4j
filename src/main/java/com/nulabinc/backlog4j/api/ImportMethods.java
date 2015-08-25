package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.api.option.ImportIssueParams;

/**
 * Executes Backlog Issue APIs.
 *
 * @author nulab-inc
 */
public interface ImportMethods {

    Issue importIssue(ImportIssueParams params) throws BacklogException;

}
