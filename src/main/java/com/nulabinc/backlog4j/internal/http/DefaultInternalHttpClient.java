package com.nulabinc.backlog4j.internal.http;

import com.nulabinc.backlog4j.AttachmentData;
import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.api.option.QueryParams;
import com.nulabinc.backlog4j.api.option.GetParams;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @author nulab-inc
 */
public class DefaultInternalHttpClient implements InternalHttpClient {

    private static final String userAgent = "backlog4jv2";
    private static final String contentType = "application/x-www-form-urlencoded; charset=UTF-8";

    private String apiKey;
    private String bearerToken;
    private int readTimeout;
    private int connectionTimeout;

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

    public InternalHttpResponse get(String endpoint, GetParams getParams, QueryParams queryParams) throws BacklogException {

        HttpClient httpClient = createHttpClient();
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
            System.out.println(url);
            setHeaderInfo(httpGet);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            InternalHttpResponse ires = new InternalHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogException(e);
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    public InternalHttpResponse post(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        HttpClient httpClient = createHttpClient();
        String url = getUrl(endpoint);

        try {
            HttpPost httpPost = new HttpPost(url);
            setHeaderInfo(httpPost);
            httpPost.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            InternalHttpResponse ires = new InternalHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogException(e);
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    public InternalHttpResponse patch(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        HttpClient httpClient = createHttpClient();
        String url = getUrl(endpoint);

        try {
            HttpPatch httpPatch = new HttpPatch(url);
            setHeaderInfo(httpPatch);
            httpPatch.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            HttpResponse httpResponse = httpClient.execute(httpPatch);
            InternalHttpResponse ires = new InternalHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogException(e);
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    public InternalHttpResponse put(String endpoint, List<NameValuePair> parameters) throws BacklogException {
        HttpClient httpClient = createHttpClient();
        String url = getUrl(endpoint);

        try {
            HttpPut httpPut = new HttpPut(url);
            setHeaderInfo(httpPut);
            httpPut.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            HttpResponse httpResponse = httpClient.execute(httpPut);
            InternalHttpResponse ires = new InternalHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogException(e);
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    public InternalHttpResponse delete(String endpoint, NameValuePair param) throws BacklogException {
        HttpClient httpClient = createHttpClient();
        String url = getUrl(endpoint);

        if (param != null) {
            url += "&" + param.getName() + "=" + param.getValue();
        }

        try {
            HttpDelete httpDelete = new HttpDelete(url);
            setHeaderInfo(httpDelete);

            HttpResponse httpResponse = httpClient.execute(httpDelete);
            InternalHttpResponse ires = new InternalHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogException(e);
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    public InternalHttpResponse postMultiPart(String endpoint, Map<String, Object> parameters) throws BacklogException {

        HttpClient httpClient = createHttpClient();
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
                    throw new BacklogException("Illegal parameter type name=" + name + ",value=" + value);
                }
            }

            httpPost.setEntity(entity);


            HttpResponse httpResponse = httpClient.execute(httpPost);
            InternalHttpResponse ires = new InternalHttpResponse(httpResponse, httpClient.getConnectionManager());
            return ires;
        } catch (ClientProtocolException e) {
            throw new BacklogException(e);
        } catch (IOException e) {
            throw new BacklogException(e);
        }
    }

    private HttpClient createHttpClient() {
        HttpClient httpClient = new DefaultHttpClient();
        HttpParams params = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, this.connectionTimeout);
        HttpConnectionParams.setSoTimeout(params, this.readTimeout);
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

        return httpClient;
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
        httpRequestBase.setHeader("User-Agent", userAgent);
        if(apiKey == null && bearerToken != null){
            httpRequestBase.setHeader("Authorization", "Bearer "+ bearerToken);
        }
    }
}
