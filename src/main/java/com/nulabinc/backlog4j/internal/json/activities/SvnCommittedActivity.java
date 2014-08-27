package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author nulab-inc
 */
public class SvnCommittedActivity extends ActivityJSONImpl {

    private int type = 11;

    @JsonDeserialize(as=SvnCommittedContent.class)
    private SvnCommittedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public SvnCommittedContent getContent() {
        return this.content;
    }

}
