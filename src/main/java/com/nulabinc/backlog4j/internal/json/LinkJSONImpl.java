package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Link;

/**
 * @author nulab-inc
 */
public class LinkJSONImpl implements Link {

    private long id;
    @JsonProperty("key_id")
    private long keyId;
    private String title;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public long getKeyId() {
        return keyId;
    }

    @Override
    public String getTitle() {
        return title;
    }


}
