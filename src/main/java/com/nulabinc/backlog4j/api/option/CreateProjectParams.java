package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for create project API.
 *
 * @author nulab-inc
 */
public class CreateProjectParams extends PostParams {

    public CreateProjectParams(String name,
                               String projectKey,
                               boolean chartEnabled,
                               boolean useResolvedForChart,
                               boolean subtaskingEnabled,
                               boolean projectLeaderCanEditProjectLeader,
                               boolean useWiki,
                               boolean useFileSharing,
                               boolean useWikiTreeView,
                               boolean useSubversion,
                               boolean useGit,
                               boolean useOriginalImageSizeAtWiki,
                               Project.TextFormattingRule textFormattingRule,
                               boolean useDevAttributes){
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("key", projectKey));
        parameters.add(new NameValuePair("chartEnabled", String.valueOf(chartEnabled)));
        parameters.add(new NameValuePair("useResolvedForChart", String.valueOf(useResolvedForChart)));
        parameters.add(new NameValuePair("subtaskingEnabled", String.valueOf(subtaskingEnabled)));
        parameters.add(new NameValuePair("projectLeaderCanEditProjectLeader", String.valueOf(projectLeaderCanEditProjectLeader)));
        parameters.add(new NameValuePair("useWiki", String.valueOf(useWiki)));
        parameters.add(new NameValuePair("useFileSharing", String.valueOf(useFileSharing)));
        parameters.add(new NameValuePair("useWikiTreeView", String.valueOf(useWikiTreeView)));
        parameters.add(new NameValuePair("useSubversion", String.valueOf(useSubversion)));
        parameters.add(new NameValuePair("useGit", String.valueOf(useGit)));
        parameters.add(new NameValuePair("useOriginalImageSizeAtWiki", String.valueOf(useOriginalImageSizeAtWiki)));
        parameters.add(new NameValuePair("textFormattingRule", textFormattingRule.getStrValue()));
        parameters.add(new NameValuePair("useDevAttributes", String.valueOf(useDevAttributes)));
    }
}
