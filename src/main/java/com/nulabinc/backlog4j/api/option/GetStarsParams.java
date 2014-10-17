package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get stars API.
 *
 * @author nulab-inc
 */
public class GetStarsParams extends GetParams {

    public GetStarsParams since(String since) {
        parameters.add(new NameValuePair("since", since));
        return this;
    }

    public GetStarsParams until(String until) {
        parameters.add(new NameValuePair("until", until));
        return this;
    }
}
