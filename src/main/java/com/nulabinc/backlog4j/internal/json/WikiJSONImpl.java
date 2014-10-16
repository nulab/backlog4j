package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
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
        if( obj instanceof Wiki ) {
            Wiki other = (Wiki)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
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
