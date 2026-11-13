package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DocumentAttachment;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentAttachmentJSONImpl implements DocumentAttachment {

    private long id;
    private String name;
    private long size;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;

    // Fields of the old response shape. Kept so that the deprecated getters still compile and
    // still read them if a server returns them.
    private String documentId;
    private Long createdUserId;
    private Long updatedUserId;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(this.id);
    }

    @Deprecated
    @Override
    public String getDocumentId() {
        return this.documentId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public User getCreatedUser() {
        return this.createdUser;
    }

    @Deprecated
    @Override
    public Long getCreatedUserId() {
        if (this.createdUser != null) {
            return this.createdUser.getId();
        }
        return this.createdUserId;
    }

    @Override
    public Date getCreated() {
        return this.created;
    }

    @Override
    public boolean isImage() {
        if (this.name == null) {
            return false;
        }
        String lowerCase = this.name.toLowerCase();
        return (lowerCase.endsWith(".jpg") ||
                lowerCase.endsWith(".jpeg") ||
                lowerCase.endsWith(".png") ||
                lowerCase.endsWith(".gif"));
    }

    @Deprecated
    @Override
    public Long getUpdatedUserId() {
        return this.updatedUserId;
    }

    @Deprecated
    @Override
    public Date getUpdated() {
        return this.updated;
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
        DocumentAttachmentJSONImpl rhs = (DocumentAttachmentJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .append(this.size, rhs.size)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .append(this.documentId, rhs.documentId)
                .append(this.createdUserId, rhs.createdUserId)
                .append(this.updatedUserId, rhs.updatedUserId)
                .append(this.updated, rhs.updated)
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
                .append(documentId)
                .append(createdUserId)
                .append(updatedUserId)
                .append(updated)
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
