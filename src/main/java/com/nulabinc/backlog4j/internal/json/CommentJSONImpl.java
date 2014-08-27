package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Comment;

/**
 * @author nulab-inc
 */
public class CommentJSONImpl implements Comment {

    private long id;
    private String content;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "ProjectJSONImpl extends " + super.toString();
    }




}
