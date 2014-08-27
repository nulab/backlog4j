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
        BacklogException backlogException = new BacklogException(fileContentStr, new Exception());

        BacklogError backlogError = backlogException.getBacklogError();
        assertEquals(2, backlogError.getErrors().size());

        BacklogErrorMessage errorMessage = backlogError.getErrors().get(0);
        assertEquals(6, errorMessage.getCode());
        assertEquals("No project.", errorMessage.getMessage());
        assertEquals(null, errorMessage.getErrorInfo());
        assertEquals("There are no projects.", errorMessage.getMoreInfo());

        errorMessage = backlogError.getErrors().get(1);
        assertEquals(7, errorMessage.getCode());
        assertEquals("No user.", errorMessage.getMessage());
        assertEquals(null, errorMessage.getErrorInfo());
        assertEquals("There are no users.", errorMessage.getMoreInfo());
    }

    @Test
    public void statusCodeTest() throws IOException {
        BacklogException backlogException = new BacklogException("statusCodeTest", new Exception(), 401);

        BacklogError backlogError = backlogException.getBacklogError();
        assertEquals(null, backlogError);

        assertEquals("statusCodeTest", backlogException.getMessage());
        assertEquals(401, backlogException.getStatusCode());
    }
}
