package com.nulabinc.backlog4j.internal.json.activities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Content;
import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.internal.json.RepositoryJSONImpl;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
public class GitRepositoryCreatedContent extends Content {


    @JsonDeserialize(as=RepositoryJSONImpl.class)
    private Repository repository;

    public Repository getRepository() {
        return repository;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("repository", repository)
                .toString();
    }
}
