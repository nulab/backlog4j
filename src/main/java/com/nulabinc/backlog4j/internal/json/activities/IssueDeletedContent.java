package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Content;

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
}
