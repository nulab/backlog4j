package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.AttributeInfo;

/**
 * @author nulab-inc
 */
public class AttributeInfoJSONImpl implements AttributeInfo {

    private long id;
    private String typeId;;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getTypeId() {
        return typeId;
    }

}
