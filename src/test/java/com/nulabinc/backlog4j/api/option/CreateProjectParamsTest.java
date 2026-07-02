package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Project;
import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class CreateProjectParamsTest extends AbstractParamsTest {
    @Test
    public void createParamWithGrandchildIssueEnabledTest() {

        // when
        CreateProjectParams params = new CreateProjectParams(
                "test", "TEST",
                false, false, true, false,
                true, true, true, false, true, false,
                Project.TextFormattingRule.Markdown, false);
        params.grandchildIssueEnabled(true);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertTrue(existsOneKeyValue(parameters, "name", "test"));
        assertTrue(existsOneKeyValue(parameters, "key", "TEST"));
        assertTrue(existsOneKeyValue(parameters, "subtaskingEnabled", "true"));
        assertTrue(existsOneKeyValue(parameters, "grandchildIssueEnabled", "true"));
    }
}
