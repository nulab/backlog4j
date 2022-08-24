package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class UpdateGroupParamsTest extends AbstractParamsTest {

    @Test
    public void createParamTest() {

        // when
        UpdateGroupParams params = new UpdateGroupParams(1000000001L);
        params.name("group 1")
                .members(Arrays.asList(2000000001L, 2000000002L));

        // then
        assertEquals("1000000001", params.getGroupId());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(3, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "name", "group 1"));
        assertTrue(existsOneKeyValue(parameters, "members[]", "2000000001"));
        assertTrue(existsOneKeyValue(parameters, "members[]", "2000000002"));
    }

    @Test
    public void createParamWithStringIdTest() {

        // when
        UpdateGroupParams params = new UpdateGroupParams("1000000001");
        params.name("group 2")
                .members(Arrays.asList("2000000001", "2000000002"));

        // then
        assertEquals("1000000001", params.getGroupId());
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(3, parameters.size());
        assertTrue(existsOneKeyValue(parameters, "name", "group 2"));
        assertTrue(existsOneKeyValue(parameters, "members[]", "2000000001"));
        assertTrue(existsOneKeyValue(parameters, "members[]", "2000000002"));
    }
}
