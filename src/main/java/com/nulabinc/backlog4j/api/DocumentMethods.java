package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.AttachmentData;
import com.nulabinc.backlog4j.Document;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.api.option.GetDocumentsParams;

/**
 * Executes Backlog Document APIs.
 *
 * @author nulab-inc
 */
public interface DocumentMethods {

    /**
     * Returns Document pages in the project.
     *
     * @param params the finding document parameters
     * @return the document pages in a list
     */
    ResponseList<Document> getDocuments(GetDocumentsParams params);


    /**
     * Returns the Document page.
     *
     * @param documentId the Document page identifier
     * @return the Document page
     */
    Document getDocument(String documentId);

    /**
     * Downloads the Document page's attachment file.
     *
     * @param documentId   the Document page identifier
     * @param attachmentId the attachment file identifier
     * @return downloaded file data
     */
    AttachmentData downloadDocumentAttachment(String documentId, long attachmentId);

}
