package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog space data.
 *
 * @author nulab-inc
 */
public interface Space {
    String getSpaceKey();

    String getName();

    long getOwnerId();

    String getOwnerIdAsString();

    String getLang();

    String getTimezone();

    String getReportSendTime();

    String getTextFormattingRule();

    Date getCreated();

    Date getUpdated();

}
