package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.WikiHistory;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class WikiHistoryJSONImpl implements WikiHistory {

    private long pageId;
    private int version;
    private String name;
    private String content;

    @JsonDeserialize(as=UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User updatedUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;


    @Override
    public long getPageId() {
        return pageId;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public User getCreatedUser() {
        return createdUser;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public User getUpdatedUser() {
        return updatedUser;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

}
