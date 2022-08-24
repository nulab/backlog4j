package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.auth.AccessToken;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class AccessTokenJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createAccessTokenTest() throws IOException {
        String fileContentStr = getJsonString("json/access_token.json");
        AccessToken accessToken = factory.createAccessToken(fileContentStr);

        assertEquals("Bearer", accessToken.getType());
        assertEquals("1234LfSkZBrmb4uU15Wwcnt1PL7534gtIz4AuctoqLzSqyrKF89UT23wfDmmp9l", accessToken.getToken());
        assertEquals(3600, accessToken.getExpires().longValue());
        assertEquals("1234qXvEzIfWuk1gHlWbn8PQZCQdwTLqM26bZHrP4T93BGIXguBL1MBpKVmDJO4", accessToken.getRefresh());

    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/access_token.json");
        AccessToken accessToken1 = factory.createAccessToken(fileContentStr);
        AccessToken accessToken2 = factory.createAccessToken(fileContentStr);
        assertEquals(accessToken1, accessToken2);

    }

    @Test
    public void hashCodeTest() throws IOException {
        String fileContentStr = getJsonString("json/access_token.json");
        AccessToken accessToken1 = factory.createAccessToken(fileContentStr);
        AccessToken accessToken2 = factory.createAccessToken(fileContentStr);

        assertEquals(accessToken1.hashCode(), accessToken2.hashCode());

    }

}
