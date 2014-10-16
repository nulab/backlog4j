package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Status;
import com.nulabinc.backlog4j.Version;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class VersionJSONImpl implements Version {

    private long id;
    private long projectId;
    private String name;
    private String description;
    private Date startDate;
    private Date releaseDueDate;
    private Boolean archived;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getProjectId() {
        return projectId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getReleaseDueDate() {
        return releaseDueDate;
    }

    @Override
    public Boolean getArchived() {
        return archived;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Version) {
            Version other = (Version)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("projectId", projectId)
                .append("name", name)
                .append("description", description)
                .append("startDate", startDate)
                .append("releaseDueDate", releaseDueDate)
                .append("archived", archived)
                .toString();
    }
}
