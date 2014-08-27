package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.internal.json.AttachmentJSONImpl;
import com.nulabinc.backlog4j.internal.json.ChangeJSONImpl;
import com.nulabinc.backlog4j.internal.json.CommentJSONImpl;
import com.nulabinc.backlog4j.internal.json.SharedFileJSONImpl;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class IssueCommentedContent extends Content {

    private long id;
    @JsonProperty("key_id")
    private long keyId;
    private String summary;
    private String description;
    @JsonDeserialize(as=CommentJSONImpl.class)
    private Comment comment;
    @JsonDeserialize(as= ChangeJSONImpl[].class)
    private Change[] changes;
    @JsonDeserialize(as= AttachmentJSONImpl[].class)
    private Attachment[] attachments;
    @JsonDeserialize(as= SharedFileJSONImpl[].class)
    @JsonProperty("shared_files")
    private SharedFile[] sharedFiles;


    public long getId() {
        return this.id;
    }

    public long getKeyId() {
        return this.keyId;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public Comment getComment() {
        return comment;
    }

    public List<Change> getChanges() {
        return Arrays.asList(this.changes);
    }

    public List<Attachment> getAttachments() {
        return Arrays.asList(attachments);
    }

    public List<SharedFile> getSharedFiles() {
        return Arrays.asList(sharedFiles);
    }
}
