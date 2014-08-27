package com.nulabinc.backlog4j;

/**
 * The interface for Backlog custom filed setting data.
 *
 * @author nulab-inc
 */
public interface CustomFieldSetting extends CustomField{

    String getDescription();

    boolean isRequired();

    long[] getApplicableIssueTypes();
}
