package com.nulabinc.backlog4j.auth;


import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.BacklogAuthException;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.http.BacklogHttpClient;
import com.nulabinc.backlog4j.http.BacklogHttpClientImpl;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;
import com.nulabinc.backlog4j.http.NameValuePair;
import com.nulabinc.backlog4j.internal.InternalFactory;
import com.nulabinc.backlog4j.internal.json.InternalFactoryJSONImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nulab-inc
 */
public class BacklogOAuthSupport implements OAuthSupport {

    private String clientId;
    private String clientSecret;
    private String redirectUrl;

    private BacklogConfigure configure;
    private BacklogHttpClient httpClient;
    private InternalFactory factory = new InternalFactoryJSONImpl();
    private OnAccessTokenRefreshListener listener;

    public BacklogOAuthSupport(BacklogConfigure configure) {
        this.configure = configure;
        this.httpClient = new BacklogHttpClientImpl();
        init();
    }

    public BacklogOAuthSupport(BacklogConfigure configure, BacklogHttpClient httpClient) {
        this.configure = configure;
        this.httpClient = httpClient;
        init();
    }

    private void init() {
        httpClient.setReadTimeout(this.configure.getReadTimeout());
        httpClient.setConnectionTimeout(this.configure.getConnectionTimeout());
    }

    public void setOAuthClientId(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public void setOAuthRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public String getOAuthAuthorizationURL() throws BacklogException {
        String url = configure.getOAuthAuthorizationURL() +
                "?client_id=" + this.clientId +
                "&response_type=" + "code";
        if (redirectUrl != null) {
            try {
                url += "&redirect_uri=" + URLEncoder.encode(this.redirectUrl, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new BacklogAPIException(e);
            }
        }
        return url;
    }

    @Override
    public AccessToken getOAuthAccessToken(String oauthCode) throws BacklogException {
        if (oauthCode == null) {
            throw new IllegalArgumentException("oauthCode must not be null");
        }
        BacklogHttpResponse httpResponse = getAccessTokenResponse(oauthCode);
        checkError(httpResponse);
        return factory.createAccessToken(httpResponse);
    }

    @Override
    public AccessToken refreshOAuthAccessToken() throws BacklogException {
        if (configure.getAccessToken() == null) {
            throw new IllegalArgumentException("AccessToken must not be null");
        }
        BacklogHttpResponse httpResponse = getRefreshTokenResponse();
        checkError(httpResponse);
        AccessToken accessToken = factory.createAccessToken(httpResponse);
        configure.accessToken(accessToken);
        listener.onAccessTokenRefresh(accessToken);
        return accessToken;
    }

    @Override
    public void setOnAccessTokenRefreshListener(OnAccessTokenRefreshListener listener) {
        this.listener = listener;
    }

    private BacklogHttpResponse getAccessTokenResponse(String oauthCode) throws BacklogException {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new NameValuePair("code", oauthCode));
        params.add(new NameValuePair("client_id", clientId));
        params.add(new NameValuePair("client_secret", clientSecret));
        params.add(new NameValuePair("redirect_uri", redirectUrl));
        params.add(new NameValuePair("grant_type", "authorization_code"));
        BacklogHttpResponse ires = httpClient.post(configure.getOAuthAccessTokenURL(), params, new ArrayList<>());
        checkError(ires);
        return ires;

    }

    private BacklogHttpResponse getRefreshTokenResponse() throws BacklogException {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new NameValuePair("client_id", clientId));
        params.add(new NameValuePair("client_secret", clientSecret));
        params.add(new NameValuePair("refresh_token", configure.getAccessToken().getRefresh()));
        params.add(new NameValuePair("grant_type", "refresh_token"));
        BacklogHttpResponse ires = httpClient.post(configure.getOAuthAccessTokenURL(), params, new ArrayList<>());
        checkError(ires);
        return ires;
    }

    private void checkError(BacklogHttpResponse ires) {
        if (ires.getStatusCode() != 200 &&
                ires.getStatusCode() != 201) {
            throw new BacklogAuthException("backlog oauth request failed.", ires);
        }
    }
}
