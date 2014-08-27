package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Content;
import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.Revision;
import com.nulabinc.backlog4j.internal.json.RepositoryJSONImpl;
import com.nulabinc.backlog4j.internal.json.RevisionJSONImpl;

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
}
