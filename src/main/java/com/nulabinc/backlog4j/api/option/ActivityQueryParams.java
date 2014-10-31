package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for activities query.
 *
 * @author nulab-inc
 */
public class ActivityQueryParams extends QueryParams{

    public ActivityQueryParams activityType(List<Activity.Type> activityTypes) {
        for (Activity.Type type : activityTypes) {
            parameters.add(new NameValuePair("activityTypeId[]", String.valueOf(type.getIntValue())));
        }
        return this;
    }
    @Override
    public ActivityQueryParams minId(int minId) {
        return (ActivityQueryParams)super.minId(minId);
    }

    public ActivityQueryParams maxId(int maxId) {
        return (ActivityQueryParams)super.maxId(maxId);
    }

    public ActivityQueryParams count(int count) {
        return (ActivityQueryParams)super.count(count);
    }

    public ActivityQueryParams order(Order order) {
        return (ActivityQueryParams)super.order(order);
    }
}
