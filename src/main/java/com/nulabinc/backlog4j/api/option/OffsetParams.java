package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for offset.
 *
 * @author nulab-inc
 */
public class OffsetParams extends GetParams {
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

    public OffsetParams offset(int offset) {
        parameters.add(new NameValuePair("offset", String.valueOf(offset)));
        return this;
    }

    public OffsetParams count(int count) {
        parameters.add(new NameValuePair("count", String.valueOf(count)));
        return this;
    }

    public OffsetParams order(Order order) {
        parameters.add(new NameValuePair("order", order.getStrValue()));
        return this;
    }

}
