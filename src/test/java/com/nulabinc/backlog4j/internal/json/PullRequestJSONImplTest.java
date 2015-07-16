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
public class PullRequestJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createPullRequestListTest() throws IOException {
        String fileContentStr = getJsonString("json/pull_requests.json");
        ResponseList<PullRequest> pullRequests = factory.createPullRequestList(fileContentStr);

        assertEquals(1, pullRequests.size());

        PullRequest pullRequest = pullRequests.get(0);
        assertEquals(2, pullRequest.getId());
        assertEquals(3, pullRequest.getProjectId());
        assertEquals(1, pullRequest.getNumber());
        assertEquals("test", pullRequest.getSummary());
        assertEquals("test data", pullRequest.getDescription());
        assertEquals("master", pullRequest.getBase());
        assertEquals("develop", pullRequest.getBranch());

        MergeStatus mergeStatus = pullRequest.getStatus();
        assertEquals(1, mergeStatus.getId());
        assertEquals("Open", mergeStatus.getName());

        User assignee = pullRequest.getAssignee();
        assertEquals(5, assignee.getId());

        Issue issue = pullRequest.getIssue();
        assertEquals(31, issue.getId());

        // todo add test
        /*
        "mergeCommit": null,
        "baseCommit": null,
        "branchCommit": null,
        "closeAt": null,
        "mergeAt": null,
        */
        User user = pullRequest.getCreatedUser();
        assertEquals(1, user.getId());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.APRIL, 23, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(pullRequest.getCreated()));

        User updateUser = pullRequest.getUpdatedUser();
        assertEquals(2, updateUser.getId());

        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.APRIL, 24, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(pullRequest.getUpdated()));

    }
}
