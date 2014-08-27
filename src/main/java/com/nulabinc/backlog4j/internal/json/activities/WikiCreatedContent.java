package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Attachment;
import com.nulabinc.backlog4j.Content;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.internal.json.AttachmentJSONImpl;
import com.nulabinc.backlog4j.internal.json.SharedFileJSONImpl;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class WikiCreatedContent extends Content {

    private long id;
    private String name;
    private String content;
    private String diff;
    private int version;
    @JsonDeserialize(as= AttachmentJSONImpl[].class)
    private Attachment[] attachments;
    @JsonDeserialize(as= SharedFileJSONImpl[].class)
    @JsonProperty("shared_files")
    private SharedFile[] sharedFiles;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getDiff() {
        return diff;
    }

    public int getVersion() {
        return version;
    }

    public List<Attachment> getAttachments() {
        return Arrays.asList(attachments);
    }

    public List<SharedFile> getSharedFiles() {
        return Arrays.asList(sharedFiles);
    }
}
