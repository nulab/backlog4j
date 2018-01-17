package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.Attachment;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Wiki;
import com.nulabinc.backlog4j.api.option.ImportDeleteAttachmentParams;
import com.nulabinc.backlog4j.api.option.ImportIssueParams;
import com.nulabinc.backlog4j.api.option.ImportUpdateIssueParams;
import com.nulabinc.backlog4j.api.option.ImportWikiParams;

/**
 * Executes Backlog Issue APIs.
 *
 * @author nulab-inc
 */
public interface ImportMethods {

    Issue importIssue(ImportIssueParams params) throws BacklogException;

    Issue importUpdateIssue(ImportUpdateIssueParams params) throws BacklogException;

    Attachment deleteAttachment(Object issueIdOrKey, Object attachmentId, ImportDeleteAttachmentParams params) throws BacklogException;

    Wiki importWiki(ImportWikiParams params);

}
