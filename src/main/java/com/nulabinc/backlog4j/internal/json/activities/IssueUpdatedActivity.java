package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class IssueUpdatedActivity extends ActivityJSONImpl {

    private int type = 2;

    @JsonDeserialize(as=IssueUpdatedContent.class)
    private IssueUpdatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public IssueUpdatedContent getContent() {
        return this.content;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("type", type)
                .append("content", content)
                .toString();
    }
}
