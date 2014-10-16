package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.WikiHistory;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof WikiHistory ) {
            WikiHistory other = (WikiHistory)obj;
            result = new EqualsBuilder().append( pageId, other.getPageId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pageId", pageId)
                .append("version", version)
                .append("name", name)
                .append("content", content)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updatedUser", updatedUser)
                .append("updated", updated)
                .toString();
    }
}
