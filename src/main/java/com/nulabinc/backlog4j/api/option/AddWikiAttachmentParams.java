package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for add attachment file to wiki page's API.
 *
 * @author nulab-inc
 */
public class AddWikiAttachmentParams extends PostParams {

    private long wikiId;
    private String issueKey;

    public AddWikiAttachmentParams(long wikiId, List<Long> attachmentIds){
        this.wikiId = wikiId;
        for (Long attachmentId : attachmentIds) {
            parameters.add(new BasicNameValuePair("attachmentId[]", String.valueOf(attachmentId)));
        }
    }

    public long getWikiId() {
        return this.wikiId;
    }
}
