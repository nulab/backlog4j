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
public class CreateWebhookParamsTest extends AbstractParamsTest{
    @Test
    public void createParamTest() throws UnsupportedEncodingException {

        // when
        long projectId =1000001l;
        String name = "name";
        String hookUrl = "hookurl";
        CreateWebhookParams params = new CreateWebhookParams(projectId, name, hookUrl);
        params.description("description")
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
    }

    @Test
    public void createParam_AllEvent_Test() throws UnsupportedEncodingException {
        // when
        String projectKey = "PROJECT";
        String name = "name";
        String hookUrl = "hookurl";
        CreateWebhookParams params = new CreateWebhookParams(projectKey, name, hookUrl);
        params.allEvent(true);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(3, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "name", name));
        assertEquals(true, existsOneKeyValue(parameters, "hookUrl", hookUrl));
        assertEquals(true, existsOneKeyValue(parameters, "allEvent", "true"));
        assertEquals(projectKey, params.getProjectIdOrKeyString());
    }

    @Test
    public void createParam_SetNull_Test() throws UnsupportedEncodingException {
        // when
        String projectKey = "PROJECT";
        CreateWebhookParams params = new CreateWebhookParams(projectKey, null, null);
        params.allEvent(true);
        params.description(null);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(4, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "name", "")); // set empty
        assertEquals(true, existsOneKeyValue(parameters, "hookUrl", ""));
        assertEquals(true, existsOneKeyValue(parameters, "allEvent", "true"));
        assertEquals(true, existsOneKeyValue(parameters, "description", ""));
        assertEquals(projectKey, params.getProjectIdOrKeyString());
    }
}
