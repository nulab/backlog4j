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
public class UpdateWebhookParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() {

        // when
        long projectId = 1000001L;
        long webhookId = 1L;
        String name = "name";
        String hookUrl = "hookurl";
        UpdateWebhookParams params = new UpdateWebhookParams(projectId, webhookId);
        params.name(name)
                .hookUrl(hookUrl)
                .description("description")
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
        assertEquals("1", params.getWebhookId());
    }

    @Test
    public void createParam_AllEvent_Test() {

        // when
        String projectKey = "PROJECT";
        long webhookId = 1L;
        UpdateWebhookParams params = new UpdateWebhookParams(projectKey, webhookId);
        params.allEvent(true);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(1, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "allEvent", "true"));
        assertEquals(projectKey, params.getProjectIdOrKeyString());
        assertEquals("1", params.getWebhookId());
    }

    @Test
    public void createParam_SetNull_Test() {

        // when
        long projectId = 1000001L;
        long webhookId = 1L;
        UpdateWebhookParams params = new UpdateWebhookParams(projectId, webhookId);
        params.name(null)
                .hookUrl(null)
                .description(null);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(3, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "name", ""));
        assertTrue(existsOneKeyValue(parameters, "hookUrl", ""));
        assertTrue(existsOneKeyValue(parameters, "description", ""));
        assertEquals(String.valueOf(projectId), params.getProjectIdOrKeyString());
        assertEquals("1", params.getWebhookId());
    }
}
