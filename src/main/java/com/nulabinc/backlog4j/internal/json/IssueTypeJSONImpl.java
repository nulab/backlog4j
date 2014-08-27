package com.nulabinc.backlog4j.internal.json;

/**
 * @author nulab-inc
 */

import com.nulabinc.backlog4j.IssueType;
import com.nulabinc.backlog4j.Project;

/**
 * @author nulab-inc
 */
public class IssueTypeJSONImpl implements IssueType {

    private long id;
    private long projectId;
    private String name;
    private String color;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public long getProjectId() {
        return this.projectId;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Project.IssueTypeColor getColor() {
        return Project.IssueTypeColor.strValueOf(this.color);
    }


    @Override
    public String toString() {
        return "ProjectJSONImpl extends " + super.toString();
    }


}
