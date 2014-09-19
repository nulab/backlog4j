package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.http.BacklogHttpClient;

/**
 * Provides a BacklogClient instance with the given configure.
 *
 * @author nulab-inc
 */
public class BacklogClientFactory {
    private BacklogConfigure configure;
    private BacklogHttpClient httpClient;

    public BacklogClientFactory(BacklogConfigure configure) {
        this.configure = configure;
    }
    public BacklogClientFactory(BacklogConfigure configure, BacklogHttpClient httpClient) {
        this.configure = configure;
        this.httpClient = httpClient;
    }

    public BacklogClient newClient() {
        if(httpClient == null){
            return new BacklogClientImpl(configure);
        }else{
            return new BacklogClientImpl(configure, httpClient);
        }
    }
}
