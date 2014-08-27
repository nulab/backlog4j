package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class GitRepositoryCreatedActivity extends ActivityJSONImpl {

    private int type = 13;

    @JsonDeserialize(as=GitRepositoryCreatedContent.class)
    private GitRepositoryCreatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public GitRepositoryCreatedContent getContent() {
        return this.content;
    }

}
