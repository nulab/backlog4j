package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.AttachmentInfo;

/**
 * @author nulab-inc
 */
public class AttachmentInfoJSONImpl implements AttachmentInfo {

    private long id;
    private String name;;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
