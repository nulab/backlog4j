package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for create webhook API.
 *
 * @author nulab-inc
 */
public class CreateWebhookParams extends PostParams {

    private Object projectIdOrKey;

    public CreateWebhookParams(Object projectIdOrKey, String name, String hookUrl) {
        this.projectIdOrKey = projectIdOrKey;
        String nameValue = (name == null) ? "" : name;
        String hookUrlValue = (hookUrl == null) ? "" : hookUrl;
        parameters.add(new NameValuePair("name", nameValue));
        parameters.add(new NameValuePair("hookUrl", hookUrlValue));
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    /**
     * Sets the description parameter.
     *
     * @param description the description identifier
     * @return CreateWebhookParams instance
     */
    public CreateWebhookParams description(String description) {
        String value = (description == null) ? "" : description;
        parameters.add(new NameValuePair("description", value));
        return this;
    }

    /**
     * Sets the allEvent parameter.
     *
     * @param allEvent the allEvent identifier
     * @return CreateWebhookParams instance
     */
    public CreateWebhookParams allEvent(boolean allEvent) {
        parameters.add(new NameValuePair("allEvent", String.valueOf(allEvent)));
        return this;
    }

    /**
     * Sets the activityTypeIds parameter.
     *
     * @param activityTypeIds the activityTypeIds identifier
     * @return CreateWebhookParams instance
     */
    public CreateWebhookParams activityTypeIds(List<Activity.Type> activityTypeIds) {
        if (activityTypeIds != null) {
            for (Activity.Type type : activityTypeIds) {
                parameters.add(new NameValuePair("activityTypeIds[]", String.valueOf(type.getIntValue())));
            }
        }
        return this;
    }
}
