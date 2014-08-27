package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for update wiki page API.
 *
 * @author nulab-inc
 */
public class UpdateWikiParams extends PatchParams {

    private long wikiId;

    public UpdateWikiParams(long wikiId) {
        this.wikiId = wikiId;
    }

    public long getWikiId() {
        return wikiId;
    }

    public UpdateWikiParams name(String name) {
        parameters.add(new BasicNameValuePair("name", name));
        return this;
    }

    public UpdateWikiParams content(String content) {
        parameters.add(new BasicNameValuePair("content", content));
        return this;
    }

    public UpdateWikiParams mailNotify(String mailNotify) {
        parameters.add(new BasicNameValuePair("mailNotify", mailNotify));
        return this;
    }
}
