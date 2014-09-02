package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class IssueMultiUpdatedActivity extends ActivityJSONImpl {

    private int type = 14;

    @JsonDeserialize(as=IssueMultiUpdatedContent.class)
    private IssueMultiUpdatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public IssueMultiUpdatedContent getContent() {
        return this.content;
    }

}
