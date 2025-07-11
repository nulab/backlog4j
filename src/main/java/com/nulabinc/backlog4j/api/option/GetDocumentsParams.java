package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for get document page API.
 *
 * @author nulab-inc
 */
public class GetDocumentsParams extends GetParams {

    private SortKey sort;
    private Order order;

    public enum SortKey {
        Created("created"),
        Updated("updated");

        SortKey(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        private final String value;
    }

    public enum Order {
        Asc("asc"),
        Desc("desc");

        Order(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        private final String value;
    }

    public GetDocumentsParams(List<Long> projectIds, long offset) {
        parameters.add(new NameValuePair("offset", String.valueOf(offset)));
        for (Long projectId : projectIds) {
            parameters.add(new NameValuePair("projectId[]", projectId.toString()));
        }
    }

    public GetDocumentsParams keyword(String keyword) throws BacklogException {
        parameters.add(new NameValuePair("keyword", keyword));
        return this;
    }

    public GetDocumentsParams sort(SortKey sort) {
        parameters.add(new NameValuePair("sort", sort.getStrValue()));
        this.sort = sort;
        return this;
    }

    public GetDocumentsParams order(Order order) {
        parameters.add(new NameValuePair("order", order.getStrValue()));
        this.order = order;
        return this;
    }

    public GetDocumentsParams offset(long offset) {
        parameters.add(new NameValuePair("offset", String.valueOf(offset)));
        return this;
    }

    public GetDocumentsParams count(long count) {
        parameters.add(new NameValuePair("count", String.valueOf(count)));
        return this;
    }

    public SortKey getSort() {
        return sort;
    }

    public Order getOrder() {
        return order;
    }
}
