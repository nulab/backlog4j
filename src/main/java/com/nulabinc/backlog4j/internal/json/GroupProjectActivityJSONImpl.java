package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class GroupProjectActivityJSONImpl implements GroupProjectActivity {

    private long id;
    private int type;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Activity.Type getType() {
        return Activity.Type.valueOf(this.type);
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof GroupProjectActivity ) {
            GroupProjectActivity other = (GroupProjectActivity)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("type", type)
                .toString();
    }
}
