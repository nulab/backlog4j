package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Content;
import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.internal.json.RepositoryJSONImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryCreatedContent extends Content {


    @JsonDeserialize(as = RepositoryJSONImpl.class)
    private Repository repository;

    public Repository getRepository() {
        return repository;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        GitRepositoryCreatedContent rhs = (GitRepositoryCreatedContent) obj;
        return new EqualsBuilder()
                .append(this.repository, rhs.repository)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(repository)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("repository", repository)
                .toString();
    }
}
