package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class IssueMultiUpdatedActivity extends ActivityJSONImpl {

    private int type = 14;

    @JsonDeserialize(as=MultiUpdatedContentIssue.class)
    private MultiUpdatedContentIssue content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public MultiUpdatedContentIssue getContent() {
        return this.content;
    }

}
