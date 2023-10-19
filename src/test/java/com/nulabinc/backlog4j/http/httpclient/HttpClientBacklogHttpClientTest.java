package com.nulabinc.backlog4j.http.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.CreateWikiParams;
import com.nulabinc.backlog4j.api.option.UpdateWikiParams;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.http.BacklogHttpClient;
import com.nulabinc.backlog4j.internal.file.AttachmentDataImpl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientBacklogHttpClientTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private static final String API_KEY = "********";

    private final ObjectMapper objectMapper;

    private BacklogClient backlogClient;

    private MockWebServer mockWebServer;

    public HttpClientBacklogHttpClientTest() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new BacklogDateJsonSerializer());
        objectMapper.registerModule(module);
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    public void setup() throws IOException {
        this.mockWebServer = new MockWebServer();
        this.mockWebServer.start();

        final BacklogConfigure configure = new MockWebServerBacklogConfigure(this.mockWebServer).apiKey(API_KEY);
        final HttpClient.Builder httpClientBuilder = HttpClient.newBuilder();
        final BacklogHttpClient backlogHttpClient = new HttpClientBacklogHttpClient(httpClientBuilder);
        this.backlogClient = new BacklogClientFactory(configure, backlogHttpClient).newClient();
    }

    @AfterEach
    public void teardown() throws IOException {
        this.mockWebServer.shutdown();
    }

    @Test
    public void testGet_getMyself() throws Exception {
        final Map<String, Object> userMap = new LinkedHashMap<>();
        userMap.put("id", 1);
        userMap.put("userId", "admin");
        userMap.put("name", "Administrator");
        userMap.put("roleType", 1);
        userMap.put("lang", "ja");
        userMap.put("mailAddress", "john.doe@example.com");
        final String responseBody = objectMapper.writeValueAsString(userMap);
        logger.info("responseBody:{}", responseBody);
        final MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(responseBody);
        this.mockWebServer.enqueue(mockResponse);

        final User myself = backlogClient.getMyself();
        logger.info("Got myself:{}", myself.toString());
        assertEquals(1, myself.getId());
        assertEquals("admin", myself.getUserId());
        assertEquals("Administrator", myself.getName());
        assertEquals(User.RoleType.Admin, myself.getRoleType());
        assertEquals("ja", myself.getLang());
        assertEquals("john.doe@example.com", myself.getMailAddress());

        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        logger.info("Request: {}", recordedRequest);
        assertEquals("GET", recordedRequest.getMethod());
        assertEquals("/api/v2/users/myself?apiKey=********", recordedRequest.getPath());
        assertEquals(0, recordedRequest.getBody().size());
        assertEquals("no-cache", recordedRequest.getHeader("Cache-Control"));
        assertTrue(Objects.requireNonNull(recordedRequest.getHeader("User-Agent")).startsWith("backlog4j/"));
    }

    @Test
    public void testPost_createWiki() throws Exception {
        final Map<String, Object> userMap = new LinkedHashMap<>();
        userMap.put("id", 1);
        userMap.put("userId", "admin");
        userMap.put("name", "Administrator");
        userMap.put("roleType", 1);
        userMap.put("lang", "ja");
        userMap.put("mailAddress", "john.doe@example.com");

        final Map<String, Object> wikiMap = new LinkedHashMap<>();
        wikiMap.put("id", 1);
        wikiMap.put("projectId", 1);
        wikiMap.put("name", "Home");
        wikiMap.put("content", "test");
        wikiMap.put("tags", new ArrayList<>());
        wikiMap.put("attachments", new ArrayList<>());
        wikiMap.put("sharedFiles", new ArrayList<>());
        wikiMap.put("stars", new ArrayList<>());
        wikiMap.put("createdUser", userMap);
        wikiMap.put("created", new Date());
        wikiMap.put("updatedUser", userMap);
        wikiMap.put("updated", new Date());

        final String responseBody = objectMapper.writeValueAsString(wikiMap);
        logger.info("responseBody:{}", responseBody);
        final MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(responseBody);
        this.mockWebServer.enqueue(mockResponse);

        final CreateWikiParams params = new CreateWikiParams(1, "test", "testtest");
        final Wiki wiki = backlogClient.createWiki(params);
        logger.info("Wiki created: {}", wiki);
        assertEquals(1, wiki.getId());
        assertEquals(1, wiki.getProjectId());
        assertEquals("Home", wiki.getName());
        assertEquals("test", wiki.getContent());
        assertTrue(wiki.getTags().isEmpty());
        assertTrue(wiki.getAttachments().isEmpty());
        assertTrue(wiki.getSharedFiles().isEmpty());
        assertTrue(wiki.getStars().isEmpty());
        assertEquals(1, wiki.getCreatedUser().getId());
        assertNotNull(wiki.getCreated());
        assertEquals(1, wiki.getUpdatedUser().getId());
        assertNotNull(wiki.getUpdated());

        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        logger.info("Request: {}", recordedRequest);
        assertEquals("POST", recordedRequest.getMethod());
        assertEquals("/api/v2/wikis?apiKey=********", recordedRequest.getPath());
        assertTrue(recordedRequest.getBody().size() > 0);
        assertEquals("application/x-www-form-urlencoded; charset=UTF-8", recordedRequest.getHeader("Content-Type"));
        assertEquals("no-cache", recordedRequest.getHeader("Cache-Control"));
        assertTrue(Objects.requireNonNull(recordedRequest.getHeader("User-Agent")).startsWith("backlog4j/"));
    }

    @Test
    public void testPostMultipart_postAttachment() throws Exception {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("talk.svg")) {
            final Map<String, Object> postAttachmentMap = new LinkedHashMap<>();
            postAttachmentMap.put("id", 1);
            postAttachmentMap.put("name", "talk.svg");
            postAttachmentMap.put("size", 8857);

            final String responseBody = objectMapper.writeValueAsString(postAttachmentMap);
            logger.info("responseBody:{}", responseBody);
            final MockResponse mockResponse = new MockResponse();
            mockResponse.setResponseCode(200);
            mockResponse.setBody(responseBody);
            this.mockWebServer.enqueue(mockResponse);

            final AttachmentData attachmentData = new AttachmentDataImpl("talk.svg", input);
            final Attachment attachment = backlogClient.postAttachment(attachmentData);
            logger.info("Attachment post: {}", attachment);
            assertEquals(1, attachment.getId());
            assertEquals("talk.svg", attachment.getName());
            assertEquals(8857, attachment.getSize());

            final RecordedRequest recordedRequest = mockWebServer.takeRequest();
            logger.info("Request: {}", recordedRequest);
            assertEquals("POST", recordedRequest.getMethod());
            assertEquals("/api/v2/space/attachment?apiKey=********", recordedRequest.getPath());
            assertTrue(recordedRequest.getBody().size() > 0);
            assertEquals("multipart/form-data; boundary=*******", recordedRequest.getHeader("Content-Type"));
            assertEquals("no-cache", recordedRequest.getHeader("Cache-Control"));
            assertTrue(Objects.requireNonNull(recordedRequest.getHeader("User-Agent")).startsWith("backlog4j/"));
            final String bodyString = recordedRequest.getBody().readString(StandardCharsets.UTF_8);
            logger.info("Body;{}", bodyString);
        }
    }

    @Test
    public void testPatch_updateWiki() throws Exception {
        final Map<String, Object> userMap = new LinkedHashMap<>();
        userMap.put("id", 1);
        userMap.put("userId", "admin");
        userMap.put("name", "Administrator");
        userMap.put("roleType", 1);
        userMap.put("lang", "ja");
        userMap.put("mailAddress", "john.doe@example.com");

        final Map<String, Object> wikiMap = new LinkedHashMap<>();
        wikiMap.put("id", 1);
        wikiMap.put("projectId", 1);
        wikiMap.put("name", "Home");
        wikiMap.put("content", "testtest");
        wikiMap.put("tags", new ArrayList<>());
        wikiMap.put("attachments", new ArrayList<>());
        wikiMap.put("sharedFiles", new ArrayList<>());
        wikiMap.put("stars", new ArrayList<>());
        wikiMap.put("createdUser", userMap);
        wikiMap.put("created", new Date());
        wikiMap.put("updatedUser", userMap);
        wikiMap.put("updated", new Date());

        final String responseBody1 = objectMapper.writeValueAsString(wikiMap);
        logger.info("responseBody:{}", responseBody1);
        final MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(responseBody1);
        this.mockWebServer.enqueue(mockResponse);

        final UpdateWikiParams params = new UpdateWikiParams(1)
                .content("testtest");
        final Wiki wiki = backlogClient.updateWiki(params);
        logger.info("Wiki updated: {}", wiki);
        assertEquals(1, wiki.getId());
        assertEquals(1, wiki.getProjectId());
        assertEquals("Home", wiki.getName());
        assertEquals("testtest", wiki.getContent());
        assertTrue(wiki.getTags().isEmpty());
        assertTrue(wiki.getAttachments().isEmpty());
        assertTrue(wiki.getSharedFiles().isEmpty());
        assertTrue(wiki.getStars().isEmpty());
        assertEquals(1, wiki.getCreatedUser().getId());
        assertNotNull(wiki.getCreated());
        assertEquals(1, wiki.getUpdatedUser().getId());
        assertNotNull(wiki.getUpdated());

        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        logger.info("Request: {}", recordedRequest);
        assertEquals("PATCH", recordedRequest.getMethod());
        assertEquals("/api/v2/wikis/1?apiKey=********", recordedRequest.getPath());
        assertTrue(recordedRequest.getBody().size() > 0);
        assertEquals("application/x-www-form-urlencoded; charset=UTF-8", recordedRequest.getHeader("Content-Type"));
        assertEquals("no-cache", recordedRequest.getHeader("Cache-Control"));
        assertTrue(Objects.requireNonNull(recordedRequest.getHeader("User-Agent")).startsWith("backlog4j/"));
    }

    @Test
    public void testPatch_deleteWiki() throws Exception {
        final Map<String, Object> userMap = new LinkedHashMap<>();
        userMap.put("id", 1);
        userMap.put("userId", "admin");
        userMap.put("name", "Administrator");
        userMap.put("roleType", 1);
        userMap.put("lang", "ja");
        userMap.put("mailAddress", "john.doe@example.com");

        final Map<String, Object> wikiMap = new LinkedHashMap<>();
        wikiMap.put("id", 1);
        wikiMap.put("projectId", 1);
        wikiMap.put("name", "Home");
        wikiMap.put("content", "testtest");
        wikiMap.put("tags", new ArrayList<>());
        wikiMap.put("attachments", new ArrayList<>());
        wikiMap.put("sharedFiles", new ArrayList<>());
        wikiMap.put("stars", new ArrayList<>());
        wikiMap.put("createdUser", userMap);
        wikiMap.put("created", new Date());
        wikiMap.put("updatedUser", userMap);
        wikiMap.put("updated", new Date());

        final String responseBody = objectMapper.writeValueAsString(wikiMap);
        logger.info("responseBody:{}", responseBody);
        final MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(responseBody);
        this.mockWebServer.enqueue(mockResponse);

        final Wiki wiki = backlogClient.deleteWiki(1, false);
        logger.info("Wiki deleted: {}", wiki);
        assertEquals(1, wiki.getId());
        assertEquals(1, wiki.getProjectId());
        assertEquals("Home", wiki.getName());
        assertEquals("testtest", wiki.getContent());
        assertTrue(wiki.getTags().isEmpty());
        assertTrue(wiki.getAttachments().isEmpty());
        assertTrue(wiki.getSharedFiles().isEmpty());
        assertTrue(wiki.getStars().isEmpty());
        assertEquals(1, wiki.getCreatedUser().getId());
        assertNotNull(wiki.getCreated());
        assertEquals(1, wiki.getUpdatedUser().getId());
        assertNotNull(wiki.getUpdated());

        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        logger.info("Request: {}", recordedRequest);
        assertEquals("DELETE", recordedRequest.getMethod());
        assertEquals("/api/v2/wikis/1?apiKey=********", recordedRequest.getPath());
        assertTrue(recordedRequest.getBody().size() > 0);
        assertEquals("application/x-www-form-urlencoded; charset=UTF-8", recordedRequest.getHeader("Content-Type"));
        assertEquals("no-cache", recordedRequest.getHeader("Cache-Control"));
        assertTrue(Objects.requireNonNull(recordedRequest.getHeader("User-Agent")).startsWith("backlog4j/"));
    }

    @Test
    public void testPut_updateSpaceNotification() throws Exception {
        final Map<String, Object> spaceNotificationMap = new LinkedHashMap<>();
        spaceNotificationMap.put("content", "Notification");
        spaceNotificationMap.put("updated", new Date());

        final String responseBody = objectMapper.writeValueAsString(spaceNotificationMap);
        logger.info("responseBody:{}", responseBody);
        final MockResponse mockResponse = new MockResponse();
        mockResponse.setResponseCode(200);
        mockResponse.setBody(responseBody);
        this.mockWebServer.enqueue(mockResponse);

        final SpaceNotification notification = backlogClient.updateSpaceNotification("Notification");
        logger.info("Space notification updated: {}", notification);
        assertEquals("Notification", notification.getContent());
        assertNotNull(notification.getUpdated());

        final RecordedRequest recordedRequest = mockWebServer.takeRequest();
        logger.info("Request: {}", recordedRequest);
        assertEquals("PUT", recordedRequest.getMethod());
        assertEquals("/api/v2/space/notification?apiKey=********", recordedRequest.getPath());
        assertTrue(recordedRequest.getBody().size() > 0);
        assertEquals("application/x-www-form-urlencoded; charset=UTF-8", recordedRequest.getHeader("Content-Type"));
        assertEquals("no-cache", recordedRequest.getHeader("Cache-Control"));
        assertTrue(Objects.requireNonNull(recordedRequest.getHeader("User-Agent")).startsWith("backlog4j/"));
    }
}
