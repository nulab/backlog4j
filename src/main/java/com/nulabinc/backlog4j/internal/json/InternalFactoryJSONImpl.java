package com.nulabinc.backlog4j.internal.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.auth.AccessToken;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;
import com.nulabinc.backlog4j.internal.InternalFactory;
import com.nulabinc.backlog4j.internal.json.activities.ActivityJSONImpl;
import com.nulabinc.backlog4j.internal.json.auth.AccessTokenJSONImpl;
import com.nulabinc.backlog4j.internal.json.customFields.CustomFieldSettingJSONImpl;


/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InternalFactoryJSONImpl implements InternalFactory {

    @Override
    public AccessToken createAccessToken(BacklogHttpResponse res) throws BacklogException {
        return createAccessToken(res.asString());
    }

    public AccessToken createAccessToken(String resStr) throws BacklogException {
        return createObject(resStr, AccessToken.class, AccessTokenJSONImpl.class);
    }

    @Override
    public Space createSpace(BacklogHttpResponse res) throws BacklogException {
        return createSpace(res.asString());
    }

    public Space createSpace(String resStr) throws BacklogException {
        return createObject(resStr, Space.class, SpaceJSONImpl.class);
    }

    @Override
    public SpaceNotification createSpaceNotification(BacklogHttpResponse res) throws BacklogException {
        return createSpaceNotification(res.asString());
    }

    public SpaceNotification createSpaceNotification(String resStr) throws BacklogException {
        return createObject(resStr, SpaceNotification.class, SpaceNotificationJSONImpl.class);
    }

    @Override
    public DiskUsage createDiskUsage(BacklogHttpResponse res) throws BacklogException {
        return createDiskUsage(res.asString());
    }

    public DiskUsage createDiskUsage(String resStr) throws BacklogException {
        return createObject(resStr, DiskUsage.class, DiskUsageJSONImpl.class);
    }

    @Override
    public DiskUsageDetail createDiskUsageDetail(BacklogHttpResponse res) throws BacklogException {
        return createDiskUsageDetail(res.asString());
    }

    public DiskUsageDetail createDiskUsageDetail(String resStr) throws BacklogException {
        return createObject(resStr, DiskUsageDetail.class, DiskUsageDetailJSONImpl.class);
    }

    @Override
    public ResponseList<Project> createProjectList(BacklogHttpResponse res) throws BacklogException {
        return createProjectList(res.asString());
    }

    public ResponseList<Project> createProjectList(String resStr) throws BacklogException {
        return createObjectList(resStr, Project.class, ProjectJSONImpl[].class);
    }

    @Override
    public Project createProject(BacklogHttpResponse res) throws BacklogException {
        return createProject(res.asString());
    }

    public Project createProject(String resStr) throws BacklogException {
        return createObject(resStr, Project.class, ProjectJSONImpl.class);
    }

    @Override
    public ResponseList<Activity> createActivityList(BacklogHttpResponse res) throws BacklogException {
        return createActivityList(res.asString());
    }

    public ResponseList<Activity> createActivityList(String resStr) throws BacklogException {
        return createObjectList(resStr, Activity.class, ActivityJSONImpl[].class);
    }

    @Override
    public Activity createActivity(BacklogHttpResponse res) throws BacklogException {
        return createActivity(res.asString());
    }

    public Activity createActivity(String resStr) throws BacklogException {
        return createObject(resStr, Activity.class, ActivityJSONImpl.class);
    }

    @Override
    public ResponseList<Issue> createIssueList(BacklogHttpResponse res) throws BacklogException {
        return createIssueList(res.asString());
    }

    public ResponseList<Issue> createIssueList(String resStr) throws BacklogException {
        return createObjectList(resStr, Issue.class, IssueJSONImpl[].class);
    }

    @Override
    public ResponseList<ViewedIssue> createViewedIssueList(BacklogHttpResponse res) throws BacklogException {
        return createViewedIssueList(res.asString());
    }

    public ResponseList<ViewedIssue> createViewedIssueList(String resStr) throws BacklogException {
        return createObjectList(resStr, ViewedIssue.class, ViewedIssueJSONImpl[].class);
    }

    @Override
    public ResponseList<ViewedProject> createViewedProjectList(BacklogHttpResponse res) throws BacklogException {
        return createViewedProjectList(res.asString());
    }

    public ResponseList<ViewedProject> createViewedProjectList(String resStr) throws BacklogException {
        return createObjectList(resStr, ViewedProject.class, ViewedProjectJSONImpl[].class);
    }

    @Override
    public ResponseList<ViewedWiki> createViewedWikiList(BacklogHttpResponse res) throws BacklogException {
        return createViewedWikiList(res.asString());
    }
    public ResponseList<ViewedWiki> createViewedWikiList(String resStr) throws BacklogException {
        return createObjectList(resStr, ViewedWiki.class, ViewedWikiJSONImpl[].class);
    }

    @Override
    public Issue createIssue(BacklogHttpResponse res) throws BacklogException {
        return createIssue(res.asString());
    }
    public Issue createIssue(String resStr) throws BacklogException {
        return createObject(resStr, Issue.class, IssueJSONImpl.class);
    }

    @Override
    public Issue importIssue(BacklogHttpResponse res) throws BacklogException {
        return importIssue(res.asString());
    }

    public Issue importIssue(String resStr) throws BacklogException {
        return createObject(resStr, Issue.class, IssueJSONImpl.class);
    }

    @Override
    public IssueComment createIssueComment(BacklogHttpResponse res) throws BacklogException {
        return createIssueComment(res.asString());
    }
    public IssueComment createIssueComment(String resStr) throws BacklogException {
        return createObject(resStr, IssueComment.class, IssueCommentJSONImpl.class);
    }

    @Override
    public ResponseList<IssueComment> createIssueCommentList(BacklogHttpResponse res) throws BacklogException {
        return createIssueCommentList(res.asString());
    }
    public ResponseList<IssueComment> createIssueCommentList(String resStr) throws BacklogException {
        return createObjectList(resStr, IssueComment.class, IssueCommentJSONImpl[].class);
    }

    @Override
    public User createUser(BacklogHttpResponse res) throws BacklogException {
        return createUser(res.asString());
    }
    public User createUser(String resStr) throws BacklogException {
        return createObject(resStr, User.class, UserJSONImpl.class);
    }

    @Override
    public ResponseList<User> createUserList(BacklogHttpResponse res) throws BacklogException {
        return createUserList(res.asString());
    }
    public ResponseList<User> createUserList(String resStr) throws BacklogException {
        return createObjectList(resStr, User.class, UserJSONImpl[].class);
    }

    @Override
    public IssueType createIssueType(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), IssueType.class, IssueTypeJSONImpl.class);
    }
    public IssueType createIssueType(String resStr) throws BacklogException {
        return createObject(resStr, IssueType.class, IssueTypeJSONImpl.class);
    }

    @Override
    public ResponseList<IssueType> createIssueTypeList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), IssueType.class, IssueTypeJSONImpl[].class);
    }
    public ResponseList<IssueType> createIssueTypeList(String resStr) throws BacklogException {
        return createObjectList(resStr, IssueType.class, IssueTypeJSONImpl[].class);
    }

    @Override
    public Category createCategory(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Category.class, CategoryJSONImpl.class);
    }
    public Category createCategory(String resStr) throws BacklogException {
        return createObject(resStr, Category.class, CategoryJSONImpl.class);
    }

    @Override
    public ResponseList<Category> createCategoryList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Category.class, CategoryJSONImpl[].class);
    }
    public ResponseList<Category> createCategoryList(String resStr) throws BacklogException {
        return createObjectList(resStr, Category.class, CategoryJSONImpl[].class);
    }

    @Override
    public CustomFieldSetting createCustomField(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), CustomFieldSetting.class, CustomFieldSettingJSONImpl.class);
    }
    public CustomFieldSetting createCustomField(String resStr) throws BacklogException {
        return createObject(resStr, CustomFieldSetting.class, CustomFieldSettingJSONImpl.class);
    }

    @Override
    public ResponseList<CustomFieldSetting> createCustomFieldList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), CustomFieldSetting.class, CustomFieldSettingJSONImpl[].class);
    }
    public ResponseList<CustomFieldSetting> createCustomFieldList(String resStr) throws BacklogException {
        return createObjectList(resStr, CustomFieldSetting.class, CustomFieldSettingJSONImpl[].class);
    }

    @Override
    public ResponseList<Priority> createPriorityList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Priority.class, PriorityJSONImpl[].class);
    }
    public ResponseList<Priority> createPriorityList(String resStr) throws BacklogException {
        return createObjectList(resStr, Priority.class, PriorityJSONImpl[].class);
    }

    @Override
    public ResponseList<Resolution> createResolutionList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Resolution.class, ResolutionJSONImpl[].class);
    }
    public ResponseList<Resolution> createResolutionList(String resStr) throws BacklogException {
        return createObjectList(resStr, Resolution.class, ResolutionJSONImpl[].class);
    }

    @Override
    public ResponseList<Status> createStatusList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Status.class, StatusJSONImpl[].class);
    }
    public ResponseList<Status> createStatusList(String resStr) throws BacklogException {
        return createObjectList(resStr, Status.class, StatusJSONImpl[].class);
    }

    @Override
    public Star createStar(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Star.class, StarJSONImpl.class);
    }
    public Star createStar(String resStr) throws BacklogException {
        return createObject(resStr, Star.class, StarJSONImpl.class);
    }

    @Override
    public ResponseList<Star> createStarList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Star.class, StarJSONImpl[].class);
    }
    public ResponseList<Star> createStarList(String resStr) throws BacklogException {
        return createObjectList(resStr, Star.class, StarJSONImpl[].class);
    }

    @Override
    public Count createCount(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Count.class, CountJSONImpl.class);
    }
    public Count createCount(String resStr) throws BacklogException {
        return createObject(resStr, Count.class, CountJSONImpl.class);
    }

    @Override
    public Version createVersion(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Version.class, VersionJSONImpl.class);
    }
    public Version createVersion(String resStr) throws BacklogException {
        return createObject(resStr, Version.class, VersionJSONImpl.class);
    }

    @Override
    public ResponseList<Version> createVersionList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Version.class, VersionJSONImpl[].class);
    }
    public ResponseList<Version> createVersionList(String resStr) throws BacklogException {
        return createObjectList(resStr, Version.class, VersionJSONImpl[].class);
    }

    @Override
    public Milestone createMilestone(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Milestone.class, MilestoneJSONImpl.class);
    }
    public Milestone createMilestone(String resStr) throws BacklogException {
        return createObject(resStr, Milestone.class, MilestoneJSONImpl.class);
    }

    @Override
    public ResponseList<Milestone> createMilestoneList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Milestone.class, MilestoneJSONImpl[].class);
    }
    public ResponseList<Milestone> createMilestoneList(String resStr) throws BacklogException {
        return createObjectList(resStr, Milestone.class, MilestoneJSONImpl[].class);
    }

    @Override
    public Wiki createWiki(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Wiki.class, WikiJSONImpl.class);
    }
    public Wiki createWiki(String resStr) throws BacklogException {
        return createObject(resStr, Wiki.class, WikiJSONImpl.class);
    }

    @Override
    public Wiki importWiki(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Wiki.class, WikiJSONImpl.class);
    }
    public Wiki importWiki(String resStr) throws BacklogException {
        return createObject(resStr, Wiki.class, WikiJSONImpl.class);
    }

    @Override
    public ResponseList<Wiki> createWikiList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Wiki.class, WikiJSONImpl[].class);
    }
    public ResponseList<Wiki> createWikiList(String resStr) throws BacklogException {
        return createObjectList(resStr, Wiki.class, WikiJSONImpl[].class);
    }

    @Override
    public WikiTag createWikiTag(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), WikiTag.class, WikiTagJSONImpl.class);
    }
    public WikiTag createWikiTag(String resStr) throws BacklogException {
        return createObject(resStr, WikiTag.class, WikiTagJSONImpl.class);
    }

    @Override
    public ResponseList<WikiTag> createWikiTagList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), WikiTag.class, WikiTagJSONImpl[].class);
    }
    public ResponseList<WikiTag> createWikiTagList(String resStr) throws BacklogException {
        return createObjectList(resStr, WikiTag.class, WikiTagJSONImpl[].class);
    }

    @Override
    public WikiHistory createWikiHistory(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), WikiHistory.class, WikiHistoryJSONImpl.class);
    }
    public WikiHistory createWikiHistory(String resStr) throws BacklogException {
        return createObject(resStr, WikiHistory.class, WikiHistoryJSONImpl.class);
    }

    @Override
    public ResponseList<WikiHistory> createWikiHistoryList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), WikiHistory.class, WikiHistoryJSONImpl[].class);
    }
    public ResponseList<WikiHistory> createWikiHistoryList(String resStr) throws BacklogException {
        return createObjectList(resStr, WikiHistory.class, WikiHistoryJSONImpl[].class);
    }

    @Override
    public ResponseList<Notification> createNotificationList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Notification.class, NotificationJSONImpl[].class);
    }

    public ResponseList<Notification> createNotificationList(String resStr) throws BacklogException {
        return createObjectList(resStr, Notification.class, NotificationJSONImpl[].class);
    }

    @Override
    public Repository createRepository(BacklogHttpResponse res) throws BacklogException {
        return createRepository(res.asString());
    }

    public Repository createRepository(String resStr) throws BacklogException {
        return createObject(resStr, Repository.class, RepositoryJSONImpl.class);
    }

    @Override
    public ResponseList<Repository> createRepositoryList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Repository.class, RepositoryJSONImpl[].class);
    }

    @Override
    public PullRequest createPullRequest(BacklogHttpResponse res) throws BacklogException {
        return createPullRequest(res.asString());
    }

    public PullRequest createPullRequest(String resStr) throws BacklogException {
        return createObject(resStr, PullRequest.class, PullRequestJSONImpl.class);
    }

    public ResponseList<Repository> createRepositoryList(String resStr) throws BacklogException {
        return createObjectList(resStr, Repository.class, RepositoryJSONImpl[].class);
    }

    @Override
    public ResponseList<PullRequest> createPullRequestList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), PullRequest.class, PullRequestJSONImpl[].class);
    }
    public ResponseList<PullRequest> createPullRequestList(String resStr) throws BacklogException {
        return createObjectList(resStr, PullRequest.class, PullRequestJSONImpl[].class);
    }

    @Override
    public PullRequestComment createPullRequestComment(BacklogHttpResponse res) throws BacklogException {
        return createPullRequestComment(res.asString());
    }

    public PullRequestComment createPullRequestComment(String resStr) throws BacklogException {
        return createObject(resStr, PullRequestComment.class, PullRequestCommentJSONImpl.class);
    }

    @Override
    public ResponseList<PullRequestComment> createPullRequestCommentList(BacklogHttpResponse res) throws BacklogException {
        return createPullRequestCommentList(res.asString());
    }
    public ResponseList<PullRequestComment> createPullRequestCommentList(String resStr) throws BacklogException {
        return createObjectList(resStr, PullRequestComment.class, PullRequestCommentJSONImpl[].class);
    }

    @Override
    public SharedFile createSharedFile(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), SharedFile.class, SharedFileJSONImpl.class);
    }
    public SharedFile createSharedFile(String resStr) throws BacklogException {
        return createObject(resStr, SharedFile.class, SharedFileJSONImpl.class);
    }

    @Override
    public ResponseList<SharedFile> createSharedFileList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), SharedFile.class, SharedFileJSONImpl[].class);
    }
    public ResponseList<SharedFile> createSharedFileList(String resStr) throws BacklogException {
        return createObjectList(resStr, SharedFile.class, SharedFileJSONImpl[].class);
    }

    @Override
    public Attachment createAttachment(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Attachment.class, AttachmentJSONImpl.class);
    }

    public Attachment createAttachment(String resStr) throws BacklogException {
        return createObject(resStr, Attachment.class, AttachmentJSONImpl.class);
    }

    @Override
    public Group createGroup(BacklogHttpResponse res) throws BacklogException {
        return createGroup(res.asString());
    }

    public Group createGroup(String resStr) throws BacklogException {
        return createObject(resStr, Group.class, GroupJSONImpl.class);
    }

    @Override
    public ResponseList<Group> createGroupList(BacklogHttpResponse res) throws BacklogException {
        return createGroupList(res.asString());
    }

    public ResponseList<Group> createGroupList(String resStr) throws BacklogException {
        return createObjectList(resStr, Group.class, GroupJSONImpl[].class);
    }

    @Override
    public ResponseList<Attachment> createAttachmentList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Attachment.class, AttachmentJSONImpl[].class);
    }
    public ResponseList<Attachment> createAttachmentList(String resStr) throws BacklogException {
        return createObjectList(resStr, Attachment.class, AttachmentJSONImpl[].class);
    }

    @Override
    public ResponseList<Webhook> createWebhookList(BacklogHttpResponse res) throws BacklogException {
        return createWebhookList(res.asString());
    }
    public ResponseList<Webhook> createWebhookList(String resStr) throws BacklogException {
        return createObjectList(resStr, Webhook.class, WebhookJSONImpl[].class);
    }

    @Override
    public Webhook createWebhook(BacklogHttpResponse res) throws BacklogException {
        return createObject(res.asString(), Webhook.class, WebhookJSONImpl.class);
    }
    public Webhook createWebhook(String resStr) throws BacklogException {
        return createObject(resStr, Webhook.class, WebhookJSONImpl.class);
    }

    @Override
    public Watch createWatch(BacklogHttpResponse res) throws BacklogException {
        return createWatch(res.asString());
    }

    @Override
    public ResponseList<Watch> createWatchList(BacklogHttpResponse res) throws BacklogException {
        return createObjectList(res.asString(), Watch.class, WatchJSONImpl[].class);
    }

    public Watch createWatch(String resStr) throws BacklogException {
        return createObject(resStr, Watch.class, WatchJSONImpl.class);
    }

    private <T1 , T2 extends T1> ResponseList<T1> createObjectList(String content, Class<T1> clazz1, Class<T2[]> clazz2) throws BacklogException {
        T1[] arrays = Jackson.fromJsonString(content, clazz2);
        ResponseList<T1> list = new ResponseListImpl<T1>();
        for (int i = 0; i < arrays.length; i++) {
            list.add(arrays[i]);
        }
        return list;
    }

    private <T1 , T2 extends T1> T1 createObject(String content, Class<T1> clazz1, Class<T2> clazz2) throws BacklogException {
        T1 obj = Jackson.fromJsonString(content, clazz2);
        return obj;
    }
}
