package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get watch API.
 *
 * @author nulab-inc
 */
public class GetWatchesParams extends GetParams {

    public GetWatchesParams alreadyRead(boolean alreadyRead) {
        parameters.add(new NameValuePair("alreadyRead", String.valueOf(alreadyRead)));
        return this;
    }

}
