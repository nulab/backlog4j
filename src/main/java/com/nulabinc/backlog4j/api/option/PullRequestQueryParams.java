package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.PullRequest;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for pull request query.
 *
 * @author nulab-inc
 */
public class PullRequestQueryParams extends QueryParams{

    public PullRequestQueryParams statusType(List<PullRequest.StatusType> statusType) {
        for (PullRequest.StatusType type : statusType) {
            parameters.add(new NameValuePair("statusId[]", String.valueOf(type.getIntValue())));
        }
        return this;
    }
    @Override
    public PullRequestQueryParams minId(long minId) {
        return (PullRequestQueryParams)super.minId(minId);
    }

    public PullRequestQueryParams maxId(long maxId) {
        return (PullRequestQueryParams)super.maxId(maxId);
    }

    public PullRequestQueryParams count(int count) {
        return (PullRequestQueryParams)super.count(count);
    }

    public PullRequestQueryParams order(Order order) {
        return (PullRequestQueryParams)super.order(order);
    }
}
