package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for get issue API.
 *
 * @author nulab-inc
 */
public class GetIssueParams extends GetParams {

    public GetIssueParams expand(List<Issue.Expand> expands) {
        for (Issue.Expand expand : expands) {
            parameters.add(new NameValuePair("expand[]", expand.getStrValue()));
        }
        return this;
    }
}
