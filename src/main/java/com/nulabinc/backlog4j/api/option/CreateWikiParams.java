package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for create wiki API.
 *
 * @author nulab-inc
 */
public class CreateWikiParams extends PostParams {

    public CreateWikiParams(long projectId, String name, String content) {
        parameters.add(new NameValuePair("projectId", String.valueOf(projectId)));
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("content", content));
    }

    public CreateWikiParams mailNotify(boolean mailNotify) {
        parameters.add(new NameValuePair("mailNotify", String.valueOf(mailNotify)));
        return this;
    }
}
