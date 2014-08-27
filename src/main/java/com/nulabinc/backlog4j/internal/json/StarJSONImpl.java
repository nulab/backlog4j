package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.User;

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


    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public User getPresenter() {
        return presenter;
    }

    public Date getCreated() {
        return created;
    }
}
