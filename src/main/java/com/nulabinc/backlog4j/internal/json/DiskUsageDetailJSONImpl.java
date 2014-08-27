package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.DiskUsageDetail;

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

}
