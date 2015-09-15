package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class ImportWikiParamsTest extends AbstractParamsTest {
    @Test
    public void createParamTest() throws UnsupportedEncodingException {

        // when
        ImportWikiParams params = new ImportWikiParams(1000000001l, "test wiki 1", "test wiki content 1");
        params.mailNotify(true);
        params.created("2015-09-14T10:36:49+0900");
        params.createdUserId(4000000001l);
        params.updated("2015-09-14T10:36:49+0900");
        params.updatedUserId(4000000001l);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(8, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "projectId", "1000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "name", "test wiki 1"));
        assertEquals(true, existsOneKeyValue(parameters, "content", "test wiki content 1"));
        assertEquals(true, existsOneKeyValue(parameters, "mailNotify", "true"));
        assertEquals(true, existsOneKeyValue(parameters, "created", "2015-09-14T10:36:49+0900"));
        assertEquals(true, existsOneKeyValue(parameters, "createdUserId", "4000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "updated", "2015-09-14T10:36:49+0900"));
        assertEquals(true, existsOneKeyValue(parameters, "updatedUserId", "4000000001"));
    }

}
