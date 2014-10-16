package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Comment;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Comment) {
            Comment other = (Comment)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("content", content)
                .toString();
    }
}
