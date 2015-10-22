package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for get wiki page API.
 *
 * @author nulab-inc
 */
public class GetWikisParams extends GetParams {

    private SortKey sort;
    private Order order;

    public enum SortKey {
        Name("name"),
        Created("created"),
        Updated("updated");

        SortKey(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        private String value;
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

        private String value;
    }

    public GetWikisParams(Object projectIdOrKey) {
        parameters.add(new NameValuePair("projectIdOrKey", projectIdOrKey.toString()));
    }

    public GetWikisParams sort(SortKey sort) {
        parameters.add(new NameValuePair("sort", sort.getStrValue()));
        this.sort = sort;
        return this;
    }

    public GetWikisParams order(Order order) {
        parameters.add(new NameValuePair("order", order.getStrValue()));
        this.order = order;
        return this;
    }

    public SortKey getSort() {
        return sort;
    }

    public Order getOrder() {
        return order;
    }
}
