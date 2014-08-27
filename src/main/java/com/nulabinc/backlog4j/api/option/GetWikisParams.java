package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for get wiki page API.
 *
 * @author nulab-inc
 */
public class GetWikisParams extends GetParams {


    public GetWikisParams(long projectId) {
        parameters.add(new BasicNameValuePair("projectIdOrKey", String.valueOf(projectId)));
    }

    public GetWikisParams(String projectKey) {
        parameters.add(new BasicNameValuePair("projectIdOrKey", projectKey));
    }
}
