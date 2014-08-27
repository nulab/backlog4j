package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class ProjectUserAddedActivity extends ActivityJSONImpl {

    private int type = 15;

    @JsonDeserialize(as=ProjectUserAddedContent.class)
    private ProjectUserAddedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public ProjectUserAddedContent getContent() {
        return this.content;
    }

}
