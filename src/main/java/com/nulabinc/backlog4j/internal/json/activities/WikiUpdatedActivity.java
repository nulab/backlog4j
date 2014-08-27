package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class WikiUpdatedActivity extends ActivityJSONImpl {

    private int type = 6;

    @JsonDeserialize(as=WikiUpdatedContent.class)
    private WikiUpdatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public WikiUpdatedContent getContent() {
        return this.content;
    }


}
