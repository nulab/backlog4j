package com.nulabinc.backlog4j.internal.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TimeZone;

/**
 * @author nulab-inc
 */
public abstract class AbstractJSONImplTest {

    protected InternalFactoryJSONImpl factory = new InternalFactoryJSONImpl();
    protected TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo") ;

    protected String getJsonString(String resourceFilePath) throws IOException {
        String fileName = SpaceJSONImplTest.class.getClassLoader().getResource(resourceFilePath).getPath();

        byte[] fileContentBytes = Files.readAllBytes(Paths.get(fileName));
        String fileContentStr = new String(fileContentBytes, StandardCharsets.UTF_8);
        return fileContentStr;
    }
}
