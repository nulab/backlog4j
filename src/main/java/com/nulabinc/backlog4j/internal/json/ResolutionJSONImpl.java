package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Resolution;

/**
 * @author nulab-inc
 */
public class ResolutionJSONImpl implements Resolution {

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
    public Issue.ResolutionType getResolution() {
        return Issue.ResolutionType.valueOf(this.id);
    }




}
