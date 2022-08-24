package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class CreateWebhookParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() {

        // when
        long projectId = 1000001L;
        String name = "name";
        String hookUrl = "hookurl";
        CreateWebhookParams params = new CreateWebhookParams(projectId, name, hookUrl);
        params.description("description")
                .activityTypeIds(Arrays.asList(Activity.Type.IssueCreated, Activity.Type.IssueUpdated));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(5, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "name", name));
        assertTrue(existsOneKeyValue(parameters, "hookUrl", hookUrl));
        assertTrue(existsOneKeyValue(parameters, "description", "description"));
        assertTrue(existsOneKeyValue(parameters, "activityTypeIds[]", "1"));
        assertTrue(existsOneKeyValue(parameters, "activityTypeIds[]", "2"));
        assertEquals(String.valueOf(projectId), params.getProjectIdOrKeyString());
    }

    @Test
    public void createParam_AllEvent_Test() {
        // when
        String projectKey = "PROJECT";
        String name = "name";
        String hookUrl = "hookurl";
        CreateWebhookParams params = new CreateWebhookParams(projectKey, name, hookUrl);
        params.allEvent(true);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(3, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "name", name));
        assertTrue(existsOneKeyValue(parameters, "hookUrl", hookUrl));
        assertTrue(existsOneKeyValue(parameters, "allEvent", "true"));
        assertEquals(projectKey, params.getProjectIdOrKeyString());
    }

    @Test
    public void createParam_SetNull_Test() {
        // when
        String projectKey = "PROJECT";
        CreateWebhookParams params = new CreateWebhookParams(projectKey, null, null);
        params.allEvent(true);
        params.description(null);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(4, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "name", "")); // set empty
        assertTrue(existsOneKeyValue(parameters, "hookUrl", ""));
        assertTrue(existsOneKeyValue(parameters, "allEvent", "true"));
        assertTrue(existsOneKeyValue(parameters, "description", ""));
        assertEquals(projectKey, params.getProjectIdOrKeyString());
    }
}
