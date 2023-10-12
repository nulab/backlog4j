package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nulabinc.backlog4j.BacklogAPIException;

import java.util.List;

/**
 * @author nulab-inc
 */
public class Jackson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
    }

    public static <T> T fromJsonString(String json, Class<T> clazz) {

        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new BacklogAPIException("parse json is failed.", e);
        }
    }

    public static <T> List<T> listFromJsonString(String json, Class<T> clazz) {

        try {
            return objectMapper.readValue(json, new TypeReference<List<T>>() {
            });
        } catch (Exception e) {
            throw new BacklogAPIException("parse json is failed.", e);
        }
    }


}
