package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for query.
 *
 * @author nulab-inc
 */
public class QueryParams extends GetParams{

    public enum Order {
        Asc("asc"),
        Desc("desc");

        Order(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        public static Order strValueOf(final String anValue) {
            for (Order d : values()) {
                if (d.getStrValue().equals(anValue)) {
                    return d;
                }
            }
            return null;
        }

        private String value;
    }

    public QueryParams minId(Object minId) {
        parameters.add(new NameValuePair("minId", minId.toString()));
        return this;
    }

    public QueryParams maxId(Object maxId) {
        parameters.add(new NameValuePair("maxId", maxId.toString()));
        return this;
    }

    public QueryParams count(int count) {
        parameters.add(new NameValuePair("count", String.valueOf(count)));
        return this;
    }

    public QueryParams count(long count) {
        parameters.add(new NameValuePair("count", String.valueOf(count)));
        return this;
    }

    public QueryParams order(Order order) {
        parameters.add(new NameValuePair("order", order.getStrValue()));
        return this;
    }

}
