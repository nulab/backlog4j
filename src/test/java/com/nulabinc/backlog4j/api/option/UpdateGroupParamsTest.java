package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class UpdateGroupParamsTest extends AbstractParamsTest {

    @Test
    public void createParamTest() throws UnsupportedEncodingException {

        // when
        UpdateGroupParams params = new UpdateGroupParams(1000000001l);
        params.name("group 1")
                .members(Arrays.asList(2000000001l, 2000000002l));

        // then
        assertEquals("1000000001", params.getGroupId());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(3, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "name", "group 1"));
        assertEquals(true, existsOneKeyValue(parameters, "members[]", "2000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "members[]", "2000000002"));
    }

    @Test
    public void createParamWithStringIdTest() throws UnsupportedEncodingException {

        // when
        UpdateGroupParams params = new UpdateGroupParams("1000000001");
        params.name("group 2")
                .members(Arrays.asList("2000000001", "2000000002"));

        // then
        assertEquals("1000000001", params.getGroupId());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(3, parameters.size());
        assertEquals(true, existsOneKeyValue(parameters, "name", "group 2"));
        assertEquals(true, existsOneKeyValue(parameters, "members[]", "2000000001"));
        assertEquals(true, existsOneKeyValue(parameters, "members[]", "2000000002"));
    }
}
