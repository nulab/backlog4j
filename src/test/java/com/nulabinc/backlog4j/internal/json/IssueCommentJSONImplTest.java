package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.AttachmentInfo;
import com.nulabinc.backlog4j.ChangeLog;
import com.nulabinc.backlog4j.IssueComment;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class IssueCommentJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createIssueCommentListTest() throws IOException {
        String fileContentStr = getJsonString("json/issue_comments.json");
        ResponseList<IssueComment> comments = factory.createIssueCommentList(fileContentStr);

        assertEquals(2, comments.size());

        IssueComment comment = comments.get(0);
        assertEquals(1102837675, comment.getId());
        List<ChangeLog> logs = comment.getChangeLog();
        ChangeLog log = logs.get(0);
        assertEquals("*銀行振込：30件", log.getNewValue());
        AttachmentInfo attachmentInfo = log.getAttachmentInfo();
        assertEquals(1123344555, attachmentInfo.getId());


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
