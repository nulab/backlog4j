package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.IssueComment;
import com.nulabinc.backlog4j.Notification;
import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.User;
import org.exparity.hamcrest.date.DateMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class NotificationJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createNotificationListTest() throws IOException {
        String fileContentStr = getJsonString("json/notifications.json");
        ResponseList<Notification> notifications = factory.createNotificationList(fileContentStr);

        assertEquals(7, notifications.size());

        Notification notification = notifications.get(0);
        assertEquals(808, notification.getId());
        assertFalse(notification.isAlreadyRead());
        assertEquals(Notification.Reason.IssueCreated, notification.getReason());
        assertTrue(notification.isResourceAlreadyRead());

        Project project = notification.getProject();
        assertEquals(1073761346, project.getId());

        Issue issue = notification.getIssue();
        assertEquals(1073804231, issue.getId());

        IssueComment comment = notification.getComment();
        assertEquals(1073834277, comment.getId());

        User user = notification.getSender();
        assertEquals(1073751781, user.getId());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.AUGUST, 8, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(notification.getCreated()));
    }
}
