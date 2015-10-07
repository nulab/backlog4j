package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.AddWikiAttachmentParams;
import com.nulabinc.backlog4j.api.option.CreateWikiParams;
import com.nulabinc.backlog4j.api.option.QueryParams;
import com.nulabinc.backlog4j.api.option.UpdateWikiParams;

import java.util.List;

/**
 * Executes Backlog Wiki APIs.
 *
 * @author nulab-inc
 */
public interface WikiMethods {

    /**
     * Returns Wiki pages in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the Wiki pages in a list
     */
    ResponseList<Wiki> getWikis(Object projectIdOrKey);

    /**
     * Returns Wiki pages count.
     *
     * @param projectIdOrKey the project identifier
     * @return the Wiki pages count
     */
    int getWikiCount(Object projectIdOrKey);

    /**
     * Returns Wiki page's tags in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the Wiki page's tags in a list
     */
    ResponseList<WikiTag> getWikiTags(Object projectIdOrKey);

    /**
     * Create a Wiki page in the project.
     *
     * @param params the creating Wiki page parameters
     * @return the created Wiki page
     */
    Wiki createWiki(CreateWikiParams params);

    /**
     * Returns the Wiki page.
     *
     * @param wikiId the Wiki page identifier
     * @return the Wiki page
     */
    Wiki getWiki(Object wikiId);

    /**
     * Updates an existing Wiki page in the project.
     *
     * @param params the updating Wiki page parameters
     * @return the updated Wiki page
     */
    Wiki updateWiki(UpdateWikiParams params);

    /**
     * Deletes the Wiki page.
     *
     * @param wikiId     the Wiki page identifier
     * @param mailNotify
     * @return the deleted Wiki page
     */
    Wiki deleteWiki(Object wikiId, boolean mailNotify);

    // Wiki添付ファイル一覧の取得

    /**
     * Returns the Wiki page's attachment files.
     *
     * @param wikiId the Wiki page identifier
     * @return the Wiki page's attachment files in a list
     */
    ResponseList<Attachment> getWikiAttachments(Object wikiId);

    /**
     * Attaches the files to the Wiki page.
     *
     * @param params the Wiki page's attachment parameters
     * @return the added Wiki page's attachment file
     */
    ResponseList<Attachment> addWikiAttachment(AddWikiAttachmentParams params);

    /**
     * Downloads the Wiki page's attachment file.
     *
     * @param wikiId       the Wiki page identifier
     * @param attachmentId the attachment file identifier
     * @return downloaded file data
     */
    AttachmentData downloadWikiAttachment(Object wikiId, Object attachmentId);

    /**
     * Returns the endpoint of Wiki page's attachment file.
     *
     * @param wikiId       the Wiki page identifier
     * @param attachmentId the attachment identifier
     * @return the endpoint
     * @throws BacklogException
     */
    String getWikiAttachmentEndpoint(Object wikiId, Object attachmentId) throws BacklogException;

    /**
     * Deletes the Wiki page's attachment file
     *
     * @param wikiId       the Wiki page identifier
     * @param attachmentId the attachment file identifier
     * @return deleted Wiki page's attachment file
     */
    Attachment deleteWikiAttachment(Object wikiId, Object attachmentId);

    /**
     * Returns the Wiki page's shared files.
     *
     * @param wikiId the Wiki page identifier
     * @return the Wiki page's shared files in a list
     */
    ResponseList<SharedFile> getWikiSharedFiles(Object wikiId);

    /**
     * Links the shared files to Wiki.
     *
     * @param wikiId  the Wiki page identifier
     * @param fileIds the shared file identifiers
     * @return the linked shared files
     */
    ResponseList<SharedFile> linkWikiSharedFile(Object wikiId, List fileIds);

    /**
     * Removes link to shared Files from the Wiki.
     *
     * @param wikiId the Wiki page identifier
     * @param fileId the shared file identifier
     * @return the removed link shared file
     */
    SharedFile unlinkWikiSharedFile(Object wikiId, Object fileId);

    /**
     * Returns history of the Wiki page.
     *
     * @param wikiId the Wiki page identifier
     * @return the wiki histories in a list
     */
    ResponseList<WikiHistory> getWikiHistories(Object wikiId);

    /**
     * Returns history of the Wiki page.
     *
     * @param wikiId      the Wiki page identifier
     * @param queryParams the query parameters
     * @return the wiki histories in a list
     */
    ResponseList<WikiHistory> getWikiHistories(Object wikiId, QueryParams queryParams);

    /**
     * Returns list of stars received on the Wiki page.
     *
     * @param wikiId the Wiki page identifier
     * @return the wiki stars in a list
     */
    ResponseList<Star> getWikiStars(Object wikiId);

}
