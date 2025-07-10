package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.api.*;
import com.nulabinc.backlog4j.auth.OAuthSupport;

/**
 * Executes all Backlog APIs.
 *
 * @author nulab-inc
 */
public interface BacklogClient extends ProjectMethods, IssueMethods, SpaceMethods,
        WikiMethods, DocumentMethods, ResolutionMethods, StatusMethods, PriorityMethods, UserMethods,
        StarMethods, NotificationMethods, GitMethods, PullRequestMethods, GroupMethods, WebhookMethods, WatchingMethods,
        BacklogUrlSupport {

    void setOAuthSupport(OAuthSupport oAuthSupport);
}
