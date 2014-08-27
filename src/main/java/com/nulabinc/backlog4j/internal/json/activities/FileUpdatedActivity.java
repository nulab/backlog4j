package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class FileUpdatedActivity extends ActivityJSONImpl {

    private int type = 9;

    @JsonDeserialize(as=FileUpdatedContent.class)
    private FileUpdatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public FileUpdatedContent getContent() {
        return this.content;
    }

}
