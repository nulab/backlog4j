package com.nulabinc.backlog4j.internal.json;

/**
 * @author nulab-inc
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.Count;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountJSONImpl implements Count {

    private int count;

    public int getCount() {
        return count;
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
        CountJSONImpl rhs = (CountJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.count, rhs.count)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(count)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("count", count)
                .toString();
    }
}
