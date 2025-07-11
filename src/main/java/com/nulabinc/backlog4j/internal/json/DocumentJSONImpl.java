package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
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
public class DocumentJSONImpl implements Document {

    private String id;
    private long projectId;
    private String title;
    @JsonDeserialize(using = JacksonCustomJsonDeserializer.class)
    private String json;
    private String plain;
    private long statusId;
    private String emoji;
    @JsonDeserialize(as = DocumentTagJSONImpl[].class)
    private DocumentTag[] tags;
    @JsonDeserialize(as = AttachmentJSONImpl[].class)
    private Attachment[] attachments;

    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User updatedUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getJson() {
        return this.json;
    }

    @Override
    public String getPlain() {
        return this.plain;
    }

    @Override
    public long getStatusId() {
        return this.statusId;
    }

    @Override
    public String getEmoji() {
        return this.emoji;
    }

    @Override
    public List<DocumentTag> getTags() {
        return Arrays.asList(this.tags);
    }

    @Override
    public List<Attachment> getAttachments() {
        return Arrays.asList(this.attachments);
    }

    @Override
    public long getProjectId() {
        return projectId;
    }

    @Override
    public String getProjectIdAsString() {
        return String.valueOf(this.projectId);
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
        DocumentJSONImpl rhs = (DocumentJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.projectId, rhs.projectId)
                .append(this.title, rhs.title)
                .append(this.json, rhs.json)
                .append(this.plain, rhs.plain)
                .append(this.statusId, rhs.statusId)
                .append(this.emoji, rhs.emoji)
                .append(this.tags, rhs.tags)
                .append(this.attachments, rhs.attachments)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .append(this.updatedUser, rhs.updatedUser)
                .append(this.updated, rhs.updated)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(projectId)
                .append(title)
                .append(json)
                .append(plain)
                .append(statusId)
                .append(emoji)
                .append(tags)
                .append(attachments)
                .append(createdUser)
                .append(created)
                .append(updatedUser)
                .append(updated)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("projectId", projectId)
                .append("title", title)
                .append("json", json)
                .append("plain", plain)
                .append("statusId", statusId)
                .append("emoji", emoji)
                .append("tags", tags)
                .append("attachments", attachments)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updatedUser", updatedUser)
                .append("updated", updated)
                .toString();
    }
}
