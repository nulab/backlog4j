package com.nulabinc.backlog4j.auth;


import com.nulabinc.backlog4j.BacklogAuthException;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.internal.http.DefaultInternalHttpClient;
import com.nulabinc.backlog4j.internal.http.InternalHttpClient;
import com.nulabinc.backlog4j.internal.http.InternalHttpResponse;
import com.nulabinc.backlog4j.internal.json.Jackson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nulab-inc
 */
public class OAuthAuthorization implements OAuthSupport {

    private String clientId;
    private String clientSecret;
    private String permissions;
    private String redirectUrl;

    private BacklogConfigure configure;
    private InternalHttpClient httpClient;

    public OAuthAuthorization(BacklogConfigure configure) {
        this.configure = configure;
        this.httpClient = new DefaultInternalHttpClient();
        init();
    }

    public OAuthAuthorization(BacklogConfigure configure, InternalHttpClient httpClient) {
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
    public void setOAuthPermissions(String permissions) {
        this.permissions = permissions;
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
                throw new BacklogException(e);
            }
        }
        return url;
    }

    @Override
    public AccessToken getOAuthAccessToken(String oauthCode) throws BacklogException {
        if (oauthCode == null) {
            throw new IllegalArgumentException("oauthCode must not be null");
        }
        InternalHttpResponse httpResponse = getAccessTokenResponse(oauthCode);
        checkError(httpResponse);
        return Jackson.fromJsonString(httpResponse.asString(), AccessTokenJSONImpl.class);
    }

    @Override
    public AccessToken refreshOAuthAccessToken() throws BacklogException {
        if (configure.getAccessToken() == null) {
            throw new IllegalArgumentException("AccessToken must not be null");
        }
        InternalHttpResponse httpResponse = getRefreshTokenResponse();
        checkError(httpResponse);
        return Jackson.fromJsonString(httpResponse.asString(), AccessTokenJSONImpl.class);
    }

    private InternalHttpResponse getAccessTokenResponse(String oauthCode) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("code", oauthCode));
        params.add(new BasicNameValuePair("client_id", clientId));
        params.add(new BasicNameValuePair("client_secret", clientSecret));
        params.add(new BasicNameValuePair("redirect_uri", redirectUrl));
        params.add(new BasicNameValuePair("grant_type", "authorization_code"));
        InternalHttpResponse ires = httpClient.post(configure.getOAuthAccessTokenURL(), params);
        checkError(ires);
        return ires;

    }

    private InternalHttpResponse getRefreshTokenResponse() throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("client_id", clientId));
        params.add(new BasicNameValuePair("client_secret", clientSecret));
        params.add(new BasicNameValuePair("refresh_token", configure.getAccessToken().getRefresh()));
        params.add(new BasicNameValuePair("grant_type", "refresh_token"));
        InternalHttpResponse ires = httpClient.post(configure.getOAuthAccessTokenURL(), params);
        checkError(ires);
        return ires;
    }

    private void checkError(InternalHttpResponse ires) {
        if (ires.getStatusCode() != 200 &&
                ires.getStatusCode() != 201) {
            throw new BacklogAuthException("backlog oauth request failed.", ires);
        }
    }
}
