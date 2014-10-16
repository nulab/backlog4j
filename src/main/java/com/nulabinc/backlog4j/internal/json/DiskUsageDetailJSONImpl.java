package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.DiskUsageDetail;
import com.nulabinc.backlog4j.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
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
    public boolean equals(Object obj){
        boolean result = false;
        if( obj instanceof DiskUsageDetail) {
            DiskUsageDetail other = (DiskUsageDetail)obj;
            result = new EqualsBuilder().append( projectId, other.getProjectId() )
                    .isEquals();
        }
        return result;
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
