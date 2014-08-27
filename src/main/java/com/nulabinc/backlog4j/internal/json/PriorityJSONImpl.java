package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Priority;

/**
 * @author nulab-inc
 */
public class PriorityJSONImpl implements Priority {

    private int id;
    private String name;


    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Issue.PriorityType getPriority() {
        return Issue.PriorityType.valueOf(this.id);
    }


}
