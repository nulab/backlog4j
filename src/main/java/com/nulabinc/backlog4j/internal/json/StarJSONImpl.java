package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
    public String getIdAsString() {
        return String.valueOf(this.id);
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        StarJSONImpl rhs = (StarJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.comment, rhs.comment)
                .append(this.url, rhs.url)
                .append(this.title, rhs.title)
                .append(this.presenter, rhs.presenter)
                .append(this.created, rhs.created)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(comment)
                .append(url)
                .append(title)
                .append(presenter)
                .append(created)
                .toHashCode();
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
