package com.nulabinc.backlog4j.http;

import java.io.InputStream;
import java.util.Date;

/**
 * @author nulab-inc
 */
public interface BacklogHttpResponse {
    int getStatusCode();

    Integer getRateLimitLimit();

    Integer getRateLimitRemaining();

    Date getRateLimitResetDate();

    String getRateLimitReset();

    InputStream asInputStream();

    String asString();

    String getFileNameFromContentDisposition();

}
