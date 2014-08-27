package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DiskUsage;
import com.nulabinc.backlog4j.DiskUsageDetail;

import java.util.Arrays;
import java.util.List;

/**
 * @author nulab-inc
 */
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
}
