package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Milestone;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MilestoneJSONImpl implements Milestone {

    private long id;
    private long projectId;
    private String name;
    private String description;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date startDate;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
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

    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getReleaseDueDate() {
        return releaseDueDate;
    }

    public Boolean getArchived() {
        return archived;
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
        MilestoneJSONImpl rhs = (MilestoneJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.projectId, rhs.projectId)
                .append(this.name, rhs.name)
                .append(this.description, rhs.description)
                .append(this.startDate, rhs.startDate)
                .append(this.releaseDueDate, rhs.releaseDueDate)
                .append(this.archived, rhs.archived)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(projectId)
                .append(name)
                .append(description)
                .append(startDate)
                .append(releaseDueDate)
                .append(archived)
                .toHashCode();
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
