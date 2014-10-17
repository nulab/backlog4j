package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for create project API.
 *
 * @author nulab-inc
 */
public class CreateProjectParams extends PostParams {

    public CreateProjectParams(String name, String projectKey,
                               boolean chartEnabled, boolean subtaskingEnabled,
                               Project.TextFormattingRule textFormattingRule){

        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("key", projectKey));
        parameters.add(new NameValuePair("chartEnabled", String.valueOf(chartEnabled)));
        parameters.add(new NameValuePair("subtaskingEnabled", String.valueOf(subtaskingEnabled)));
        parameters.add(new NameValuePair("textFormattingRule", textFormattingRule.getStrValue()));
    }
}
