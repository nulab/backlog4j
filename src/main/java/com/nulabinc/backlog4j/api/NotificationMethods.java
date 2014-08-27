package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Notification;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.api.option.GetNotificationCountParams;
import com.nulabinc.backlog4j.api.option.QueryParams;

/**
 * Executes Backlog Notification APIs.
 *
 * @author nulab-inc
 */
public interface NotificationMethods {

    /**
     * Returns the notifications.
     *
     * @return the notifications in a list.
     * @throws BacklogException
     */
    ResponseList<Notification> getNotifications() throws BacklogException;

    /**
     * Returns the notifications.
     *
     * @param params the query parameters
     * @return the notifications in a list.
     * @throws BacklogException
     */
    ResponseList<Notification> getNotifications(QueryParams params) throws BacklogException;

    //お知らせ数の取得

    /**
     * Returns the count of the notifications.
     *
     * @param params the notification parameters
     * @return the count of the notifications
     * @throws BacklogException
     */
    int getNotificationCount(GetNotificationCountParams params) throws BacklogException;

    /**
     * Resets the count of the notifications.
     *
     * @return the count of the reset notifications
     * @throws BacklogException
     */
    int resetNotificationCount() throws BacklogException;

    /**
     * Marks the notification as already read.
     *
     * @param notificationId the notification identifier
     * @throws BacklogException
     */
    void markAsReadNotification(long notificationId) throws BacklogException;


}
