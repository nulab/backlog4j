package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nulabinc.backlog4j.Content;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        IssueDeletedContent rhs = (IssueDeletedContent) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.keyId, rhs.keyId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(keyId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("keyId", keyId)
                .toString();
    }
}
