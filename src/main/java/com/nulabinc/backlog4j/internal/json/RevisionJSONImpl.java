package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Revision;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
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
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Revision) {
            Revision other = (Revision)obj;
            result = new EqualsBuilder().append( rev, other.getRev() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rev", rev)
                .append("comment", comment)
                .toString();
    }
}
