package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class ProjectUserRemovedActivity extends ActivityJSONImpl {

    private int type = 16;

    @JsonDeserialize(as=ProjectUserRemovedContent.class)
    private ProjectUserRemovedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public ProjectUserRemovedContent getContent() {
        return this.content;
    }

}
