package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.*;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.DateMatchers;

import java.io.IOException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author nulab-inc
 */
public class NotificationJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createNotificationListTest() throws IOException {
        String fileContentStr = getJsonString("json/notifications.json");
        ResponseList<Notification> notifications = factory.createNotificationList(fileContentStr);

        assertEquals(5, notifications.size());

        Notification notification = notifications.get(0);
        assertEquals(808, notification.getId());
        assertEquals(false, notification.isAlreadyRead());
        assertEquals(3, notification.getReason());
        assertEquals(true, notification.isResourceAlreadyRead());

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
