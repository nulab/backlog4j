package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Content;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class IssueDeletedContent extends Content {

    private long id;
    @JsonProperty("key_id")
    private long keyId;

    public long getId() {
        return this.id;
    }

    public long getKeyId() {
        return this.keyId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("id", id)
                .append("keyId", keyId)
                .toString();
    }
}
