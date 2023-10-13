package com.nulabinc.backlog4j.internal.json;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.TimeZone;

/**
 * @author nulab-inc
 */
public abstract class AbstractJSONImplTest {

    protected InternalFactoryJSONImpl factory = new InternalFactoryJSONImpl();
    protected TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");

    protected String getJsonString(String resourceFilePath) throws IOException {
        try (InputStreamReader r = new InputStreamReader(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFilePath)), StandardCharsets.UTF_8)) {
            CharArrayWriter writer = new CharArrayWriter();
            char[] buff = new char[4096];
            int size;
            while ((size = r.read(buff)) > 0) {
                writer.write(buff, 0, size);
            }
            return writer.toString();
        }
    }
}
