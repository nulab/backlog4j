package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for update group API.
 *
 * @author nulab-inc
 */
public class UpdateGroupParams extends PatchParams {

    private String groupId;

    public UpdateGroupParams(Object groupId) {
        this.groupId = groupId.toString();
    }


    public UpdateGroupParams name(String name) {
        parameters.add(new NameValuePair("name", name));
        return this;
    }

    public UpdateGroupParams members(List members) {
        for (Object member : members) {
            parameters.add(new NameValuePair("members[]", member.toString()));
        }
        return this;
    }

    public String getGroupId() {
        return groupId;
    }
}
