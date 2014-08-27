package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class WikiDeletedActivity extends ActivityJSONImpl {

    private int type = 7;

    @JsonDeserialize(as=WikiDeletedContent.class)
    private WikiDeletedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public WikiDeletedContent getContent() {
        return this.content;
    }


}
