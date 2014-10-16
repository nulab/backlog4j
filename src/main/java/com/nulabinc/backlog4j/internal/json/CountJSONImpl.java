package com.nulabinc.backlog4j.internal.json;

/**
 * @author nulab-inc
 */

import com.nulabinc.backlog4j.Count;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class CountJSONImpl implements Count {

    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof User) {
            Count other = (Count)obj;
            result = new EqualsBuilder().append( count, other.getCount() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("count", count)
                .toString();
    }
}
