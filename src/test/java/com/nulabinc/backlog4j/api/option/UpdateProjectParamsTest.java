package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class UpdateProjectParamsTest extends AbstractParamsTest {
    @Test
    public void updateParamWithGrandchildIssueEnabledTest() {

        // when
        UpdateProjectParams params = new UpdateProjectParams("TEST");
        params.grandchildIssueEnabled(true);

        // then
        assertEquals("TEST", params.getProjectIdOrKeyString());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(1, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "grandchildIssueEnabled", "true"));
    }
}
