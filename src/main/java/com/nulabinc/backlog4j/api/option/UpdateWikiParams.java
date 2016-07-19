package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update wiki page API.
 *
 * @author nulab-inc
 */
public class UpdateWikiParams extends PatchParams {

    private Object wikiId;

    public UpdateWikiParams(Object wikiId) {
        this.wikiId = wikiId;
    }

    public String getWikiId() {
        return wikiId.toString();
    }

    public UpdateWikiParams name(String name) {
        parameters.add(new NameValuePair("name", name));
        return this;
    }

    public UpdateWikiParams content(String content) {
        parameters.add(new NameValuePair("content", content));
        return this;
    }

    public UpdateWikiParams mailNotify(boolean mailNotify) {
        parameters.add(new NameValuePair("mailNotify", String.valueOf(mailNotify)));
        return this;
    }
}
