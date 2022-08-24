package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.AttachmentInfo;
import com.nulabinc.backlog4j.ChangeLog;
import com.nulabinc.backlog4j.Notification;
import com.nulabinc.backlog4j.PullRequestComment;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.User;
import org.exparity.hamcrest.date.DateMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class PullRequestCommentJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createPullRequestCommentListTest() throws IOException {
        String fileContentStr = getJsonString("json/pull_request_comments.json");
        ResponseList<PullRequestComment> pullRequestComments = factory.createPullRequestCommentList(fileContentStr);

        assertEquals(1, pullRequestComments.size());

        PullRequestComment pullRequestComment = pullRequestComments.get(0);
        assertEquals(12345, pullRequestComment.getId());
        assertEquals("test comment\"(greenpepper)\"\"(Cacoo)\"", pullRequestComment.getContent());

        List<ChangeLog> logs = pullRequestComment.getChangeLog();
        ChangeLog log = logs.get(0);
        assertEquals("*銀行振込：30件", log.getNewValue());
        AttachmentInfo attachmentInfo = log.getAttachmentInfo();
        assertEquals(1123344555, attachmentInfo.getId());

        List<Star> stars = pullRequestComment.getStars();
        assertEquals(1, stars.size());

        List<Notification> notifications = pullRequestComment.getNotifications();
        assertEquals(0, notifications.size());

        User user = pullRequestComment.getCreatedUser();
        assertEquals(11111111, user.getId());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JULY, 16, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(pullRequestComment.getCreated()));

//        User updateUser = pullRequestComment.getUpdatedUser();
//        assertEquals(2, updateUser.getId());

        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JULY, 16, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(pullRequestComment.getUpdated()));

    }
}
