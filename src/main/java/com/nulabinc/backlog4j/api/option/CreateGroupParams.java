package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for create group API.
 *
 * @author nulab-inc
 */
public class CreateGroupParams extends PostParams {

    public CreateGroupParams(String name){
        parameters.add(new BasicNameValuePair("name", name));
    }

    public CreateGroupParams members(List<Long> members) {
        for (Long member : members) {
            parameters.add(new BasicNameValuePair("members[]", member.toString()));
        }
        return this;
    }
}
