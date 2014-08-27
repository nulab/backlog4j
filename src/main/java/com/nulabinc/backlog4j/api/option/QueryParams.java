package com.nulabinc.backlog4j.api.option;

import org.apache.http.message.BasicNameValuePair;

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

    public QueryParams minId(int minId) {
        parameters.add(new BasicNameValuePair("minId", String.valueOf(minId)));
        return this;
    }

    public QueryParams maxId(int maxId) {
        parameters.add(new BasicNameValuePair("maxId", String.valueOf(maxId)));
        return this;
    }

    public QueryParams count(int count) {
        parameters.add(new BasicNameValuePair("count", String.valueOf(count)));
        return this;
    }

    public QueryParams order(Order order) {
        parameters.add(new BasicNameValuePair("order", order.getStrValue()));
        return this;
    }

}
