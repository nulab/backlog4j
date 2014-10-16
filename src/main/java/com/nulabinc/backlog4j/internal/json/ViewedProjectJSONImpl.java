package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.ViewedProject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof ViewedProject) {
            ViewedProject other = (ViewedProject)obj;
            result = new EqualsBuilder().append( project.getId(), other.getProject().getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("project", project)
                .append("updated", updated)
                .toString();
    }
}
