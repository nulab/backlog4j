package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DocumentCommentReply;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentCommentReplyJSONImpl implements DocumentCommentReply {

    private String id;
    private String documentId;
    private String commentId;
    private String content;
    private String plain;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getDocumentId() {
        return this.documentId;
    }

    @Override
    public String getCommentId() {
        return this.commentId;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public String getPlain() {
        return this.plain;
    }

    @Override
    public User getCreatedUser() {
        return this.createdUser;
    }

    @Override
    public Date getCreated() {
        return this.created;
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
        DocumentCommentReplyJSONImpl rhs = (DocumentCommentReplyJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.documentId, rhs.documentId)
                .append(this.commentId, rhs.commentId)
                .append(this.content, rhs.content)
                .append(this.plain, rhs.plain)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .append(this.updated, rhs.updated)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(documentId)
                .append(commentId)
                .append(content)
                .append(plain)
                .append(createdUser)
                .append(created)
                .append(updated)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("documentId", documentId)
                .append("commentId", commentId)
                .append("content", content)
                .append("plain", plain)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updated", updated)
                .toString();
    }
}
