package com.nulabinc.backlog4j;

import java.util.List;

/**
 * The interface for Backlog custom filed setting data.
 *
 * @author nulab-inc
 */
public interface CustomFieldSetting extends CustomField {

    String getDescription();

    boolean isRequired();

    long[] getApplicableIssueTypes();

    List<? extends CustomFieldListItemSetting> getItems();
}
