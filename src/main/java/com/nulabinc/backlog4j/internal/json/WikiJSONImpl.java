package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class WikiJSONImpl implements Wiki {

    private long id;
    private long projectId;
    private String name;
    private String content;
    @JsonDeserialize(as=WikiTagJSONImpl[].class)
    private WikiTag[] tags;
    @JsonDeserialize(as=AttachmentJSONImpl[].class)
    private Attachment[] attachments;
    @JsonDeserialize(as=SharedFileJSONImpl[].class)
    private SharedFile[] sharedFiles;
    @JsonDeserialize(as=StarJSONImpl[].class)
    private Star[] stars;

    @JsonDeserialize(as=UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as=UserJSONImpl.class)
    private User updatedUser;
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
    public String getName() {
        return this.name;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public List<WikiTag> getTags() {
        return Arrays.asList(this.tags);
    }

    @Override
    public List<Attachment> getAttachments() {
        return Arrays.asList(this.attachments);
    }

    @Override
    public List<SharedFile> getSharedFiles() {
        return Arrays.asList(this.sharedFiles);
    }

    @Override
    public List<Star> getStars() {
        return Arrays.asList(this.stars);
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
        WikiJSONImpl rhs = (WikiJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.projectId, rhs.projectId)
                .append(this.name, rhs.name)
                .append(this.content, rhs.content)
                .append(this.tags, rhs.tags)
                .append(this.attachments, rhs.attachments)
                .append(this.sharedFiles, rhs.sharedFiles)
                .append(this.stars, rhs.stars)
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
                .append(name)
                .append(content)
                .append(tags)
                .append(attachments)
                .append(sharedFiles)
                .append(stars)
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
                .append("name", name)
                .append("content", content)
                .append("tags", tags)
                .append("attachments", attachments)
                .append("sharedFiles", sharedFiles)
                .append("stars", stars)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updatedUser", updatedUser)
                .append("updated", updated)
                .toString();
    }
}
