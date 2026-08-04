package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get document tree API.
 *
 * @author nulab-inc
 */
public class GetDocumentTreeParams extends GetParams {

    public GetDocumentTreeParams(Object projectIdOrKey) {
        parameters.add(new NameValuePair("projectIdOrKey", projectIdOrKey.toString()));
    }
}
