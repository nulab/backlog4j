package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Parameters for update webhook API.
 *
 * @author nulab-inc
 */
public class UpdateWebhookParams extends PatchParams {

    private long projectId;
    private String projectKey;
    private long webhookId;

    public UpdateWebhookParams(long projectId, long webhookId) {
        this.projectId = projectId;
        this.webhookId = webhookId;
    }

    public UpdateWebhookParams(String projectKey, long webhookId) {
        this.projectKey = projectKey;
        this.webhookId = webhookId;
    }

    public String getProjectIdOrKeyString() {
        if (projectKey != null) {
            return projectKey;
        } else {
            return String.valueOf(projectId);
        }
    }

    public long getWebhookId() {
        return webhookId;
    }

    public UpdateWebhookParams name(String name) {
        parameters.add(new NameValuePair("name", name));
        return this;
    }

    public UpdateWebhookParams description(String description) {
        parameters.add(new NameValuePair("description", description));
        return this;
    }

    public UpdateWebhookParams hookUrl(String hookUrl) {
        parameters.add(new NameValuePair("hookUrl", hookUrl));
        return this;
    }

    public UpdateWebhookParams allEvent(boolean allEvent) {
        parameters.add(new NameValuePair("allEvent", String.valueOf(allEvent)));
        return this;
    }

    public UpdateWebhookParams activityTypeIds(List<Activity.Type> activityTypeIds) {
        if (activityTypeIds == null) {
            parameters.add(new NameValuePair("activityTypeIds[]", ""));
        } else {
            for (Activity.Type type : activityTypeIds) {
                parameters.add(new NameValuePair("activityTypeIds[]", String.valueOf(type.getIntValue())));
            }
        }
        return this;
    }
}
