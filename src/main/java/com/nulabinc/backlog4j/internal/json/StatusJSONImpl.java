package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.Status;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusJSONImpl implements Status {

    private int id;
    private String name;
    private int displayOrder;
    private long projectId;
    private String color;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(this.id);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Issue.StatusType getStatusType() {
        return Issue.StatusType.valueOf(this.id);
    }

    @Override
    public long getProjectId() {
        return this.projectId;
    }

    @Override
    public String getProjectIdAsString() {
        return String.valueOf(this.projectId);
    }

    @Override
    public Project.CustomStatusColor getColor() { return Project.CustomStatusColor.strValueOf(this.color); }

    @Override
    public int getDisplayOrder() { return this.displayOrder; }

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
        StatusJSONImpl rhs = (StatusJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
