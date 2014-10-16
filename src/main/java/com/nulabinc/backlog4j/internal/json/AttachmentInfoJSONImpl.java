package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.AttachmentInfo;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class AttachmentInfoJSONImpl implements AttachmentInfo {

    private long id;
    private String name;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof AttachmentInfo) {
            AttachmentInfo other = (AttachmentInfo) obj;
            result = new EqualsBuilder().append(id, other.getId())
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
