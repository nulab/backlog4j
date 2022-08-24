package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.Webhook;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class WebhookJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createWebhookListTest() throws IOException {
        String fileContentStr = getJsonString("json/webhooks.json");
        ResponseList<Webhook> webhooks = factory.createWebhookList(fileContentStr);

        assertEquals(2, webhooks.size());

        Webhook webhook = webhooks.get(0);
        assertEquals(1079196895, webhook.getId());
        assertEquals("webhook", webhook.getName());
        assertEquals("", webhook.getDescription());
        assertEquals("http://nulab.test/", webhook.getHookUrl());
        assertFalse(webhook.isAllEvent());
        assertNotNull(webhook.getActivityTypeIds());
        assertEquals(5, webhook.getActivityTypeIds().size());
        List<Activity.Type> activityTypeIds = webhook.getActivityTypeIds();
        assertEquals(Activity.Type.IssueCreated, activityTypeIds.get(0));
        assertEquals(Activity.Type.IssueUpdated, activityTypeIds.get(1));
        assertEquals(Activity.Type.IssueCommented, activityTypeIds.get(2));
        assertEquals(Activity.Type.IssueDeleted, activityTypeIds.get(3));
        assertEquals(Activity.Type.WikiCreated, activityTypeIds.get(4));

        assertEquals("2014-11-30 01:22:21", DateFormatUtils.formatUTC(webhook.getCreated(), "yyyy-MM-dd HH:mm:ss"));
        assertNotNull(webhook.getCreatedUser());
        assertEquals(1, webhook.getCreatedUser().getId());
        assertEquals("admin", webhook.getCreatedUser().getUserId());
        assertEquals("admin", webhook.getCreatedUser().getName());
        assertEquals(User.RoleType.Admin, webhook.getCreatedUser().getRoleType());
        assertEquals("ja", webhook.getCreatedUser().getLang());
        assertEquals("xxxx@nulab.example", webhook.getCreatedUser().getMailAddress());

        assertEquals("2015-02-13 17:36:59", DateFormatUtils.formatUTC(webhook.getUpdated(), "yyyy-MM-dd HH:mm:ss"));
        assertNotNull(webhook.getUpdatedUser());
        assertEquals(2, webhook.getUpdatedUser().getId());
        assertEquals("developer", webhook.getUpdatedUser().getUserId());
        assertEquals("developer", webhook.getUpdatedUser().getName());
        assertEquals(User.RoleType.User, webhook.getUpdatedUser().getRoleType());
        assertEquals("en", webhook.getUpdatedUser().getLang());
        assertEquals("yyyy@nulab.example", webhook.getUpdatedUser().getMailAddress());

        webhook = webhooks.get(1);
        assertEquals(1079097008, webhook.getId());
        assertEquals("webhook2", webhook.getName());
        assertEquals("this is description", webhook.getDescription());
        assertEquals("http://nulab.test/", webhook.getHookUrl());
        assertTrue(webhook.isAllEvent());
        assertNotNull(webhook.getActivityTypeIds());
        assertEquals(0, webhook.getActivityTypeIds().size());
    }

    @Test
    public void createWebhookTest() throws IOException {
        String fileContentStr = getJsonString("json/webhook.json");
        Webhook webhook = factory.createWebhook(fileContentStr);

        assertEquals(1079196895, webhook.getId());
        assertEquals("webhook", webhook.getName());
        assertEquals("", webhook.getDescription());
        assertEquals("http://nulab.test/", webhook.getHookUrl());
        assertFalse(webhook.isAllEvent());
        assertNotNull(webhook.getActivityTypeIds());
        assertEquals(5, webhook.getActivityTypeIds().size());
        List<Activity.Type> activityTypeIds = webhook.getActivityTypeIds();
        assertEquals(Activity.Type.IssueCreated, activityTypeIds.get(0));
        assertEquals(Activity.Type.IssueUpdated, activityTypeIds.get(1));
        assertEquals(Activity.Type.IssueCommented, activityTypeIds.get(2));
        assertEquals(Activity.Type.IssueDeleted, activityTypeIds.get(3));
        assertEquals(Activity.Type.WikiCreated, activityTypeIds.get(4));

        assertEquals("2014-11-30 01:22:21", DateFormatUtils.formatUTC(webhook.getCreated(), "yyyy-MM-dd HH:mm:ss"));
        assertNotNull(webhook.getCreatedUser());
        assertEquals(1, webhook.getCreatedUser().getId());
        assertEquals("admin", webhook.getCreatedUser().getUserId());
        assertEquals("admin", webhook.getCreatedUser().getName());
        assertEquals(User.RoleType.Admin, webhook.getCreatedUser().getRoleType());
        assertEquals("ja", webhook.getCreatedUser().getLang());
        assertEquals("xxxx@nulab.example", webhook.getCreatedUser().getMailAddress());

        assertEquals("2014-11-30 01:22:21", DateFormatUtils.formatUTC(webhook.getUpdated(), "yyyy-MM-dd HH:mm:ss"));
        assertNotNull(webhook.getUpdatedUser());
        assertEquals(1, webhook.getUpdatedUser().getId());
        assertEquals("admin", webhook.getUpdatedUser().getUserId());
        assertEquals("admin", webhook.getUpdatedUser().getName());
        assertEquals(User.RoleType.Admin, webhook.getUpdatedUser().getRoleType());
        assertEquals("ja", webhook.getUpdatedUser().getLang());
        assertEquals("xxxx@nulab.example", webhook.getUpdatedUser().getMailAddress());
    }

    @Test
    public void equalsTest1() throws IOException {
        String fileContentStr = getJsonString("json/webhook.json");
        Webhook webhook1 = factory.createWebhook(fileContentStr);
        Webhook webhook2 = factory.createWebhook(fileContentStr);
        assertEquals(webhook1, webhook2);
    }

    @Test
    public void hashCodeTest1() throws IOException {
        String fileContentStr = getJsonString("json/webhook.json");
        Webhook webhook1 = factory.createWebhook(fileContentStr);
        Webhook webhook2 = factory.createWebhook(fileContentStr);
        assertEquals(webhook1.hashCode(), webhook2.hashCode());

    }
}
