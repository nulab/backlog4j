package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.internal.json.AbstractJSONImplTest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author nulab-inc
 */
public class BacklogExceptionTest extends AbstractJSONImplTest{

    @Test
    public void parseMessageTest() throws IOException {
        String fileContentStr = getJsonString("json/error.json");
        BacklogException backlogException = new BacklogAPIException(fileContentStr, new Exception());

        BacklogAPIError backlogAPIError = ((BacklogAPIException)backlogException).getBacklogAPIError();
        assertEquals(2, backlogAPIError.getErrors().size());

        BacklogAPIErrorMessage errorMessage = backlogAPIError.getErrors().get(0);
        assertEquals(6, errorMessage.getCode());
        assertEquals("No project.", errorMessage.getMessage());
        assertEquals(null, errorMessage.getErrorInfo());
        assertEquals("There are no projects.", errorMessage.getMoreInfo());

        errorMessage = backlogAPIError.getErrors().get(1);
        assertEquals(7, errorMessage.getCode());
        assertEquals("No user.", errorMessage.getMessage());
        assertEquals(null, errorMessage.getErrorInfo());
        assertEquals("There are no users.", errorMessage.getMoreInfo());
    }

    @Test
    public void statusCodeTest() throws IOException {
        BacklogException backlogException = new BacklogAPIException("statusCodeTest", new Exception(), 401);

        BacklogAPIError backlogAPIError = ((BacklogAPIException)backlogException).getBacklogAPIError();
        assertEquals(null, backlogAPIError);

        assertEquals("statusCodeTest\nstatus code - 401", backlogException.getMessage());
        assertEquals(401, ((BacklogAPIException)backlogException).getStatusCode());
    }
}
