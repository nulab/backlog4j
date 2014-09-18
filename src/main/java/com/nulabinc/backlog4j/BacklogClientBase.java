package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.api.option.GetParams;
import com.nulabinc.backlog4j.api.option.PatchParams;
import com.nulabinc.backlog4j.api.option.PostParams;
import com.nulabinc.backlog4j.api.option.QueryParams;
import com.nulabinc.backlog4j.auth.AccessToken;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.internal.InternalFactory;
import com.nulabinc.backlog4j.http.ApacheBacklogHttpClient;
import com.nulabinc.backlog4j.http.BacklogHttpClient;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;
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

    protected BacklogHttpClient httpClient;
    protected BacklogConfigure configure;
    protected InternalFactory factory = new InternalFactoryJSONImpl();

    public BacklogClientBase(BacklogConfigure configure) {
        this.configure = configure;
        this.httpClient = new ApacheBacklogHttpClient();
        configureHttpClient();

    }

    public BacklogClientBase(BacklogConfigure configure, BacklogHttpClient httpClient) {
        this.configure = configure;
        this.httpClient = httpClient;
        configureHttpClient();
    }

    private void configureHttpClient() {

        if (this.configure.getApiKey() != null) {
            httpClient.setApiKey(this.configure.getApiKey());
        } else if (this.configure.getAccessToken() != null) {
            httpClient.setBearerToken(this.configure.getAccessToken().getToken());
        } else {
            throw new BacklogAPIException("ApiKey or AccessToken must not be null");
        }

        httpClient.setReadTimeout(this.configure.getReadTimeout());
        httpClient.setConnectionTimeout(this.configure.getConnectionTimeout());
    }

    protected BacklogHttpResponse get(String endpoint) throws BacklogException {
        return this.get(endpoint, null, null);
    }

    protected BacklogHttpResponse get(String endpoint, GetParams getParams) throws BacklogException {
        return this.get(endpoint, getParams, null);
    }

    protected BacklogHttpResponse get(String endpoint, QueryParams queryParams) throws BacklogException {
        return this.get(endpoint, null, queryParams);
    }

    protected BacklogHttpResponse get(String endpoint, GetParams getParams, QueryParams queryParams) throws BacklogException {
        BacklogHttpResponse ires = httpClient.get(endpoint, getParams, queryParams);
        if(needTokenRefresh(ires)){
            refreshToken();
            ires = httpClient.get(endpoint, getParams, queryParams);
        }
        checkError(ires);
        return ires;
    }


    protected BacklogHttpResponse post(String endpoint) throws BacklogException {
        return this.post(endpoint, new ArrayList<NameValuePair>());
    }

    protected BacklogHttpResponse post(String endpoint, PostParams postParams) throws BacklogException {
        return this.post(endpoint, postParams.getParamList());
    }

    protected BacklogHttpResponse post(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        BacklogHttpResponse ires = httpClient.post(endpoint, parameters);
        if(needTokenRefresh(ires)){
            refreshToken();
            ires = httpClient.post(endpoint, parameters);
        }
        checkError(ires);
        return ires;
    }

    protected BacklogHttpResponse patch(String endpoint, PatchParams postParams) throws BacklogException {
        return this.patch(endpoint, postParams.getParamList());
    }

    protected BacklogHttpResponse patch(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        BacklogHttpResponse ires = httpClient.patch(endpoint, parameters);
        if(needTokenRefresh(ires)){
            refreshToken();
            ires = httpClient.patch(endpoint, parameters);
        }
        checkError(ires);
        return ires;
    }

    protected BacklogHttpResponse put(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        BacklogHttpResponse ires = httpClient.put(endpoint, parameters);
        if(needTokenRefresh(ires)){
            refreshToken();
            ires = httpClient.put(endpoint, parameters);
        }
        checkError(ires);
        return ires;
    }

    protected BacklogHttpResponse delete(String endpoint) throws BacklogException {
        return this.delete(endpoint, null);

    }

    protected BacklogHttpResponse delete(String endpoint, NameValuePair param) throws BacklogException {
        BacklogHttpResponse ires = httpClient.delete(endpoint, param);
        if(needTokenRefresh(ires)){
            refreshToken();
            ires = httpClient.delete(endpoint, param);
        }
        checkError(ires);
        return ires;
    }

    protected BacklogHttpResponse postMultiPart(String endpoint, Map<String, Object> parameters) throws BacklogException {
        BacklogHttpResponse ires = httpClient.postMultiPart(endpoint, parameters);
        if(needTokenRefresh(ires)){
            refreshToken();
            ires = httpClient.postMultiPart(endpoint, parameters);
        }
        checkError(ires);
        return ires;
    }

    protected String buildEndpoint(String connection) {
        StringBuilder url = new StringBuilder()
                .append(configure.getRestBaseURL())
                .append(connection == null ? "" : "/" + connection);
        return url.toString();
    }


    private void checkError(BacklogHttpResponse ires) {
        if (ires.getStatusCode() != 200 &&
                ires.getStatusCode() != 201 &&
                ires.getStatusCode() != 202 &&
                ires.getStatusCode() != 203 &&
                ires.getStatusCode() != 204) {
            throw new BacklogAPIException("backlog api request failed.", ires);
        }
    }

    private boolean needTokenRefresh(BacklogHttpResponse ires) {
        return ires.getStatusCode() == 401 &&
                configure.getApiKey() == null &&
                configure.getAccessToken() != null;
    }

    private void refreshToken() {
        AccessToken accessToken = configure.getOAuthSupport().refreshOAuthAccessToken();
        configure.accessToken(accessToken);
        configure.getOnAccessTokenRefreshListener().onAccessTokenRefresh(accessToken);
        configureHttpClient();
    }

}
