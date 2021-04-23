package com.nulabinc.backlog4j.http;

import java.io.InputStream;
import java.util.Date;

/**
 * @author nulab-inc
 */
public interface BacklogHttpResponse {
    int getStatusCode();

    int getRateLimitLimit();

    int getRateLimitRemaining();

    Date getRateLimitResetDate();

    String getRateLimitReset();

    InputStream asInputStream();

    String asString();

    String getFileNameFromContentDisposition();

}
