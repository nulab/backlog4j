package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.api.*;
import com.nulabinc.backlog4j.auth.OAuthSupport;

/**
 * Executes all Backlog APIs.
 *
 * @author nulab-inc
 */
public interface BacklogClient extends ProjectMethods, IssueMethods, SpaceMethods,
        WikiMethods, ResolutionMethods, StatusMethods, PriorityMethods, UserMethods,
        StarMethods, NotificationMethods, GitMethods, PullRequestMethods, GroupMethods, WebhookMethods {

    void setOAuthSupport(OAuthSupport oAuthSupport);
}
