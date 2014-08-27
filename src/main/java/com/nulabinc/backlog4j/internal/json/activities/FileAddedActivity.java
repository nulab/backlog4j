package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class FileAddedActivity extends ActivityJSONImpl {

    private int type = 8;

    @JsonDeserialize(as=FileAddedContent.class)
    private FileAddedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public FileAddedContent getContent() {
        return this.content;
    }

}
