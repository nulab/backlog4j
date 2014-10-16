package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.Status;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class StatusJSONImpl implements Status {

    private int id;
    private String name;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Issue.StatusType getStatus() {
        return Issue.StatusType.valueOf(this.id);
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Status) {
            Status other = (Status)obj;
            result = new EqualsBuilder().append( id, other.getId() )
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
