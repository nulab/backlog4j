package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for create webhook API.
 *
 * @author nulab-inc
 */
public class CreateWebhookParams extends PostParams {

    private long projectId;
    private String projectKey;

    public CreateWebhookParams(long projectId, String name, String hookUrl){
        this.projectId = projectId;
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("hookUrl", hookUrl));
    }

    public CreateWebhookParams(String projectKey, String name, String hookUrl){
        this.projectKey = projectKey;
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("hookUrl", hookUrl));
    }

    public String getProjectIdOrKeyString() {
        if(projectKey != null){
            return projectKey;
        }else{
            return String.valueOf(projectId);
        }
    }

    /**
     * Sets the description parameter.
     *
     * @param description the description identifier
     * @return CreateWebhookParams instance
     */
    public CreateWebhookParams description(String description) {
        parameters.add(new NameValuePair("description", description));
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
