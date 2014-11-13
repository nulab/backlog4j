package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectJSONImpl implements Project {

    private long id;
    private String projectKey;
    private String name;
    private boolean useGantt;
    private boolean useBurndown;
    private boolean chartEnabled;
    private boolean subtaskingEnabled;
    private String textFormattingRule;
    private boolean archived;
    private long displayOrder;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getProjectKey() {
        return projectKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isUseGantt() {
        return useGantt;
    }

    @Override
    public boolean isUseBurndown() {
        return useBurndown;
    }

    @Override
    public boolean isChartEnabled() {
        return chartEnabled;
    }

    @Override
    public boolean isSubtaskingEnabled() {
        return subtaskingEnabled;
    }

    @Override
    public String getTextFormattingRule() {
        return textFormattingRule;
    }

    @Override
    public boolean isArchived() {
        return archived;
    }

    @Override
    public long getDisplayOrder() {
        return this.displayOrder;
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
        ProjectJSONImpl rhs = (ProjectJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.projectKey, rhs.projectKey)
                .append(this.name, rhs.name)
                .append(this.useGantt, rhs.useGantt)
                .append(this.useBurndown, rhs.useBurndown)
                .append(this.chartEnabled, rhs.chartEnabled)
                .append(this.subtaskingEnabled, rhs.subtaskingEnabled)
                .append(this.textFormattingRule, rhs.textFormattingRule)
                .append(this.archived, rhs.archived)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(projectKey)
                .append(name)
                .append(useGantt)
                .append(useBurndown)
                .append(chartEnabled)
                .append(subtaskingEnabled)
                .append(textFormattingRule)
                .append(archived)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("projectKey", projectKey)
                .append("name", name)
                .append("useGantt", useGantt)
                .append("useBurndown", useBurndown)
                .append("chartEnabled", chartEnabled)
                .append("subtaskingEnabled", subtaskingEnabled)
                .append("textFormattingRule", textFormattingRule)
                .append("archived", archived)
                .toString();
    }
}
