package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get document page count API.
 *
 * @author nulab-inc
 */
public class GetDocumentsCountParams extends GetParams {

    public GetDocumentsCountParams(Object projectIdOrKey) {
        parameters.add(new NameValuePair("projectIdOrKey", projectIdOrKey.toString()));
    }
}
