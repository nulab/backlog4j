package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DiskUsage;
import com.nulabinc.backlog4j.DiskUsageDetail;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiskUsageJSONImpl implements DiskUsage {
    private long capacity;
    private long issue;
    private long wiki;
    private long file;
    private long subversion;
    private long git;
    @JsonDeserialize(as = DiskUsageDetailJSONImpl[].class)
    private DiskUsageDetail[] details;


    @Override
    public long getCapacity() {
        return capacity;
    }

    @Override
    public long getIssue() {
        return issue;
    }

    @Override
    public long getWiki() {
        return wiki;
    }

    @Override
    public long getFile() {
        return file;
    }

    @Override
    public long getSubversion() {
        return subversion;
    }

    @Override
    public long getGit() {
        return git;
    }

    @Override
    public List<DiskUsageDetail> getDetails() {
        return Arrays.asList(details);
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
        DiskUsageJSONImpl rhs = (DiskUsageJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.capacity, rhs.capacity)
                .append(this.issue, rhs.issue)
                .append(this.wiki, rhs.wiki)
                .append(this.file, rhs.file)
                .append(this.subversion, rhs.subversion)
                .append(this.git, rhs.git)
                .append(this.details, rhs.details)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(capacity)
                .append(issue)
                .append(wiki)
                .append(file)
                .append(subversion)
                .append(git)
                .append(details)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("capacity", capacity)
                .append("issue", issue)
                .append("wiki", wiki)
                .append("file", file)
                .append("subversion", subversion)
                .append("git", git)
                .append("details", details)
                .toString();
    }
}
