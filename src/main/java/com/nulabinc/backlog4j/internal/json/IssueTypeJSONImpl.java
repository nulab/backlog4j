package com.nulabinc.backlog4j.internal.json;

/**
 * @author nulab-inc
 */

import com.nulabinc.backlog4j.IssueType;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * @author nulab-inc
 */
public class IssueTypeJSONImpl implements IssueType {

    private long id;
    private long projectId;
    private String name;
    private String color;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public long getProjectId() {
        return this.projectId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Project.IssueTypeColor getColor() {
        return Project.IssueTypeColor.strValueOf(this.color);
    }


    @Override
    public String toString() {
        return "ProjectJSONImpl extends " + super.toString();
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof IssueType) {
            IssueType other = (IssueType)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }


}
