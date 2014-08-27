package com.nulabinc.backlog4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The interface for Backlog issue data.
 *
 * @author nulab-inc
 */
public interface Issue {
    enum StatusType {
        Open(1), InProgress(2), Resolved(3), Closed(4);

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

    enum ResolutionType {
        Fixed(0), WontFix(1), Invalid(2), Duplication(3), CannotReproduce(4);

        ResolutionType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static ResolutionType valueOf(final int anIntValue) {
            for (ResolutionType d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return null;
        }

        private int intValue;
    }


    enum PriorityType {
        High(2), Normal(3), Low(4);

        PriorityType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static PriorityType valueOf(final int anIntValue) {
            for (PriorityType d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return null;
        }

        private int intValue;
    }

    long getId();

    String getIssueKey();

    long getKeyId();

    long getProjectId();

    IssueType getIssueType();

    String getSummary();

    String getDescription();

    Resolution getResolution();

    Priority getPriority();

    Status getStatus();

    User getAssignee();

    List<Category> getCategory();

    List<Version> getVersions();

    List<Milestone> getMilestone();

    Date getStartDate();

    Date getLimitDate();

    Date getDueDate();

    BigDecimal getEstimatedHours();

    BigDecimal getActualHours();

    long getParentIssueId();

    User getCreatedUser();

    Date getCreated();

    User getUpdatedUser();

    Date getUpdated();

    List<CustomField> getCustomFields();

    List<Attachment> getAttachments();

    List<SharedFile> getSharedFiles();

    List<Star> getStars();
}
