package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add attachment file to wiki page's API.
 *
 * @author nulab-inc
 */
public class AddWikiAttachmentParams extends PostParams {

    private Object wikiId;

    public AddWikiAttachmentParams(Object wikiId, List attachmentIds){
        this.wikiId = wikiId;
        for (Object attachmentId : attachmentIds) {
            parameters.add(new NameValuePair("attachmentId[]", String.valueOf(attachmentId)));
        }
    }

    public String getWikiId() {
        return this.wikiId.toString();
    }
}
