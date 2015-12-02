package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.conf.BacklogConfigure;

/**
 * Support class for icon file.
 *
 * @author nulab-inc
 */
public class BacklogEndPointSupport {

    private BacklogConfigure configure;

    public BacklogEndPointSupport(BacklogConfigure backlogConfigure){
        this.configure = backlogConfigure;
    }

    /**
     * Returns the endpoint of space icon.
     *
     * @return the endpoint
     * @throws BacklogException
     */
    public String getSpaceIconEndpoint() throws BacklogException {
        return buildEndpoint("space/image");
    }

    /**
     * Returns the endpoint of project icon.
     *
     * @param projectIdOrKey the project identifier
     * @return the endpoint
     * @throws BacklogException
     */
    public String getProjectIconEndpoint(Object projectIdOrKey) throws BacklogException {
        return buildEndpoint("projects/" + projectIdOrKey + "/image");
    }

    /**
     * Returns the endpoint of user icon.
     *
     * @param numericUserId the user identifier
     * @return the endpoint
     * @throws BacklogException
     */
    public String getUserIconEndpoint(Object numericUserId) throws BacklogException {
        return buildEndpoint("users/" + numericUserId + "/icon");
    }

    /**
     * Returns the endpoint of shared file.
     *
     * @param projectIdOrKey    the project identifier
     * @param sharedFileId      the shared file identifier
     * @return the endpoint
     * @throws BacklogException
     */
    public String getSharedFileEndpoint(Object projectIdOrKey, Object sharedFileId) throws BacklogException {
        return buildEndpoint("projects/" + projectIdOrKey + "/files/" + sharedFileId);
    }

    /**
     * Returns the endpoint of attachment file.
     *
     * @param issueIdOrKey     the issue identifier
     * @param attachmentId the attachment identifierr
     * @return the endpoint
     * @throws BacklogException
     */
    public String getIssueAttachmentEndpoint(Object issueIdOrKey, Object attachmentId) throws BacklogException {
        return buildEndpoint("issues/" + issueIdOrKey + "/attachments/" + attachmentId);
    }

    /**
     * Returns the endpoint of Wiki page's attachment file.
     *
     * @param wikiId       the Wiki page identifier
     * @param attachmentId the attachment identifier
     * @return the endpoint
     * @throws BacklogException
     */
    public String getWikiAttachmentEndpoint(Object wikiId, Object attachmentId) throws BacklogException {
        return buildEndpoint("wikis/" + wikiId + "/attachments/" + attachmentId);
    }

    /**
     * Returns the endpoint of attachment file.
     *
     * @param projectIdOrKey the project identifier
     * @param repoIdOrName the repository name
     * @param number the pull request identifier
     * @param attachmentId the pull request attachment identifier
     * @return the endpoint
     */
    public String getPullRequestAttachmentEndpoint(Object projectIdOrKey, Object repoIdOrName, Object number, Object attachmentId) {
        return buildEndpoint("projects/" + projectIdOrKey +
                "/git/repositories/" + repoIdOrName +
                "/pullRequests/" + number +
                "/attachments/" + attachmentId);
    }

    protected String buildEndpoint(String connection) {
        return configure.getRestBaseURL() + "/" + connection;
    }
}
