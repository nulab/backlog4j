package com.nulabinc.backlog4j.internal.json.activities;

import com.nulabinc.backlog4j.*;

/**
 * @author nulab-inc
 */
public class FileAddedContent extends Content {

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
}
