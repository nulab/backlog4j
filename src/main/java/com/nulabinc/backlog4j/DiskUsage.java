package com.nulabinc.backlog4j;

import java.util.List;

/**
 * The interface for Backlog disk usage data.
 *
 * @author nulab-inc
 */
public interface DiskUsage {
    long getCapacity();

    long getIssue();

    long getWiki();

    long getFile();

    long getSubversion();

    long getGit();

    List<DiskUsageDetail> getDetails();

}
