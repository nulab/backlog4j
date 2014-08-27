package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for create project API.
 *
 * @author nulab-inc
 */
public class CreateProjectParams extends PostParams {

    public CreateProjectParams(String name, String projectKey,
                               boolean chartEnabled, boolean subtaskingEnabled,
                               Project.TextFormattingRule textFormattingRule){

        parameters.add(new BasicNameValuePair("name", name));
        parameters.add(new BasicNameValuePair("key", projectKey));
        parameters.add(new BasicNameValuePair("chartEnabled", String.valueOf(chartEnabled)));
        parameters.add(new BasicNameValuePair("subtaskingEnabled", String.valueOf(subtaskingEnabled)));
        parameters.add(new BasicNameValuePair("textFormattingRule", textFormattingRule.getStrValue()));
    }
}
