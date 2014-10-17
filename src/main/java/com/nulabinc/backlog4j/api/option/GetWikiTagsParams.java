package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get wiki page's tag API.
 *
 * @author nulab-inc
 */
public class GetWikiTagsParams extends GetParams {


    public GetWikiTagsParams(long projectId) {
        parameters.add(new NameValuePair("projectIdOrKey", String.valueOf(projectId)));
    }

    public GetWikiTagsParams(String projectKey) {
        parameters.add(new NameValuePair("projectIdOrKey", projectKey));
    }
}
