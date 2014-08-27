package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class GitPushedActivity extends ActivityJSONImpl {

    private int type = 12;

    @JsonDeserialize(as=GitPushedContent.class)
    private GitPushedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public GitPushedContent getContent() {
        return this.content;
    }

}
