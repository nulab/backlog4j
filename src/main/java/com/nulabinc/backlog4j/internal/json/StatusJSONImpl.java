package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Status;

/**
 * @author nulab-inc
 */
public class StatusJSONImpl implements Status {

    private int id;
    private String name;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Issue.StatusType getStatus() {
        return Issue.StatusType.valueOf(this.id);
    }


}
