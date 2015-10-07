package com.nulabinc.backlog4j;

import java.util.Date;
import java.util.List;

/**
 * Created by yuhkim on 2015/05/18.
 */
public interface PullRequest {

    enum StatusType {
        Open(1), Merged(2), Closed(3);

        StatusType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static StatusType valueOf(final int anIntValue) {
            for (StatusType d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return null;
        }

        private int intValue;
    }

    long getId();

    String getIdAsString();

    long getProjectId();

    String getProjectIdAsString();

    long getRepositoryId();

    String getRepositoryIdAsString();

    long getNumber();

    String getSummary();

    String getDescription();

    String getBase();

    String getBranch();

    PullRequestStatus getStatus();

    User getAssignee();

    Issue getIssue();

    String getMergeCommit();

    String getBaseCommit();

    String getBranchCommit();

    String getCloseAt();

    String getMergeAt();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();

    List<Attachment> getAttachments();

    List<Star> getStars();
}
