package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.ViewedWiki;
import com.nulabinc.backlog4j.Wiki;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class ViewedWikiJSONImpl implements ViewedWiki {

    @JsonDeserialize(as = WikiJSONImpl.class)
    private Wiki page;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public Wiki getPage() {
        return page;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }
}
