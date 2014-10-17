package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get repositories API.
 *
 * @author nulab-inc
 */
public class GetRepositoriesParams extends GetParams {


    public GetRepositoriesParams(long projectId) {
        parameters.add(new NameValuePair("projectIdOrKey", String.valueOf(projectId)));
    }

    public GetRepositoriesParams(String projectKey) {
        parameters.add(new NameValuePair("projectIdOrKey", projectKey));
    }
}
