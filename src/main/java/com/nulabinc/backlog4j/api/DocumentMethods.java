package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.AttachmentData;
import com.nulabinc.backlog4j.Document;
import com.nulabinc.backlog4j.DocumentAttachment;
import com.nulabinc.backlog4j.DocumentComment;
import com.nulabinc.backlog4j.DocumentTag;
import com.nulabinc.backlog4j.DocumentTree;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.api.option.AddDocumentParams;
import com.nulabinc.backlog4j.api.option.AddDocumentTagsParams;
import com.nulabinc.backlog4j.api.option.GetDocumentTreeParams;
import com.nulabinc.backlog4j.api.option.GetDocumentsCountParams;
import com.nulabinc.backlog4j.api.option.GetDocumentsParams;
import com.nulabinc.backlog4j.api.option.RemoveDocumentTagsParams;

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
     * Adds a Document page to the project.
     *
     * @param params the add document parameters
     * @return the added Document page
     */
    Document addDocument(AddDocumentParams params);

    /**
     * Returns the number of Document pages in the project.
     *
     * @param params the count document parameters
     * @return the document pages count
     */
    int getDocumentsCount(GetDocumentsCountParams params);

    /**
     * Returns the Document tree in the project.
     *
     * @param params the document tree parameters
     * @return the document tree
     */
    DocumentTree getDocumentTree(GetDocumentTreeParams params);

    /**
     * Returns the Document page.
     *
     * @param documentId the Document page identifier
     * @return the Document page
     */
    Document getDocument(String documentId);

    /**
     * Deletes the Document page.
     *
     * @param documentId the Document page identifier
     * @return the deleted Document page
     */
    Document deleteDocument(String documentId);

    /**
     * Downloads the Document page's attachment file.
     *
     * @param documentId   the Document page identifier
     * @param attachmentId the attachment file identifier
     * @return downloaded file data
     */
    AttachmentData downloadDocumentAttachment(String documentId, long attachmentId);

    /**
     * Returns the comments of the Document page.
     *
     * @param documentId the Document page identifier
     * @return the document page's comments in a list
     */
    ResponseList<DocumentComment> getDocumentComments(String documentId);

    /**
     * Adds an attachment file to the Document page.
     *
     * @param documentId     the Document page identifier
     * @param attachmentData the file to upload
     * @return the added Document page's attachment
     */
    DocumentAttachment addDocumentAttachment(String documentId, AttachmentData attachmentData);

    /**
     * Adds tags to the Document page.
     *
     * @param documentId the Document page identifier
     * @param params     the add document tags parameters
     * @return the document page's tags in a list
     */
    ResponseList<DocumentTag> addDocumentTags(String documentId, AddDocumentTagsParams params);

    /**
     * Removes tags from the Document page.
     *
     * @param documentId the Document page identifier
     * @param params     the remove document tags parameters
     */
    void removeDocumentTags(String documentId, RemoveDocumentTagsParams params);

}
