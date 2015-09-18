package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get wiki page API.
 *
 * @author nulab-inc
 */
public class GetWikisParams extends GetParams {

    public GetWikisParams(Object projectIdOrKey) {
        parameters.add(new NameValuePair("projectIdOrKey", projectIdOrKey.toString()));
    }
}
