package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.api.option.GetParams;
import com.nulabinc.backlog4j.api.option.PatchParams;
import com.nulabinc.backlog4j.api.option.PostParams;
import com.nulabinc.backlog4j.api.option.QueryParams;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.internal.InternalFactory;
import com.nulabinc.backlog4j.internal.http.DefaultInternalHttpClient;
import com.nulabinc.backlog4j.internal.http.InternalHttpClient;
import com.nulabinc.backlog4j.internal.http.InternalHttpResponse;
import com.nulabinc.backlog4j.internal.json.InternalFactoryJSONImpl;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Base of BacklogClient.
 *
 * @author nulab-inc
 */
public abstract class BacklogClientBase {

    protected InternalHttpClient httpClient;
    protected BacklogConfigure configure;
    protected InternalFactory factory;

    public BacklogClientBase(BacklogConfigure configure) {
        this.configure = configure;
        this.httpClient = new DefaultInternalHttpClient();
        init();
    }

    public BacklogClientBase(BacklogConfigure configure, InternalHttpClient httpClient) {
        this.configure = configure;
        this.httpClient = httpClient;
        init();
    }

    private void init() {
        factory = new InternalFactoryJSONImpl();

        if (this.configure.getApiKey() != null) {
            httpClient.setApiKey(this.configure.getApiKey());
        } else if (this.configure.getAccessToken() != null) {
            httpClient.setBearerToken(this.configure.getAccessToken().getToken());
        } else {
            throw new BacklogException("ApiKey or AccessToken must not be null");
        }

        httpClient.setReadTimeout(this.configure.getReadTimeout());
        httpClient.setConnectionTimeout(this.configure.getConnectionTimeout());
    }

    protected InternalHttpResponse get(String endpoint) throws BacklogException {
        return this.get(endpoint, null, null);
    }

    protected InternalHttpResponse get(String endpoint, GetParams getParams) throws BacklogException {
        return this.get(endpoint, getParams, null);
    }

    protected InternalHttpResponse get(String endpoint, QueryParams queryParams) throws BacklogException {
        return this.get(endpoint, null, queryParams);
    }

    protected InternalHttpResponse get(String endpoint, GetParams getParams, QueryParams queryParams) throws BacklogException {
        InternalHttpResponse ires = httpClient.get(endpoint, getParams, queryParams, false);
        checkError(ires);
        return ires;
    }

    protected InternalHttpResponse getAsStream(String endpoint) throws BacklogException {
        InternalHttpResponse ires = httpClient.get(endpoint, null, null, true);
        checkError(ires);
        return ires;
    }

    protected InternalHttpResponse post(String endpoint) throws BacklogException {
        return this.post(endpoint, new ArrayList<NameValuePair>());
    }

    protected InternalHttpResponse post(String endpoint, PostParams postParams) throws BacklogException {
        return this.post(endpoint, postParams.getParamList());
    }

    protected InternalHttpResponse post(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        InternalHttpResponse ires = httpClient.post(endpoint, parameters);
        checkError(ires);
        return ires;
    }

    protected InternalHttpResponse patch(String endpoint, PatchParams postParams) throws BacklogException {
        return this.patch(endpoint, postParams.getParamList());
    }

    protected InternalHttpResponse patch(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        InternalHttpResponse ires = httpClient.patch(endpoint, parameters);
        checkError(ires);
        return ires;
    }

    protected InternalHttpResponse put(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        InternalHttpResponse ires = httpClient.put(endpoint, parameters);
        checkError(ires);
        return ires;
    }

    protected InternalHttpResponse delete(String endpoint) throws BacklogException {
        return this.delete(endpoint, null);

    }

    protected InternalHttpResponse delete(String endpoint, NameValuePair param) throws BacklogException {
        InternalHttpResponse ires = httpClient.delete(endpoint, param);
        checkError(ires);
        return ires;
    }

    protected InternalHttpResponse postMultiPart(String endpoint, Map<String, Object> parameters) throws BacklogException {
        InternalHttpResponse ires = httpClient.postMultiPart(endpoint, parameters);
        checkError(ires);
        return ires;
    }

    protected String buildEndpoint(String connection) {
        StringBuilder url = new StringBuilder()
                .append(configure.getRestBaseURL())
                .append(connection == null ? "" : "/" + connection);
        return url.toString();
    }


    private void checkError(InternalHttpResponse ires) {
        if (ires.getStatusCode() != 200 &&
                ires.getStatusCode() != 201 &&
                ires.getStatusCode() != 202 &&
                ires.getStatusCode() != 203 &&
                ires.getStatusCode() != 204) {
            throw new BacklogException("backlog api request failed.", ires);
        }
    }
}
