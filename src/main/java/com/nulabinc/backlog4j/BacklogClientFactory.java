package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.internal.http.InternalHttpClient;

/**
 * Provides a BacklogClient instance with the given configure.
 *
 * @author nulab-inc
 */
public class BacklogClientFactory {
    private BacklogConfigure configure;
    private InternalHttpClient httpClient;

    public BacklogClientFactory(BacklogConfigure configure) {
        this.configure = configure;
    }
    public BacklogClientFactory(BacklogConfigure configure, InternalHttpClient httpClient) {
        this.configure = configure;
    }

    public BacklogClient newClient() {
        if(httpClient == null){
            return new BacklogClientImpl(configure);
        }else{
            return new BacklogClientImpl(configure, httpClient);
        }
    }
}
