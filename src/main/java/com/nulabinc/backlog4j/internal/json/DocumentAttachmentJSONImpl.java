package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DocumentAttachment;
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
    private String documentId;
    private String name;
    private long size;
    private Long createdUserId;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
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
    public Long getCreatedUserId() {
        return this.createdUserId;
    }

    @Override
    public Date getCreated() {
        return this.created;
    }

    @Override
    public Long getUpdatedUserId() {
        return this.updatedUserId;
    }

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
                .append(this.documentId, rhs.documentId)
                .append(this.name, rhs.name)
                .append(this.size, rhs.size)
                .append(this.createdUserId, rhs.createdUserId)
                .append(this.created, rhs.created)
                .append(this.updatedUserId, rhs.updatedUserId)
                .append(this.updated, rhs.updated)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(documentId)
                .append(name)
                .append(size)
                .append(createdUserId)
                .append(created)
                .append(updatedUserId)
                .append(updated)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("documentId", documentId)
                .append("name", name)
                .append("size", size)
                .append("createdUserId", createdUserId)
                .append("created", created)
                .append("updatedUserId", updatedUserId)
                .append("updated", updated)
                .toString();
    }
}
