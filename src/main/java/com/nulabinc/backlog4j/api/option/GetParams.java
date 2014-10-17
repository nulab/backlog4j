package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Parameters for get request.
 *
 * @author nulab-inc
 */
public abstract class GetParams {
    protected List<NameValuePair> parameters = new ArrayList<NameValuePair>();

    public String getParamString(boolean paramExists) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(NameValuePair parameter : parameters){
            if(count == 0 && !paramExists){
                sb.append("?");
            }else {
                sb.append("&");
            }
            sb.append(parameter.getName());
            sb.append("=");
            sb.append(parameter.getValue());
            count++;
        }
        return sb.toString();
    }

    public List<NameValuePair> getParamList() {
        return parameters;
    }
}
