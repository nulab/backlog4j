package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Revision;

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


}
