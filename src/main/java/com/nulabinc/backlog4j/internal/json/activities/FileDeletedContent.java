package com.nulabinc.backlog4j.internal.json.activities;

import com.nulabinc.backlog4j.Content;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class FileDeletedContent extends Content {

    private long id;
    private String name;
    private String dir;
    private long size;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getDir() {
        return dir;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("id", id)
                .append("name", name)
                .append("dir", dir)
                .append("size", size)
                .toString();
    }
}
