package com.nulabinc.backlog4j.internal.json;

/**
 * @author nulab-inc
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.IssueType;
import com.nulabinc.backlog4j.Project;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueTypeJSONImpl implements IssueType {

    private long id;
    private long projectId;
    private String name;
    private String color;
    private String templateSummary;
    private String templateDescription;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(this.id);
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
    public String getName() {
        return this.name;
    }

    @Override
    public Project.IssueTypeColor getColor() {
        return Project.IssueTypeColor.strValueOf(this.color);
    }

    @Override
    public String getTemplateSummary() {
        return this.templateSummary;
    }

    @Override
    public String getTemplateDescription() {
        return this.templateDescription;
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
        IssueTypeJSONImpl rhs = (IssueTypeJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.projectId, rhs.projectId)
                .append(this.name, rhs.name)
                .append(this.color, rhs.color)
                .append(this.templateSummary, rhs.templateSummary)
                .append(this.templateDescription, rhs.templateDescription)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(projectId)
                .append(name)
                .append(color)
                .append(templateSummary)
                .append(templateDescription)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("projectId", projectId)
                .append("name", name)
                .append("color", color)
                .append("templateSummary", templateSummary)
                .append("templateDescription", templateDescription)
                .toString();
    }
}
