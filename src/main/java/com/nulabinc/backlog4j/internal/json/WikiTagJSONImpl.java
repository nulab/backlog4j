package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.WikiTag;

/**
 * @author nulab-inc
 */
public class WikiTagJSONImpl implements WikiTag {

    private long id;
    private String name;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
