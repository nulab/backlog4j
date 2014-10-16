package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.NotificationInfo;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class NotificationInfoJSONImpl implements NotificationInfo {

    private String type;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof NotificationInfo) {
            NotificationInfo other = (NotificationInfo)obj;
            result = new EqualsBuilder().append( type, other.getType() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .toString();
    }
}
