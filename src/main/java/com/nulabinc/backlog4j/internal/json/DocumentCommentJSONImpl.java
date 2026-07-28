package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DocumentComment;
import com.nulabinc.backlog4j.DocumentCommentReply;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentCommentJSONImpl implements DocumentComment {

    private String id;
    private String documentId;
    private long statusId;
    private String content;
    private String plain;
    private String commentType;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;
    @JsonDeserialize(as = DocumentCommentReplyJSONImpl[].class)
    private DocumentCommentReply[] replies;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getDocumentId() {
        return this.documentId;
    }

    @Override
    public long getStatusId() {
        return this.statusId;
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
    public String getCommentType() {
        return this.commentType;
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
    public List<DocumentCommentReply> getReplies() {
        return Arrays.asList(this.replies);
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
        DocumentCommentJSONImpl rhs = (DocumentCommentJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.documentId, rhs.documentId)
                .append(this.statusId, rhs.statusId)
                .append(this.content, rhs.content)
                .append(this.plain, rhs.plain)
                .append(this.commentType, rhs.commentType)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .append(this.updated, rhs.updated)
                .append(this.replies, rhs.replies)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(documentId)
                .append(statusId)
                .append(content)
                .append(plain)
                .append(commentType)
                .append(createdUser)
                .append(created)
                .append(updated)
                .append(replies)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("documentId", documentId)
                .append("statusId", statusId)
                .append("content", content)
                .append("plain", plain)
                .append("commentType", commentType)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updated", updated)
                .append("replies", replies)
                .toString();
    }
}
