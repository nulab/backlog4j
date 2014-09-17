package com.nulabinc.backlog4j.internal.file;

import com.nulabinc.backlog4j.AttachmentData;

import java.io.InputStream;

public class AttachmentDataImpl implements AttachmentData {

    private final String filename;

    private final InputStream content;

    public AttachmentDataImpl(String filename, InputStream content) {
        this.filename = filename;
        this.content = content;
    }

    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public InputStream getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "IssueAttachmentImpl{" +
                "filename='" + filename + '\'' +
                ", content=" + content +
                '}';
    }

}
