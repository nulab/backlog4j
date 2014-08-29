package com.nulabinc.backlog4j.internal.http;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.api.option.QueryParams;
import com.nulabinc.backlog4j.api.option.GetParams;
import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;

/**
 * @author nulab-inc
 */
public interface InternalHttpClient {
    void setApiKey(String apiKey);
    void setBearerToken(String bearerToken);
    void setReadTimeout(int readTimeout);
    void setConnectionTimeout(int connectionTimeout);
    InternalHttpResponse get(String endpoint, GetParams getParams, QueryParams queryParams) throws BacklogException;
    InternalHttpResponse post(String endpoint, List<NameValuePair> postParams) throws BacklogException;
    InternalHttpResponse patch(String endpoint, List<NameValuePair> patchParams) throws BacklogException;
    InternalHttpResponse put(String endpoint, List<NameValuePair> patchParams) throws BacklogException;
    InternalHttpResponse delete(String endpoint, NameValuePair param) throws BacklogException;
    InternalHttpResponse postMultiPart(String endpoint, Map<String, Object> postParams) throws BacklogException;
}
