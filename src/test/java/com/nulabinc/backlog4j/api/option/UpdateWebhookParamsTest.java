package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class UpdateWebhookParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() throws UnsupportedEncodingException {

        // when
        long projectId = 1000001l;
        long webhookId = 1l;
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
        assertEquals(true, existsOneKeyValue(parameters, "name", name));
        assertEquals(true, existsOneKeyValue(parameters, "hookUrl", hookUrl));
        assertEquals(true, existsOneKeyValue(parameters, "description", "description"));
        assertEquals(true, existsOneKeyValue(parameters, "activityTypeIds[]", "1"));
        assertEquals(true, existsOneKeyValue(parameters, "activityTypeIds[]", "2"));
        assertEquals(String.valueOf(projectId), params.getProjectIdOrKeyString());
        assertEquals(webhookId, params.getWebhookId());
    }

    @Test
    public void createParam_AllEvent_Test() throws UnsupportedEncodingException {

        // when
        String projectKey = "PROJECT";
        long webhookId = 1l;
        String name = "name";
        String hookUrl = "hookurl";
        UpdateWebhookParams params = new UpdateWebhookParams(projectKey, webhookId);
        params.allEvent(true);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(1, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "allEvent", "true"));
        assertEquals(projectKey, params.getProjectIdOrKeyString());
        assertEquals(webhookId, params.getWebhookId());
    }
}
