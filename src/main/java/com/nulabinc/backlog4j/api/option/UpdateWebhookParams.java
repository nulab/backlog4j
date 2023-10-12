package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for update webhook API.
 *
 * @author nulab-inc
 */
public class UpdateWebhookParams extends PatchParams {

    private Object projectIdOrKey;
    private Object webhookId;

    public UpdateWebhookParams(Object projectIdOrKey, long webhookId) {
        this.projectIdOrKey = projectIdOrKey;
        this.webhookId = webhookId;
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public String getWebhookId() {
        return webhookId.toString();
    }

    public UpdateWebhookParams name(String name) {
        String value = (name == null) ? "" : name;
        parameters.add(new NameValuePair("name", value));
        return this;
    }

    public UpdateWebhookParams description(String description) {
        String value = (description == null) ? "" : description;
        parameters.add(new NameValuePair("description", value));
        return this;
    }

    public UpdateWebhookParams hookUrl(String hookUrl) {
        String value = (hookUrl == null) ? "" : hookUrl;
        parameters.add(new NameValuePair("hookUrl", value));
        return this;
    }

    public UpdateWebhookParams allEvent(boolean allEvent) {
        parameters.add(new NameValuePair("allEvent", String.valueOf(allEvent)));
        return this;
    }

    public UpdateWebhookParams activityTypeIds(List<Activity.Type> activityTypeIds) {
        if (activityTypeIds != null) {
            for (Activity.Type type : activityTypeIds) {
                parameters.add(new NameValuePair("activityTypeIds[]", String.valueOf(type.getIntValue())));
            }
        }
        return this;
    }
}
