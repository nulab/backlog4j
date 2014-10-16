package com.nulabinc.backlog4j.internal.json.activities;

import com.nulabinc.backlog4j.Content;
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
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("comment", comment)
                .append("rev", rev)
                .toString();
    }
}
