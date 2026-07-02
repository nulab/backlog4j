package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.ChildIssueSummary;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildIssueSummaryJSONImpl implements ChildIssueSummary {

    private long total;
    private long closed;

    @Override
    public long getTotal() {
        return total;
    }

    @Override
    public long getClosed() {
        return closed;
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
        ChildIssueSummaryJSONImpl rhs = (ChildIssueSummaryJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.total, rhs.total)
                .append(this.closed, rhs.closed)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(total)
                .append(closed)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("total", total)
                .append("closed", closed)
                .toString();
    }
}
