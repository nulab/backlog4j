package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.ViewedProject;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class ViewedProjectJSONImpl implements ViewedProject {

    @JsonDeserialize(as = ProjectJSONImpl.class)
    private Project project;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }
}
