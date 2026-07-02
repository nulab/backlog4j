package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class GetIssueParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() {

        // when
        GetIssueParams params = new GetIssueParams();
        params.expand(Arrays.asList(Issue.Expand.ChildIssueSummary));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(1, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "expand[]", "childIssueSummary"));
    }
}
