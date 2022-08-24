package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.internal.json.AbstractJSONImplTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class BacklogAuthExceptionTest extends AbstractJSONImplTest {

    @Test
    public void parseMessageTest() throws IOException {
        String fileContentStr = getJsonString("json/auth_error.json");
        BacklogAuthException authException = new BacklogAuthException(fileContentStr, new Exception());

        BacklogAuthErrorMessage backlogError = authException.getBacklogAuthErrorMessage();
        assertEquals("invalid_grant", backlogError.getError());
        assertEquals("Grant is invalid.", backlogError.getDescription());
    }
}
