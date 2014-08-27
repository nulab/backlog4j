package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for get stars API.
 *
 * @author nulab-inc
 */
public class GetStarsParams extends GetParams {

    public GetStarsParams since(String since) {
        parameters.add(new BasicNameValuePair("since", since));
        return this;
    }

    public GetStarsParams until(String until) {
        parameters.add(new BasicNameValuePair("until", until));
        return this;
    }
}
