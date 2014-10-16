package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.ViewedWiki;
import com.nulabinc.backlog4j.Wiki;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof ViewedWiki) {
            ViewedWiki other = (ViewedWiki)obj;
            result = new EqualsBuilder().append( page.getId(), other.getPage().getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("page", page)
                .append("updated", updated)
                .toString();
    }
}
