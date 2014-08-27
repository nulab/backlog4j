package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * Parameters for update group API.
 *
 * @author nulab-inc
 */
public class UpdateGroupParams extends PatchParams {

    private long groupId;

    public UpdateGroupParams(long groupId){
        this.groupId = groupId;
    }


    public UpdateGroupParams name(String name) {
        parameters.add(new BasicNameValuePair("name", name));
        return this;
    }

    public UpdateGroupParams members(List<Long> members) {
        for (Long member : members) {
            parameters.add(new BasicNameValuePair("members[]", member.toString()));
        }
        return this;
    }


    public long getGroupId() {
        return groupId;
    }
}
