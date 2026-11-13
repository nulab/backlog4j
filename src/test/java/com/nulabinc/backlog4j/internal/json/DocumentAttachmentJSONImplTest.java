package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Attachment;
import com.nulabinc.backlog4j.DocumentAttachment;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The response of the add document attachment API has the same fields as the attachments of the get document API.
 */
public class DocumentAttachmentJSONImplTest extends AbstractJSONImplTest {

    @Test
    public void createDocumentAttachmentTest() throws IOException {
        String fileContentStr = getJsonString("json/document_attachment.json");
        DocumentAttachment attachment = factory.createDocumentAttachment(fileContentStr);

        assertEquals(22067, attachment.getId());
        assertEquals("22067", attachment.getIdAsString());
        assertEquals("test.png", attachment.getName());
        assertEquals(8718, attachment.getSize());
        assertTrue(attachment.isImage());

        assertNotNull(attachment.getCreatedUser());
        assertEquals(1073936936, attachment.getCreatedUser().getId());
        assertEquals("test", attachment.getCreatedUser().getName());

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(2025, Calendar.MAY, 29, 2, 19, 54);
        calendar.set(Calendar.MILLISECOND, 0);
        assertEquals(calendar.getTime(), attachment.getCreated());

        // The attachment can be used where an Attachment (as in Document#getAttachments) is expected.
        assertInstanceOf(Attachment.class, attachment);
    }

    @Test
    @SuppressWarnings("deprecation")
    public void deprecatedGettersTest() throws IOException {
        String fileContentStr = getJsonString("json/document_attachment.json");
        DocumentAttachment attachment = factory.createDocumentAttachment(fileContentStr);

        // Derived from createdUser, so existing callers keep getting the user ID.
        assertEquals(Long.valueOf(1073936936), attachment.getCreatedUserId());
        // The API no longer returns these fields.
        assertNull(attachment.getDocumentId());
        assertNull(attachment.getUpdatedUserId());
        assertNull(attachment.getUpdated());
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/document_attachment.json");
        DocumentAttachment a = factory.createDocumentAttachment(fileContentStr);
        DocumentAttachment b = factory.createDocumentAttachment(fileContentStr);
        DocumentAttachment other = factory.createDocumentAttachment(fileContentStr.replace("22067", "22068"));

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, other);
    }
}
