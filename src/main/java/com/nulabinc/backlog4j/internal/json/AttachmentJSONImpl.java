package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Attachment;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentJSONImpl implements Attachment {

    private long id;
    private String name;
    private long size;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User createdUser;
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
    public String getName() {
        return name;
    }

    @Override
    public boolean isImage() {
        String lowerCase = name.toLowerCase();
        return (lowerCase.endsWith(".jpg") ||
                lowerCase.endsWith(".jpeg") ||
                lowerCase.endsWith(".png") ||
                lowerCase.endsWith(".gif"));
    }

    @Override
    public long getSize() {
        return size;
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
        AttachmentJSONImpl rhs = (AttachmentJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .append(this.size, rhs.size)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(size)
                .append(createdUser)
                .append(created)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("size", size)
                .append("createdUser", createdUser)
                .append("created", created)
                .toString();
    }
}
