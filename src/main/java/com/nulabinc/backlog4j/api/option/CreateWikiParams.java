package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for create wiki API.
 *
 * @author nulab-inc
 */
public class CreateWikiParams extends PostParams {

    public CreateWikiParams(long projectId, String name, String content) {
        parameters.add(new BasicNameValuePair("projectId", String.valueOf(projectId)));
        parameters.add(new BasicNameValuePair("name", name));
        parameters.add(new BasicNameValuePair("content", content));
    }

    public CreateWikiParams mailNotify(boolean mailNotify) {
        parameters.add(new BasicNameValuePair("mailNotify", String.valueOf(mailNotify)));
        return this;
    }
}
