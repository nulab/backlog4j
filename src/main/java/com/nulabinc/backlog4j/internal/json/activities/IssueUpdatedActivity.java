package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class IssueUpdatedActivity extends ActivityJSONImpl {

    private int type = 2;

    @JsonDeserialize(as=IssueUpdatedContent.class)
    private IssueUpdatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public IssueUpdatedContent getContent() {
        return this.content;
    }


}
