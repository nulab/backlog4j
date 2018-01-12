package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Parameters for delete request.
 *
 * @author nulab-inc
 */
public abstract class DeleteParams {

    protected List<NameValuePair> parameters = new ArrayList<NameValuePair>();

    public List<NameValuePair> getParamList() {
        return parameters;
    }

}
