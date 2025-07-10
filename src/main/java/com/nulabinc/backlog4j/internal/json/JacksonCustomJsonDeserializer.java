package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author nulab-inc
 */
public class JacksonCustomJsonDeserializer extends JsonDeserializer<String> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return mapper.writeValueAsString(parser.readValueAsTree());
    }
}


