package com.nulabinc.backlog4j.http.httpclient;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BacklogDateJsonSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(final Date date, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String text = format.format(date);
        jsonGenerator.writeRawValue("\"" + text + "\"");
    }
}
