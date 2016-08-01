package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.*;

/**
 * Executes Backlog User APIs.
 *
 * @author nulab-inc
 */
public interface UserMethods {

    /**
     * Returns all the users in the space.
     *
     * @return the users in a list
     * @throws BacklogException
     */
    ResponseList<User> getUsers() throws BacklogException;

    /**
     * Returns the user in the space.
     *
     * @param numericUserId the user identifier
     * @return the User
     * @throws BacklogException
     */
    User getUser(Object numericUserId) throws BacklogException;

    /**
     * Creates a user in the space.
     *
     * @param params the creating user parameter
     * @return the created user
     * @throws BacklogException
     */
    User createUser(CreateUserParams params) throws BacklogException;

    /**
     * Deletes the user in space.
     *
     * @param numericUserId the user identifier
     * @return the deleted user
     * @throws BacklogException
     */
    User deleteUser(Object numericUserId) throws BacklogException;

    /**
     * Returns the own information.
     *
     * @return the User
     * @throws BacklogException
     */
    User getMyself() throws BacklogException;

    /**
     * Returns the user icon.
     *
     * @param numericUserId the user identifier
     * @return the Icon
     * @throws BacklogException
     */
    Icon getUserIcon(Object numericUserId) throws BacklogException;

    /**
     * Returns the user recently updates
     *
     * @param numericUserId the user identifier
     * @return the updates in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getUserActivities(Object numericUserId) throws BacklogException;

    /**
     * Returns the user recently updates
     *
     * @param numericUserId the user identifier
     * @param queryParams the query parameters
     * @return the updates in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getUserActivities(Object numericUserId, ActivityQueryParams queryParams) throws BacklogException;

    /**
     * Returns the received stars
     *
     * @param numericUserId the user identifier
     * @return the stars in a list
     * @throws BacklogException
     */
    ResponseList<Star> getUserStars(Object numericUserId) throws BacklogException;

    /**
     * Returns the received stars
     *
     * @param numericUserId the user identifier
     * @param queryParams the query parameters
     * @return the stars in a list
     * @throws BacklogException
     */
    ResponseList<Star> getUserStars(Object numericUserId, QueryParams queryParams) throws BacklogException;

    /**
     * Returns the received star count
     *
     * @param numericUserId the user identifier
     * @param params star count parameters
     * @return the count of received star
     * @throws BacklogException
     */
    int getUserStarCount(Object numericUserId, GetStarsParams params) throws BacklogException;

    /**
     * Returns the recently viewed issues
     *
     * @return the issues in a list
     * @throws BacklogException
     */
    ResponseList<ViewedIssue> getRecentlyViewedIssues() throws BacklogException;

    /**
     * Returns the recently viewed issues
     *
     * @param params the offset parameters
     * @return the issues in a list
     * @throws BacklogException
     */
    ResponseList<ViewedIssue> getRecentlyViewedIssues(OffsetParams params) throws BacklogException;

    /**
     * Returns the recently viewed projects
     *
     * @return the projects in a list
     * @throws BacklogException
     */
    ResponseList<ViewedProject> getRecentlyViewedProjects() throws BacklogException;

    /**
     * Returns the recently viewed projects
     *
     * @param params the offset parameters
     * @return the projects in a list
     * @throws BacklogException
     */
    ResponseList<ViewedProject> getRecentlyViewedProjects(OffsetParams params) throws BacklogException;

    /**
     * Returns the recently viewed wikis
     *
     * @return the wikis in a list
     * @throws BacklogException
     */
    ResponseList<ViewedWiki> getRecentlyViewedWikis() throws BacklogException;

    /**
     * Returns the recently viewed wikis
     *
     * @param params the offset parameters
     * @return the wikis in a list
     * @throws BacklogException
     */
    ResponseList<ViewedWiki> getRecentlyViewedWikis(OffsetParams params) throws BacklogException;

    /**
     * Returns the received watch count
     *
     * @param numericUserId the user identifier
     * @param params watch count parameters
     * @return the count of received watch
     * @throws BacklogException
     */
    int getUserWatchCount(Object numericUserId, GetWatchesParams params) throws BacklogException;

    /**
     * Returns the received watchings
     *
     * @param numericUserId the user identifier
     * @return the watchings in a list
     * @throws BacklogException
     */
    ResponseList<Watch> getUserWatches(Object numericUserId) throws BacklogException;

}
