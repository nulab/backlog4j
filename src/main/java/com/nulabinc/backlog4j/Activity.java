package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog activity data.
 *
 * @author nulab-inc
 */
public interface Activity {

    enum Type {
        NotDefined(-1), IssueCreated(1), IssueUpdated(2), IssueCommented(3), IssueDeleted(4),
        WikiCreated(5), WikiUpdated(6), WikiDeleted(7),
        FileAdded(8), FileUpdated(9), FileDeleted(10),
        SvnCommitted(11), GitPushed(12), GitRepositoryCreated(13),
        IssueMultiUpdated(14), ProjectUserAdded(15), ProjectUserRemoved(16);

        Type(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static Type valueOf(final int anIntValue) {
            for (Type d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return null;
        }

        private int intValue;
    }

    long getId();

    Project getProject();

    Type getType();

    Content getContent();

    User getCreatedUser();

    Date getCreated();
}
