package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class StarJSONImpl implements Star {

    private long id;
    private String comment;
    private String url;
    private String title;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User presenter;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public User getPresenter() {
        return presenter;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Star) {
            Star other = (Star)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("comment", comment)
                .append("url", url)
                .append("title", title)
                .append("presenter", presenter)
                .append("created", created)
                .toString();
    }
}
