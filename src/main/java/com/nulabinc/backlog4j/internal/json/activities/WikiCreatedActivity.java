package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class WikiCreatedActivity extends ActivityJSONImpl {

    private int type = 5;

    @JsonDeserialize(as=WikiCreatedContent.class)
    private WikiCreatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public WikiCreatedContent getContent() {
        return this.content;
    }


}
