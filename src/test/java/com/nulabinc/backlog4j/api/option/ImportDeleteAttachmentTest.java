package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class ImportDeleteAttachmentTest extends AbstractParamsTest {
    @Test
    public void createParamTest() throws UnsupportedEncodingException {

        // when
        ImportDeleteAttachmentParams params = new ImportDeleteAttachmentParams();
        params.created("2018-01-11T10:36:49+0900");
        params.createdUserId(4000000002l);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(2, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "createdUserId", "4000000002"));
        assertEquals(true, existsOneKeyValue(parameters, "created", "2018-01-11T10:36:49+0900"));
    }
}
