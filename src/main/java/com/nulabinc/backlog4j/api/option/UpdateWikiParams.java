package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

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
        parameters.add(new NameValuePair("name", name));
        return this;
    }

    public UpdateWikiParams content(String content) {
        parameters.add(new NameValuePair("content", content));
        return this;
    }

    public UpdateWikiParams mailNotify(String mailNotify) {
        parameters.add(new NameValuePair("mailNotify", mailNotify));
        return this;
    }
}
