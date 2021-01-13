package com.nulabinc.backlog4j;

/**
 * The interface for Backlog issue type data.
 *
 * @author nulab-inc
 */
public interface IssueType {

    long getId();

    String getIdAsString();

    long getProjectId();

    String getProjectIdAsString();

    String getName();

    Project.IssueTypeColor getColor();

    String getTemplateSummary();

    String getTemplateDescription();
}
