package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for create group API.
 *
 * @author nulab-inc
 */
public class CreateGroupParams extends PostParams {

    public CreateGroupParams(String name) {
        parameters.add(new NameValuePair("name", name));
    }

    public CreateGroupParams members(List members) {
        for (Object member : members) {
            parameters.add(new NameValuePair("members[]", member.toString()));
        }
        return this;
    }
}
