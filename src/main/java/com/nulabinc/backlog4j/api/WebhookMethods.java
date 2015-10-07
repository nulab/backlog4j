package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.Webhook;
import com.nulabinc.backlog4j.api.option.CreateWebhookParams;
import com.nulabinc.backlog4j.api.option.UpdateWebhookParams;

/**
 * Executes Backlog Webhook APIs.
 *
 * @author nulab-inc
 */
public interface WebhookMethods {

    /**
     * Returns all the webhooks.
     *
     * @param projectIdOrKey the project key
     * @return the webhooks in a list.
     * @throws BacklogException
     */
    ResponseList<Webhook> getWebhooks(Object projectIdOrKey) throws BacklogException;

    /**
     * Create a webhook.
     *
     * @param params the creating webhook parameters.
     * @return the created webhook
     * @throws com.nulabinc.backlog4j.BacklogException
     */
    Webhook createWebhook(CreateWebhookParams params) throws BacklogException;

    /**
     * Returns the webhook.
     *
     * @param projectIdOrKey the project identifier
     * @param webhookId the webhook identifier
     * @return the Webhook
     * @throws com.nulabinc.backlog4j.BacklogException
     */
    Webhook getWebhook(Object projectIdOrKey, Object webhookId) throws BacklogException;

    /**
     * Updates the existing webhook.
     *
     * @param params the updating webhook parameters
     * @return the updated Webhook
     * @throws com.nulabinc.backlog4j.BacklogException
     */
    Webhook updateWebhook(UpdateWebhookParams params) throws BacklogException;

    /**
     * Deletes the existing webhook.
     *
     * @param projectIdOrKey the project key
     * @param webhookId the webhook identifier
     * @return the deleted webhook
     * @throws com.nulabinc.backlog4j.BacklogException
     */
    Webhook deleteWebhook(Object projectIdOrKey, Object webhookId) throws BacklogException;
}
