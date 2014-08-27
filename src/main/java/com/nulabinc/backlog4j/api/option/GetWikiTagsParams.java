package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for get wiki page's tag API.
 *
 * @author nulab-inc
 */
public class GetWikiTagsParams extends GetParams {


    public GetWikiTagsParams(long projectId) {
        parameters.add(new BasicNameValuePair("projectIdOrKey", String.valueOf(projectId)));
    }

    public GetWikiTagsParams(String projectKey) {
        parameters.add(new BasicNameValuePair("projectIdOrKey", projectKey));
    }
}
