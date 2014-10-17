package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * @author nulab-inc
 */
public abstract class AbstractParamsTest {

    protected boolean existsOneKeyValue(List<NameValuePair> parameters,
                                   String key, String value){
        int count = 0;
        for(NameValuePair pair :parameters){
            if(pair.getName().equals(key)
                && pair.getValue().equals(value))
                count ++ ;
        }
        if(count != 1) return false;
        return true;
    }
}
