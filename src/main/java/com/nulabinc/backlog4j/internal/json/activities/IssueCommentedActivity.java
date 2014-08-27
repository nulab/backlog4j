package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class IssueCommentedActivity extends ActivityJSONImpl {

    private int type = 3;

    @JsonDeserialize(as=IssueCommentedContent.class)
    private IssueCommentedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public IssueCommentedContent getContent() {
        return this.content;
    }


}
