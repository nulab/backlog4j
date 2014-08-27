package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for get notification API.
 *
 * @author nulab-inc
 */
public class GetNotificationCountParams extends GetParams {

    public GetNotificationCountParams alreadyRead(boolean alreadyRead) {
        parameters.add(new BasicNameValuePair("alreadyRead", String.valueOf(alreadyRead)));
        return this;
    }

    public GetNotificationCountParams resourceAlreadyRead(boolean resourceAlreadyRead) {
        parameters.add(new BasicNameValuePair("resourceAlreadyRead", String.valueOf(resourceAlreadyRead)));
        return this;
    }
}
