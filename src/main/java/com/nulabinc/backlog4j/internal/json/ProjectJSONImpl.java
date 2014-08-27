package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Project;

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
}
