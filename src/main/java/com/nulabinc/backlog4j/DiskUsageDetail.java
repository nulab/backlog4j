package com.nulabinc.backlog4j;

/**
 * The interface for Backlog disk usage data.
 *
 * @author nulab-inc
 */
public interface DiskUsageDetail {
    long getProjectId();

    long getIssue();

    long getWiki();

    long getFile();

    long getSubversion();

    long getGit();

}
