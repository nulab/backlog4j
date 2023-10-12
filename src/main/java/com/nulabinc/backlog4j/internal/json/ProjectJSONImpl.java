package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.Project;
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
    private boolean chartEnabled;
    private boolean subtaskingEnabled;
    private boolean projectLeaderCanEditProjectLeader;
    private String textFormattingRule;
    private boolean archived;
    private long displayOrder;
    private boolean useWiki;
    private boolean useFileSharing;
    private boolean useDevAttributes;
    private boolean useResolvedForChart;
    private boolean useWikiTreeView;
    private boolean useOriginalImageSizeAtWiki;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(this.id);
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
    public boolean isChartEnabled() {
        return chartEnabled;
    }

    @Override
    public boolean isSubtaskingEnabled() {
        return subtaskingEnabled;
    }

    @Override
    public boolean isProjectLeaderCanEditProjectLeader() {
        return projectLeaderCanEditProjectLeader;
    }

    @Override
    public TextFormattingRule getTextFormattingRule() {
        return TextFormattingRule.enumValueOf(textFormattingRule);
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
    public boolean getUseFileSharing() {
        return useFileSharing;
    }

    @Override
    public boolean getUseWiki() {
        return useWiki;
    }

    @Override
    public boolean getUseDevAttributes() {
        return useDevAttributes;
    }

    @Override
    public boolean getUseResolvedForChart() {
        return useResolvedForChart;
    }

    @Override
    public boolean getUseWikiTreeView() {
        return useWikiTreeView;
    }

    @Override
    public boolean getUseOriginalImageSizeAtWiki() {
        return useOriginalImageSizeAtWiki;
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
        return createEqualsBuilder((ProjectJSONImpl) obj).isEquals();
    }

    protected EqualsBuilder createEqualsBuilder(ProjectJSONImpl rhs) {
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.projectKey, rhs.projectKey)
                .append(this.name, rhs.name)
                .append(this.chartEnabled, rhs.chartEnabled)
                .append(this.subtaskingEnabled, rhs.subtaskingEnabled)
                .append(this.textFormattingRule, rhs.textFormattingRule)
                .append(this.archived, rhs.archived)
                .append(this.useFileSharing, rhs.useFileSharing)
                .append(this.useWiki, rhs.useWiki)
                .append(this.useResolvedForChart, rhs.useResolvedForChart)
                .append(this.useWikiTreeView, rhs.useWikiTreeView)
                .append(this.useOriginalImageSizeAtWiki, rhs.useOriginalImageSizeAtWiki)
                .append(this.projectLeaderCanEditProjectLeader, rhs.projectLeaderCanEditProjectLeader)
                .append(this.useDevAttributes, rhs.useDevAttributes);
    }

    @Override
    public int hashCode() {
        return createHashCodeBuilder().toHashCode();
    }

    protected HashCodeBuilder createHashCodeBuilder() {
        return new HashCodeBuilder()
                .append(id)
                .append(projectKey)
                .append(name)
                .append(chartEnabled)
                .append(subtaskingEnabled)
                .append(textFormattingRule)
                .append(archived)
                .append(useFileSharing)
                .append(useWiki)
                .append(useResolvedForChart)
                .append(useWikiTreeView)
                .append(useOriginalImageSizeAtWiki)
                .append(projectLeaderCanEditProjectLeader)
                .append(useDevAttributes);
    }

    @Override
    public String toString() {
        return createToStringBuilder().toString();
    }

    protected ToStringBuilder createToStringBuilder() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("projectKey", projectKey)
                .append("name", name)
                .append("chartEnabled", chartEnabled)
                .append("subtaskingEnabled", subtaskingEnabled)
                .append("textFormattingRule", textFormattingRule)
                .append("archived", archived)
                .append("useFileSharing", useFileSharing)
                .append("useWiki", useWiki)
                .append("useResolvedForChart", useResolvedForChart)
                .append("useWikiTreeView", useWikiTreeView)
                .append("useOriginalImageSizeAtWiki", useOriginalImageSizeAtWiki)
                .append("projectLeaderCanEditProjectLeader", projectLeaderCanEditProjectLeader)
                .append("useDevAttributes", useDevAttributes);
    }
}
