package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Link;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Link) {
            Link other = (Link)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("keyId", keyId)
                .append("title", title)
                .toString();
    }
}
