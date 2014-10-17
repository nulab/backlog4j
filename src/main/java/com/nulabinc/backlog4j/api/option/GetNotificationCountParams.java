package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get notification API.
 *
 * @author nulab-inc
 */
public class GetNotificationCountParams extends GetParams {

    public GetNotificationCountParams alreadyRead(boolean alreadyRead) {
        parameters.add(new NameValuePair("alreadyRead", String.valueOf(alreadyRead)));
        return this;
    }

    public GetNotificationCountParams resourceAlreadyRead(boolean resourceAlreadyRead) {
        parameters.add(new NameValuePair("resourceAlreadyRead", String.valueOf(resourceAlreadyRead)));
        return this;
    }
}
