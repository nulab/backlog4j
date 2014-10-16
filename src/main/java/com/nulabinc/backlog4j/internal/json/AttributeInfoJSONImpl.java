package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.AttributeInfo;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class AttributeInfoJSONImpl implements AttributeInfo {

    private long id;
    private String typeId;;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getTypeId() {
        return typeId;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof AttributeInfo) {
            AttributeInfo other = (AttributeInfo)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("typeId", typeId)
                .toString();
    }
}
