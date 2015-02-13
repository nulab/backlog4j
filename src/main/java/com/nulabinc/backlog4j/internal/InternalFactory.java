package com.nulabinc.backlog4j.internal;


import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.auth.AccessToken;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;

/**
 * @author nulab-inc
 */
public interface InternalFactory {

    AccessToken createAccessToken(BacklogHttpResponse res) throws BacklogException;

    Space createSpace(BacklogHttpResponse res) throws BacklogException;

    SpaceNotification createSpaceNotification(BacklogHttpResponse res) throws BacklogException;

    DiskUsage createDiskUsage(BacklogHttpResponse res) throws BacklogException;

    DiskUsageDetail createDiskUsageDetail(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Project> createProjectList(BacklogHttpResponse res) throws BacklogException;

    Project createProject(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Activity> createActivityList(BacklogHttpResponse res) throws BacklogException;

    Activity createActivity(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Issue> createIssueList(BacklogHttpResponse res) throws BacklogException;

    Issue createIssue(BacklogHttpResponse res) throws BacklogException;

    ResponseList<IssueComment> createIssueCommentList(BacklogHttpResponse res) throws BacklogException;

    IssueComment createIssueComment(BacklogHttpResponse res) throws BacklogException;

    ResponseList<User> createUserList(BacklogHttpResponse res) throws BacklogException;

    User createUser(BacklogHttpResponse res) throws BacklogException;

    ResponseList<IssueType> createIssueTypeList(BacklogHttpResponse res) throws BacklogException;

    IssueType createIssueType(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Category> createCategoryList(BacklogHttpResponse res) throws BacklogException;

    Category createCategory(BacklogHttpResponse res) throws BacklogException;

    ResponseList<CustomFieldSetting> createCustomFieldList(BacklogHttpResponse res) throws BacklogException;

    CustomFieldSetting createCustomField(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Priority> createPriorityList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Resolution> createResolutionList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Status> createStatusList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Star> createStarList(BacklogHttpResponse res) throws BacklogException;

    Star createStar(BacklogHttpResponse res) throws BacklogException;

    Count createCount(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Version> createVersionList(BacklogHttpResponse res) throws BacklogException;

    Version createVersion(BacklogHttpResponse res) throws BacklogException;

    Wiki createWiki(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Wiki> createWikiList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<WikiTag> createWikiTagList(BacklogHttpResponse res) throws BacklogException;

    WikiHistory createWikiHistory(BacklogHttpResponse res) throws BacklogException;

    WikiTag createWikiTag(BacklogHttpResponse res) throws BacklogException;

    ResponseList<WikiHistory> createWikiHistoryList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Notification> createNotificationList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Repository> createRepositoryList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<ViewedIssue> createViewedIssueList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<ViewedProject> createViewedProjectList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<ViewedWiki> createViewedWikiList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<SharedFile> createSharedFileList(BacklogHttpResponse res) throws BacklogException;

    SharedFile createSharedFile(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Attachment> createAttachmentList(BacklogHttpResponse res) throws BacklogException;

    Attachment createAttachment(BacklogHttpResponse res) throws BacklogException;

    Group createGroup(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Group> createGroupList(BacklogHttpResponse res) throws BacklogException;

    ResponseList<Webhook> createWebhookList(BacklogHttpResponse res) throws BacklogException;

    Webhook createWebhook(BacklogHttpResponse res) throws BacklogException;
}
