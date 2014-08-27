package com.nulabinc.backlog4j.api.option;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Parameters for post request.
 *
 * @author nulab-inc
 */
public abstract class PostParams {
    protected List<NameValuePair> parameters = new ArrayList<NameValuePair>();

    public List<NameValuePair> getParamList() {
        return parameters;
    }
}
