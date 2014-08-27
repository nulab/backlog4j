package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class FileDeletedActivity extends ActivityJSONImpl {

    private int type = 10;

    @JsonDeserialize(as=FileDeletedContent.class)
    private FileDeletedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public FileDeletedContent getContent() {
        return this.content;
    }

}
