package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class RepositoryJSONImpl implements Repository {

    private int id;
    private long projectId;
    private String name;
    private String description;
    private String hookUrl;
    private String httpUrl;
    private String sshUrl;
    private long displayOrder;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date pushedAt;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User updatedUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public long getId() {
        return this.id;
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
    public long getProjectId() {
        return projectId;
    }

    @Override
    public String getHookUrl() {
        return hookUrl;
    }

    @Override
    public String getHttpUrl() {
        return httpUrl;
    }

    @Override
    public String getSshUrl() {
        return sshUrl;
    }

    @Override
    public long getDisplayOrder() {
        return displayOrder;
    }

    @Override
    public Date getPushedAt() {
        return pushedAt;
    }

    @Override
    public User getCreatedUser() {
        return createdUser;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public User getUpdatedUser() {
        return updatedUser;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof Repository ) {
            Repository other = (Repository)obj;
            result = new EqualsBuilder().append( id, other.getId() )
                    .isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("projectId", projectId)
                .append("name", name)
                .append("description", description)
                .append("hookUrl", hookUrl)
                .append("httpUrl", httpUrl)
                .append("sshUrl", sshUrl)
                .append("displayOrder", displayOrder)
                .append("pushedAt", pushedAt)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updatedUser", updatedUser)
                .append("updated", updated)
                .toString();
    }
}
