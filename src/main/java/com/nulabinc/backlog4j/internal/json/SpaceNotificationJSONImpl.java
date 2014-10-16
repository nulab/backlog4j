package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.SpaceNotification;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class SpaceNotificationJSONImpl implements SpaceNotification {

    private String content;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;


    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof SpaceNotification) {
            SpaceNotification other = (SpaceNotification)obj;
            result = new EqualsBuilder().append( content, other.getContent() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("content", content)
                .append("updated", updated)
                .toString();
    }
}
