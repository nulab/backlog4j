package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.SpaceNotification;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        SpaceNotificationJSONImpl rhs = (SpaceNotificationJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.content, rhs.content)
                .append(this.updated, rhs.updated)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(content)
                .append(updated)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("content", content)
                .append("updated", updated)
                .toString();
    }
}
