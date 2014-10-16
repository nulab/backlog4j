package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
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
     public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Project) {
            Project other = (Project)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
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
