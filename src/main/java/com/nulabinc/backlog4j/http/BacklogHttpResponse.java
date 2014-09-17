package com.nulabinc.backlog4j.http;

import java.io.InputStream;

/**
 * @author nulab-inc
 */
public interface BacklogHttpResponse {
    int getStatusCode();

    InputStream asInputStream();

    String asString();

    String getFileNameFromContentDisposition();

}
