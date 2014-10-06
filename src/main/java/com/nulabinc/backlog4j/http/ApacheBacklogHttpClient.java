package com.nulabinc.backlog4j.http;

import com.nulabinc.backlog4j.AttachmentData;
import com.nulabinc.backlog4j.BacklogAPIException;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.api.option.GetParams;
import com.nulabinc.backlog4j.api.option.QueryParams;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @author nulab-inc
 */
public class ApacheBacklogHttpClient implements BacklogHttpClient {

    private static final String userAgent = "backlog4jv2";
    private static final String contentType = "application/x-www-form-urlencoded; charset=UTF-8";

    private String apiKey;
    private String bearerToken;
    private int readTimeout;
    private int connectionTimeout;

    private HttpClient httpClient;

    public ApacheBacklogHttpClient(){
        this.httpClient = createThreadSafeHttpClient();
    }

    public ApacheBacklogHttpClient(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    @Override
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    @Override
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    @Override
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public BacklogHttpResponse get(String endpoint, GetParams getParams, QueryParams queryParams) throws BacklogException {

        String url = getUrl(endpoint);
        boolean paramExists = (apiKey != null);
        if (getParams != null) {
            url += getParams.getParamString(paramExists);
        }
        if (queryParams != null) {
            url += queryParams.getParamString(paramExists);
        }
        try {
            HttpGet httpGet = new HttpGet(url);
//            System.out.println(url);
            setHeaderInfo(httpGet);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            BacklogHttpResponse ires = new ApacheBacklogHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogAPIException(e);
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    public BacklogHttpResponse post(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        String url = getUrl(endpoint);

        try {
            HttpPost httpPost = new HttpPost(url);
            setHeaderInfo(httpPost);
            httpPost.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            BacklogHttpResponse ires = new ApacheBacklogHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogAPIException(e);
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    public BacklogHttpResponse patch(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        HttpClient httpClient = createHttpClient();
        String url = getUrl(endpoint);

        try {
            HttpPatch httpPatch = new HttpPatch(url);
            setHeaderInfo(httpPatch);
            httpPatch.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            HttpResponse httpResponse = httpClient.execute(httpPatch);
            BacklogHttpResponse ires = new ApacheBacklogHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogAPIException(e);
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    public BacklogHttpResponse put(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        String url = getUrl(endpoint);

        try {
            HttpPut httpPut = new HttpPut(url);
            setHeaderInfo(httpPut);
            httpPut.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            HttpResponse httpResponse = httpClient.execute(httpPut);
            BacklogHttpResponse ires = new ApacheBacklogHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogAPIException(e);
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    public BacklogHttpResponse delete(String endpoint, NameValuePair param) throws BacklogException {
        String url = getUrl(endpoint);

        if (param != null) {
            url += "&" + param.getName() + "=" + param.getValue();
        }

        try {
            HttpDelete httpDelete = new HttpDelete(url);
            setHeaderInfo(httpDelete);

            HttpResponse httpResponse = httpClient.execute(httpDelete);
            BacklogHttpResponse ires = new ApacheBacklogHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogAPIException(e);
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    public BacklogHttpResponse postMultiPart(String endpoint, Map<String, Object> parameters) throws BacklogException {

        String url = getUrl(endpoint);

        HttpPost httpPost = new HttpPost(url);
        if(apiKey == null && bearerToken != null){
            httpPost.setHeader("Authorization", "Bearer "+ bearerToken);
        }
        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,null,Charset.forName("UTF-8"));

        try {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    entity.addPart(name, new StringBody((String) value, ContentType.TEXT_PLAIN.toString(),
                            Charset.forName("utf-8")));
                } else if (value instanceof AttachmentData) {
                    AttachmentData attachmentData = (AttachmentData) value;
                    ContentBody contentBody = new InputStreamBody(attachmentData.getContent(), attachmentData.getFilename());
                    entity.addPart(name, contentBody);

                } else {
                    throw new BacklogAPIException("Illegal parameter type name=" + name + ",value=" + value);
                }
            }

            httpPost.setEntity(entity);


            HttpResponse httpResponse = httpClient.execute(httpPost);
            BacklogHttpResponse ires = new ApacheBacklogHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogAPIException(e);
        } catch (IOException e) {
            throw new BacklogAPIException(e);
        }
    }

    private HttpClient createHttpClient() {
        HttpClient httpClient = new DefaultHttpClient();
        HttpParams params = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, this.connectionTimeout);
        HttpConnectionParams.setSoTimeout(params, this.readTimeout);
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(params, userAgent);

        return httpClient;
    }

    private HttpClient createThreadSafeHttpClient(){
        SchemeRegistry schreg = new SchemeRegistry();
        schreg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schreg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, this.connectionTimeout);
        HttpConnectionParams.setSoTimeout(params, this.readTimeout);
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(params, userAgent);
        ThreadSafeClientConnManager mgr = new ThreadSafeClientConnManager(params, schreg);
        mgr.setDefaultMaxPerRoute(100);
        mgr.setMaxTotal(100);
        return new DefaultHttpClient(mgr, params);
    }

    private String getUrl(String endpoint){
        if(apiKey != null){
            return endpoint + "?apiKey=" + apiKey;
        }else{
            return endpoint;
        }
    }

    private void setHeaderInfo(HttpRequestBase httpRequestBase){
        httpRequestBase.setHeader("Content-Type", contentType);
        if(apiKey == null && bearerToken != null){
            httpRequestBase.setHeader("Authorization", "Bearer "+ bearerToken);
        }
    }
}
