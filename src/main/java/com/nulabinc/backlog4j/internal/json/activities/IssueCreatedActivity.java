package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class IssueCreatedActivity extends ActivityJSONImpl {

    private int type = 1;

    @JsonDeserialize(as=IssueCreatedContent.class)
    private IssueCreatedContent content;

    @Override
    public Type getType() {
        return Type.valueOf(this.type);
    }

    @Override
    public IssueCreatedContent getContent() {
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
