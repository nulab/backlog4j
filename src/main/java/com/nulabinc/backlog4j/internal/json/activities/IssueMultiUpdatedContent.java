package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.internal.json.ChangeJSONImpl;
import com.nulabinc.backlog4j.internal.json.CommentJSONImpl;
import com.nulabinc.backlog4j.internal.json.LinkJSONImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueMultiUpdatedContent extends Content {

    @JsonProperty("tx_id")
    private int txId;
    @JsonDeserialize(as = CommentJSONImpl.class)
    private Comment comment;
    @JsonDeserialize(as = LinkJSONImpl[].class)
    private Link[] link;
    @JsonDeserialize(as = ChangeJSONImpl[].class)
    private Change[] changes;

    public long getTxId() {
        return txId;
    }

    public List<Link> getLink() {
        return Arrays.asList(link);
    }

    public List<Change> getChanges() {
        return Arrays.asList(changes);
    }

    public Comment getComment() {
        return comment;
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
        IssueMultiUpdatedContent rhs = (IssueMultiUpdatedContent) obj;
        return new EqualsBuilder()
                .append(this.txId, rhs.txId)
                .append(this.comment, rhs.comment)
                .append(this.link, rhs.link)
                .append(this.changes, rhs.changes)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(txId)
                .append(comment)
                .append(link)
                .append(changes)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("txId", txId)
                .append("comment", comment)
                .append("link", link)
                .append("changes", changes)
                .toString();
    }
}
