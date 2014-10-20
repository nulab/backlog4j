package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Revision;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class RevisionJSONImpl implements Revision {

    private String rev;
    private String comment;

    @Override
    public String getRev() {
        return this.rev;
    }

    @Override
    public String getComment() {
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
        RevisionJSONImpl rhs = (RevisionJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.rev, rhs.rev)
                .append(this.comment, rhs.comment)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(rev)
                .append(comment)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rev", rev)
                .append("comment", comment)
                .toString();
    }
}
