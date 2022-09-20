package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.DiskUsageDetail;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiskUsageDetailJSONImpl implements DiskUsageDetail {
    private long projectId;

    private long issue;
    private long wiki;
    private long file;
    private long subversion;
    private long git;

    @Override
    public long getProjectId() {
        return projectId;
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
        DiskUsageDetailJSONImpl rhs = (DiskUsageDetailJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.projectId, rhs.projectId)
                .append(this.issue, rhs.issue)
                .append(this.wiki, rhs.wiki)
                .append(this.file, rhs.file)
                .append(this.subversion, rhs.subversion)
                .append(this.git, rhs.git)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(projectId)
                .append(issue)
                .append(wiki)
                .append(file)
                .append(subversion)
                .append(git)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("projectId", projectId)
                .append("issue", issue)
                .append("wiki", wiki)
                .append("file", file)
                .append("subversion", subversion)
                .append("git", git)
                .toString();
    }
}
