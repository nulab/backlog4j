package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Parameters for patch request.
 *
 * @author nulab-inc
 */
public abstract class PatchParams {

    protected List<NameValuePair> parameters = new ArrayList<>();

    public List<NameValuePair> getParamList() {
        return parameters;
    }

}
