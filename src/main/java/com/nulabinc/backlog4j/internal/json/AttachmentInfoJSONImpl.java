package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.AttachmentInfo;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentInfoJSONImpl implements AttachmentInfo {

    private long id;
    private String name;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(this.id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isImage() {
        String lowerCase = name.toLowerCase();
        return (lowerCase.endsWith(".jpg") ||
                lowerCase.endsWith(".jpeg") ||
                lowerCase.endsWith(".png") ||
                lowerCase.endsWith(".gif"));
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
        AttachmentInfoJSONImpl rhs = (AttachmentInfoJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
