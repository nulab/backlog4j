package com.nulabinc.backlog4j.internal.json;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimeZone;

/**
 * @author nulab-inc
 */
public abstract class AbstractJSONImplTest {

    protected InternalFactoryJSONImpl factory = new InternalFactoryJSONImpl();
    protected TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");

    protected String getJsonString(String resourceFilePath) throws IOException {
        InputStreamReader r = null;
        try {
            r = new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFilePath), "UTF-8");
            CharArrayWriter writer = new CharArrayWriter();
            char buff[] = new char[4096];
            int size;
            while ((size = r.read(buff)) > 0) {
                writer.write(buff, 0, size);
            }
            return writer.toString();
        } finally {
            if (r != null) {
                r.close();
            }
        }
    }
}
