package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Category;

/**
 * @author nulab-inc
 */
public class CategoryJSONImpl implements Category {

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
