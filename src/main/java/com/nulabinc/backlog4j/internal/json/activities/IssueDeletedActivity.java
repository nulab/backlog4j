package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class IssueDeletedActivity extends ActivityJSONImpl {

    private int type = 4;

    @JsonDeserialize(as=IssueDeletedContent.class)
    private IssueDeletedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public IssueDeletedContent getContent() {
        return this.content;
    }


}
