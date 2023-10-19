package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class QueryParamsTest {

    @Test
    public void minIdTest() {
        // when
        QueryParams params = new QueryParams();
        params.minId(123);

        // then
        List<NameValuePair> paramList = params.getParamList();
        assertEquals(1, paramList.size());
        NameValuePair param = paramList.get(0);
        assertEquals("minId", param.getName());
        assertEquals("123", param.getValue());
    }

    @Test
    public void maxIdTest() {
        // when
        QueryParams params = new QueryParams();
        params.maxId(999);

        // then
        List<NameValuePair> paramList = params.getParamList();
        assertEquals(1, paramList.size());
        NameValuePair param = paramList.get(0);
        assertEquals("maxId", param.getName());
        assertEquals("999", param.getValue());
    }

    @Test
    public void orderDescTest() {
        // when
        QueryParams params = new QueryParams();
        params.order(QueryParams.Order.Desc);

        // then
        List<NameValuePair> paramList = params.getParamList();
        assertEquals(1, paramList.size());
        NameValuePair param = paramList.get(0);
        assertEquals("order", param.getName());
        assertEquals("desc", param.getValue());
    }

    @Test
    public void orderAscTest() {
        // when
        QueryParams params = new QueryParams();
        params.order(QueryParams.Order.Asc);

        // then
        List<NameValuePair> paramList = params.getParamList();
        assertEquals(1, paramList.size());
        NameValuePair param = paramList.get(0);
        assertEquals("order", param.getName());
        assertEquals("asc", param.getValue());
    }

    @Test
    public void countTest() {
        // when
        QueryParams params = new QueryParams();
        params.count(222);

        // then
        List<NameValuePair> paramList = params.getParamList();
        assertEquals(1, paramList.size());
        NameValuePair param = paramList.get(0);
        assertEquals("count", param.getName());
        assertEquals("222", param.getValue());
    }
}
