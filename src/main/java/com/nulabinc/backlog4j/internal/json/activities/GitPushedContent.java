package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Content;
import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.Revision;
import com.nulabinc.backlog4j.internal.json.RepositoryJSONImpl;
import com.nulabinc.backlog4j.internal.json.RevisionJSONImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
public class GitPushedContent extends Content {

    @JsonProperty("change_type")
    private String changeType;
    private String ref;
    @JsonProperty("revision_type")
    private String revisionType;
    @JsonDeserialize(as=RepositoryJSONImpl.class)
    private Repository repository;
    @JsonDeserialize(as=RevisionJSONImpl[].class)
    private Revision[] revisions;
    @JsonProperty("revision_count")
    private long revisionCount;

    public String getChangeType() {
        return changeType;
    }

    public String getRef() {
        return ref;
    }

    public String getRevisionType() {
        return revisionType;
    }

    public Repository getRepository() {
        return repository;
    }

    public List<Revision> getRevisions() {
        return Arrays.asList(revisions);
    }

    public long getRevisionCount() {
        return revisionCount;
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
        GitPushedContent rhs = (GitPushedContent) obj;
        return new EqualsBuilder()
                .append(this.changeType, rhs.changeType)
                .append(this.ref, rhs.ref)
                .append(this.revisionType, rhs.revisionType)
                .append(this.repository, rhs.repository)
                .append(this.revisions, rhs.revisions)
                .append(this.revisionCount, rhs.revisionCount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(changeType)
                .append(ref)
                .append(revisionType)
                .append(repository)
                .append(revisions)
                .append(revisionCount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("changeType", changeType)
                .append("ref", ref)
                .append("revisionType", revisionType)
                .append("repository", repository)
                .append("revisions", revisions)
                .append("revisionCount", revisionCount)
                .toString();
    }
}
