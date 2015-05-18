package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog notification data.
 *
 * @author nulab-inc
 */
public interface Notification {

    enum Reason {
        Undefined(-1), Assigned(1), Commented(2), IssueCreated(3), IssueUpdated(4),
        FileAttached(5), ProjectUserAdded(6), Other(9),
        PullRequestAssigned(10), PullRequestCommented(11), PullRequestMerged(12);

        Reason(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static Reason valueOf(final int anIntValue) {
            for (Reason d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return Undefined;
        }

        private int intValue;
    }


    long getId();

    boolean isAlreadyRead();

    Reason getReason();

    boolean isResourceAlreadyRead();

    User getSender();

    User getUser();

    Project getProject();

    Issue getIssue();

    IssueComment getComment();

    Date getCreated();

}
