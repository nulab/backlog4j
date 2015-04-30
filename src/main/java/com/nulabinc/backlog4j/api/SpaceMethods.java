package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.ActivityQueryParams;
import com.nulabinc.backlog4j.api.option.QueryParams;

/**
 * Executes Backlog Space APIs.
 *
 * @author nulab-inc
 */
public interface SpaceMethods {

    /**
     * Returns the Space.
     *
     * @return the Space
     * @throws BacklogException
     */
    Space getSpace() throws BacklogException;

    /**
     * Returns the activities in the space.
     *
     * @return the activities in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getSpaceActivities() throws BacklogException;

    /**
     * Returns the activities in the space.
     *
     * @param params the query parameters
     * @return the activities in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getSpaceActivities(ActivityQueryParams params) throws BacklogException;

    /**
     * Returns the space icon.
     *
     * @return the Icon
     * @throws BacklogException
     */
    Icon getSpaceIcon() throws BacklogException;

    /**
     * Returns the endpoint of space icon.
     *
     * @return the endpoint
     * @throws BacklogException
     */
    String getSpaceIconEndpoint() throws BacklogException;

    /**
     * Returns the space information.
     *
     * @return the SpaceNotification
     * @throws BacklogException
     */
    SpaceNotification getSpaceNotification() throws BacklogException;

    /**
     * Updates the space information.
     *
     * @param content information
     * @return the updated space information
     * @throws BacklogException
     */
    SpaceNotification updateSpaceNotification(String content) throws BacklogException;

    /**
     * Returns the disk usage of the project.
     *
     * @return the DiskUsage
     * @throws BacklogException
     */
    DiskUsage getSpaceDiskUsage() throws BacklogException;

    /**
     * Posts the attachment file for issue or wiki.
     *
     * @param attachmentData the attachment file data
     * @return the posted attachment file
     * @throws BacklogException
     */
    Attachment postAttachment(AttachmentData attachmentData) throws BacklogException;

}
