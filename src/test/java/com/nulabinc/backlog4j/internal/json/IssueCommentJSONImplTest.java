package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.IssueComment;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class IssueCommentJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createIssueCommentListTest() throws IOException {
        String fileContentStr = getJsonString("json/issue_comments.json");
        ResponseList<IssueComment> comments = factory.createIssueCommentList(fileContentStr);

        assertEquals(2, comments.size());

        IssueComment comment = comments.get(0);
        assertEquals(1102837675, comment.getId());

        comment = comments.get(1);
        assertEquals(1102836944, comment.getId());

    }

    @Test
    public void createIssueCommentTest() throws IOException {
        String fileContentStr = getJsonString("json/issue_comment.json");
        IssueComment issueType = factory.createIssueComment(fileContentStr);

        assertEquals(1102837675, issueType.getId());
    }
}
