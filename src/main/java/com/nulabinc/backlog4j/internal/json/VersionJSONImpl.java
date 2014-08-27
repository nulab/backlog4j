package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Version;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class VersionJSONImpl implements Version {

    private long id;
    private long projectId;
    private String name;
    private String description;
    private Date startDate;
    private Date releaseDueDate;
    private Boolean archived;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getProjectId() {
        return projectId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getReleaseDueDate() {
        return releaseDueDate;
    }

    @Override
    public Boolean getArchived() {
        return archived;
    }
}
