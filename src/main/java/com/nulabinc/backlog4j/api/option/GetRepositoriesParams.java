package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for get repositories API.
 *
 * @author nulab-inc
 */
public class GetRepositoriesParams extends GetParams {


    public GetRepositoriesParams(long projectId) {
        parameters.add(new BasicNameValuePair("projectIdOrKey", String.valueOf(projectId)));
    }

    public GetRepositoriesParams(String projectKey) {
        parameters.add(new BasicNameValuePair("projectIdOrKey", projectKey));
    }
}
