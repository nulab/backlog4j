package com.nulabinc.backlog4j.internal.file;

import com.nulabinc.backlog4j.Icon;

import java.io.InputStream;

/**
 * @author nulab-inc
 */
public class IconImpl implements Icon {

    private String filename;

    private InputStream content;

    public IconImpl(String filename, InputStream content) {
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
