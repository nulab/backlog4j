package com.nulabinc.backlog4j.http;

import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * @author nulab-inc
 */
public interface BacklogHttpResponse {
    int getStatusCode();

    LocalDateTime getRateLimitResetDate();

    String getRateLimitReset();

    InputStream asInputStream();

    String asString();

    String getFileNameFromContentDisposition();

}
