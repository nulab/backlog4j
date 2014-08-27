package com.nulabinc.backlog4j.internal.json.activities;

import com.nulabinc.backlog4j.Content;

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
}
