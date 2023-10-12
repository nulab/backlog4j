package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update project API.
 *
 * @author nulab-inc
 */
public class UpdateProjectParams extends PatchParams {
    private Object projectIdOrKey;

    public UpdateProjectParams(Object projectIdOrKey) {
        this.projectIdOrKey = projectIdOrKey;
    }

    public String getProjectIdOrKeyString() {
        return projectIdOrKey.toString();
    }

    public UpdateProjectParams name(String name) {
        parameters.add(new NameValuePair("name", String.valueOf(name)));
        return this;
    }

    public UpdateProjectParams projectKey(String projectKey) {
        parameters.add(new NameValuePair("key", projectKey));
        return this;
    }

    public UpdateProjectParams chartEnabled(boolean chartEnabled) {
        parameters.add(new NameValuePair("chartEnabled", String.valueOf(chartEnabled)));
        return this;
    }

    public UpdateProjectParams resolvedForChartEnabled(boolean resolvedForChartEnabled) {
        parameters.add(new NameValuePair("useResolvedForChart", String.valueOf(resolvedForChartEnabled)));
        return this;
    }

    public UpdateProjectParams subtaskingEnabled(boolean subtaskingEnabled) {
        parameters.add(new NameValuePair("subtaskingEnabled", String.valueOf(subtaskingEnabled)));
        return this;
    }

    public UpdateProjectParams projectLeaderCanEditProjectLeader(boolean projectLeaderCanEditProjectLeader) {
        parameters.add(new NameValuePair("projectLeaderCanEditProjectLeader", String.valueOf(projectLeaderCanEditProjectLeader)));
        return this;
    }

    public UpdateProjectParams wikiEnabled(boolean wikiEnabled) {
        parameters.add(new NameValuePair("useWiki", String.valueOf(wikiEnabled)));
        return this;
    }

    public UpdateProjectParams fileSharingEnabled(boolean fileSharingEnabled) {
        parameters.add(new NameValuePair("useFileSharing", String.valueOf(fileSharingEnabled)));
        return this;
    }

    public UpdateProjectParams wikiTreeViewEnabled(boolean wikiTreeViewEnabled) {
        parameters.add(new NameValuePair("useWikiTreeView", String.valueOf(wikiTreeViewEnabled)));
        return this;
    }

    public UpdateProjectParams subversionEnabled(boolean subversionEnabled) {
        parameters.add(new NameValuePair("useSubversion", String.valueOf(subversionEnabled)));
        return this;
    }

    public UpdateProjectParams gitEnabled(boolean gitEnabled) {
        parameters.add(new NameValuePair("useGit", String.valueOf(gitEnabled)));
        return this;
    }

    public UpdateProjectParams originalImageSizeAtWikiEnabled(boolean originalImageSizeAtWikiEnabled) {
        parameters.add(new NameValuePair("useOriginalImageSizeAtWiki", String.valueOf(originalImageSizeAtWikiEnabled)));
        return this;
    }

    public UpdateProjectParams textFormattingRule(Project.TextFormattingRule textFormattingRule) {
        parameters.add(new NameValuePair("textFormattingRule", textFormattingRule.getStrValue()));
        return this;
    }

    public UpdateProjectParams devAttributesEnabled(boolean devAttributesEnabled) {
        parameters.add(new NameValuePair("useDevAttributes", String.valueOf(devAttributesEnabled)));
        return this;
    }

    public UpdateProjectParams setArchived(boolean archived) {
        parameters.add(new NameValuePair("archived", String.valueOf(archived)));
        return this;
    }
}
