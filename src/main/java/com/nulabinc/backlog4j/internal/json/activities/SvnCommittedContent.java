package com.nulabinc.backlog4j.internal.json.activities;

import com.nulabinc.backlog4j.Content;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class SvnCommittedContent extends Content {

    private String comment;
    private long rev;

    public String getComment() {
        return comment;
    }

    public long getRev() {
        return rev;
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
        SvnCommittedContent rhs = (SvnCommittedContent) obj;
        return new EqualsBuilder()
                .append(this.comment, rhs.comment)
                .append(this.rev, rhs.rev)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(comment)
                .append(rev)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("comment", comment)
                .append("rev", rev)
                .toString();
    }
}
