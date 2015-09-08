package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * @author nulab-inc
 */
public class ImportWikiParams extends CreateWikiParams {

    /**
     * Constructor
     *
     * @param projectId   the project identifier
     * @param name     the wiki name
     * @param content the wiki content
     */
    public ImportWikiParams(long projectId, String name, String content) {
        super(projectId, name, content);
    }

    public ImportWikiParams createdUserId(long createdUserId) {
        parameters.add(new NameValuePair("createdUserId", String.valueOf(createdUserId)));
        return this;
    }

    public ImportWikiParams created(String created) {
        parameters.add(new NameValuePair("created", created));
        return this;
    }

    public ImportWikiParams updatedUserId(long updatedUserId) {
        parameters.add(new NameValuePair("updatedUserId", String.valueOf(updatedUserId)));
        return this;
    }

    public ImportWikiParams updated(String updated) {
        parameters.add(new NameValuePair("updated", updated));
        return this;
    }

}
