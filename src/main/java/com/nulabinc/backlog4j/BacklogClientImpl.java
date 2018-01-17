package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.api.option.*;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.http.BacklogHttpClient;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;
import com.nulabinc.backlog4j.http.NameValuePair;
import com.nulabinc.backlog4j.internal.file.AttachmentDataImpl;
import com.nulabinc.backlog4j.internal.file.IconImpl;
import com.nulabinc.backlog4j.internal.file.SharedFileDataImpl;
import com.nulabinc.backlog4j.internal.json.ResponseListImpl;
import com.nulabinc.backlog4j.internal.json.customFields.*;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Implementation of BacklogClient.
 *
 * @author nulab-inc
 */
public class BacklogClientImpl extends BacklogClientBase implements BacklogClient {

    public BacklogClientImpl(BacklogConfigure configure) {
        super(configure);
    }

    public BacklogClientImpl(BacklogConfigure configure, BacklogHttpClient httpClient) {
        super(configure, httpClient);
    }

    @Override
    public Space getSpace() throws BacklogException {
        return factory.createSpace(get(buildEndpoint("space")));
    }

    @Override
    public ResponseList<Activity> getSpaceActivities() throws BacklogException {
        return getSpaceActivities(null);
    }

    @Override
    public ResponseList<Activity> getSpaceActivities(ActivityQueryParams params) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("space/activities"), params));
    }

    @Override
    public Icon getSpaceIcon() throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(backlogEndPointSupport.getSpaceIconEndpoint());
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new IconImpl(filename, inputStream);
    }

    @Override
    public SpaceNotification getSpaceNotification() throws BacklogException {
        return factory.createSpaceNotification(get(buildEndpoint("space/notification")));
    }

    @Override
    public SpaceNotification updateSpaceNotification(String content) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("content", content));
        return factory.createSpaceNotification(put(buildEndpoint("space/notification"), params));
    }

    @Override
    public DiskUsage getSpaceDiskUsage() throws BacklogException {
        return factory.createDiskUsage(get(buildEndpoint("space/diskUsage")));
    }

    @Override
    public Attachment postAttachment(AttachmentData attachmentData) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("file", attachmentData);
        BacklogHttpResponse backlogHttpResponse = postMultiPart(buildEndpoint("space/attachment"), parameters);
        return factory.createAttachment(backlogHttpResponse);
    }

    @Override
    public ResponseList<Project> getProjects() throws BacklogException {
        return factory.createProjectList(get(buildEndpoint("projects")));
    }

    @Override
    public Project createProject(CreateProjectParams params) throws BacklogException {
        return factory.createProject(post(buildEndpoint("projects"), params));
    }

    @Override
    public Project getProject(Object projectIdOrKey) throws BacklogException {
        return factory.createProject(get(buildEndpoint("projects/" + projectIdOrKey)));
    }

    @Override
    public Project updateProject(UpdateProjectParams params) throws BacklogException {
        return factory.createProject(patch(buildEndpoint("projects/" + params.getProjectIdOrKeyString()), params));
    }

    @Override
    public Project deleteProject(Object projectIdOrKey) throws BacklogException {
        return factory.createProject(delete(buildEndpoint("projects/" + projectIdOrKey)));
    }

    @Override
    public Icon getProjectIcon(Object projectIdOrKey) throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(backlogEndPointSupport.getProjectIconEndpoint(projectIdOrKey));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new IconImpl(filename, inputStream);
    }

    @Override
    public ResponseList<Activity> getProjectActivities(Object projectIdOrKey) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("projects/" + projectIdOrKey + "/activities")));
    }

    @Override
    public ResponseList<Activity> getProjectActivities(Object projectIdOrKey, ActivityQueryParams query) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("projects/" + projectIdOrKey + "/activities"), query));
    }

    @Override
    public ResponseList<User> getProjectUsers(Object projectIdOrKey) throws BacklogException {
        return factory.createUserList(get(buildEndpoint("projects/" + projectIdOrKey + "/users")));
    }

    @Override
    public User addProjectUser(Object projectIdOrKey, Object userId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("userId", String.valueOf(userId)));
        return factory.createUser(post(buildEndpoint("projects/" + projectIdOrKey + "/users"), params));
    }

    @Override
    public User removeProjectUser(Object projectIdOrKey, Object userId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("projects/" + projectIdOrKey + "/users"),
                new NameValuePair("userId", String.valueOf(userId))));
    }

    @Override
    public User addProjectAdministrator(Object projectIdOrKey, Object userId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("userId", String.valueOf(userId)));
        return factory.createUser(post(buildEndpoint("projects/" + projectIdOrKey + "/administrators"), params));
    }

    @Override
    public ResponseList<User> getProjectAdministrators(Object projectIdOrKey) throws BacklogException {
        return factory.createUserList(get(buildEndpoint("projects/" + projectIdOrKey + "/administrators")));
    }

    @Override
    public User removeProjectAdministrator(Object projectIdOrKey, Object userId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("projects/" + projectIdOrKey + "/administrators"),
                new NameValuePair("userId", String.valueOf(userId))));
    }

    @Override
    public ResponseList<IssueType> getIssueTypes(Object projectIdOrKey) throws BacklogException {
        return factory.createIssueTypeList(get(buildEndpoint("projects/" + projectIdOrKey + "/issueTypes")));
    }

    @Override
    public IssueType addIssueType(AddIssueTypeParams params) throws BacklogException {
        return factory.createIssueType(post(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/issueTypes"), params));
    }

    @Override
    public IssueType updateIssueType(UpdateIssueTypeParams params) throws BacklogException {
        return factory.createIssueType(patch(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString() +
                        "/issueTypes/" + params.getIssueTypeId()), params));
    }

    @Override
    public IssueType removeIssueType(Object projectIdOrKey, Object issueTypeId, Object substituteIssueTypeId) throws BacklogException {
        return factory.createIssueType(delete(buildEndpoint("projects/" + projectIdOrKey + "/issueTypes/" + issueTypeId),
                new NameValuePair("substituteIssueTypeId", String.valueOf(substituteIssueTypeId))));
    }

    @Override
    public ResponseList<Category> getCategories(Object projectIdOrKey) throws BacklogException {
        return factory.createCategoryList(get(buildEndpoint("projects/" + projectIdOrKey + "/categories")));
    }

    @Override
    public Category addCategory(AddCategoryParams params) throws BacklogException {
        return factory.createCategory(post(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/categories"), params));
    }

    @Override
    public Category updateCategory(UpdateCategoryParams params) throws BacklogException {
        return factory.createCategory(patch(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString()
                        + "/categories/" + params.getCategoryId()), params));
    }

    @Override
    public Category removeCategory(Object projectIdOrKey, Object categoryId) throws BacklogException {
        return factory.createCategory(delete(buildEndpoint("projects/" + projectIdOrKey + "/categories/" + categoryId)));
    }

    @Override
    public ResponseList<Version> getVersions(Object projectIdOrKey) throws BacklogException {
        return factory.createVersionList(get(buildEndpoint("projects/" + projectIdOrKey + "/versions")));
    }

    @Override
    public Version addVersion(AddVersionParams params) throws BacklogException {
        return factory.createVersion(post(buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/versions"), params));
    }

    @Override
    public Version updateVersion(UpdateVersionParams params) throws BacklogException {
        return factory.createVersion(patch(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString()
                        + "/versions/" + params.getVersionId()), params));
    }

    @Override
    public Version removeVersion(Object projectIdOrKey, Object versionId) throws BacklogException {
        return factory.createVersion(delete(buildEndpoint("projects/" + projectIdOrKey + "/versions/" + versionId)));
    }

    @Override
    public ResponseList<Milestone> getMilestones(Object projectIdOrKey) throws BacklogException {
        ResponseList<Milestone> list = new ResponseListImpl<Milestone>();
        for (Milestone milestone : factory.createMilestoneList(get(buildEndpoint("projects/" + projectIdOrKey + "/versions")))) {
            if (!milestone.getArchived()) {
                list.add(milestone);
            }
        }
        return list;
    }

    @Override
    public Milestone addMilestone(AddMilestoneParams params) throws BacklogException {
        return factory.createMilestone(post(buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/versions"), params));
    }

    @Override
    public Milestone updateMilestone(UpdateMilestoneParams params) throws BacklogException {
        return factory.createMilestone(patch(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString()
                        + "/versions/" + params.getVersionId()), params));
    }

    @Override
    public Milestone removeMilestone(Object projectIdOrKey, Object MilestoneId) throws BacklogException {
        return factory.createMilestone(delete(buildEndpoint("projects/" + projectIdOrKey + "/versions/" + MilestoneId)));
    }

    @Override
    public ResponseList<CustomFieldSetting> getCustomFields(Object projectIdOrKey) throws BacklogException {
        return factory.createCustomFieldList(get(buildEndpoint("projects/" + projectIdOrKey + "/customFields")));
    }

    @Override
    public TextCustomFieldSetting addTextCustomField(AddTextCustomFieldParams params) throws BacklogException {
        return (TextCustomFieldSetting) addCustomField(params);
    }

    @Override
    public TextAreaCustomFieldSetting addTextAreaCustomField(AddTextAreaCustomFieldParams params) throws BacklogException {
        return (TextAreaCustomFieldSetting) addCustomField(params);
    }

    @Override
    public NumericCustomFieldSetting addNumericCustomField(AddNumericCustomFieldParams params) throws BacklogException {
        return (NumericCustomFieldSetting) addCustomField(params);
    }

    @Override
    public DateCustomFieldSetting addDateCustomField(AddDateCustomFieldParams params) throws BacklogException {
        return (DateCustomFieldSetting) addCustomField(params);
    }

    @Override
    public SingleListCustomFieldSetting addSingleListCustomField(AddSingleListCustomFieldParams params) throws BacklogException {
        return (SingleListCustomFieldSetting) addCustomField(params);
    }

    @Override
    public MultipleListCustomFieldSetting addMultipleListCustomField(AddMultipleListCustomFieldParams params) throws BacklogException {
        return (MultipleListCustomFieldSetting) addCustomField(params);
    }

    @Override
    public RadioCustomFieldSetting addRadioCustomField(AddRadioCustomFieldParams params) throws BacklogException {
        return (RadioCustomFieldSetting) addCustomField(params);
    }

    @Override
    public CheckBoxCustomFieldSetting addCheckBoxCustomField(AddCheckBoxCustomFieldParams params) throws BacklogException {
        return (CheckBoxCustomFieldSetting) addCustomField(params);
    }

    @Override
    public TextCustomFieldSetting updateTextCustomField(UpdateTextCustomFieldParams params) throws BacklogException {
        return (TextCustomFieldSetting) updateCustomField(params);
    }

    @Override
    public TextAreaCustomFieldSetting updateTextAreaCustomField(UpdateTextAreaCustomFieldParams params) throws BacklogException {
        return (TextAreaCustomFieldSetting) updateCustomField(params);
    }

    @Override
    public NumericCustomFieldSetting updateNumericCustomField(UpdateNumericCustomFieldParams params) throws BacklogException {
        return (NumericCustomFieldSetting) updateCustomField(params);
    }

    @Override
    public DateCustomFieldSetting updateDateCustomField(UpdateDateCustomFieldParams params) throws BacklogException {
        return (DateCustomFieldSetting) updateCustomField(params);
    }

    @Override
    public SingleListCustomFieldSetting updateSingleListCustomField(UpdateSingleListCustomFieldParams params) throws BacklogException {
        return (SingleListCustomFieldSetting) updateCustomField(params);
    }

    @Override
    public MultipleListCustomFieldSetting updateMultipleListCustomField(UpdateMultipleListCustomFieldParams params) throws BacklogException {
        return (MultipleListCustomFieldSetting) updateCustomField(params);
    }

    @Override
    public RadioCustomFieldSetting updateRadioCustomField(UpdateRadioCustomFieldParams params) throws BacklogException {
        return (RadioCustomFieldSetting) updateCustomField(params);
    }

    @Override
    public CheckBoxCustomFieldSetting updateCheckBoxCustomField(UpdateCheckBoxCustomFieldParams params) throws BacklogException {
        return (CheckBoxCustomFieldSetting) updateCustomField(params);
    }

    private CustomFieldSetting addCustomField(AddCustomFieldParams params) throws BacklogException {
        return factory.createCustomField(post(buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/customFields"), params));
    }

    private CustomFieldSetting updateCustomField(UpdateCustomFieldParams params) throws BacklogException {
        return factory.createCustomField(patch(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/customFields/" + params.getCustomFiledId()), params));
    }

    @Override
    public CustomFieldSetting removeCustomField(Object projectIdOrKey, Object customFieldId) throws BacklogException {
        return factory.createCustomField(delete(buildEndpoint("projects/" + projectIdOrKey + "/customFields/" + customFieldId)));
    }

    @Override
    public CustomFieldSetting addListCustomFieldItem(Object projectIdOrKey, Object customFieldId, String name) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("name", name));
        return factory.createCustomField(post(buildEndpoint("projects/" + projectIdOrKey + "/customFields/" + customFieldId + "/items"), params));
    }

    @Override
    public CustomFieldSetting updateListCustomFieldItem(Object projectIdOrKey, Object customFieldId, Object itemId, String name) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("name", name));
        return factory.createCustomField(patch(
                buildEndpoint("projects/" + projectIdOrKey + "/customFields/" + customFieldId + "/items/" + itemId), params));
    }

    @Override
    public CustomFieldSetting removeListCustomFieldItem(Object projectIdOrKey, Object customFieldId, Object itemId) throws BacklogException {
        return factory.createCustomField(delete(buildEndpoint("projects/" + projectIdOrKey + "/customFields/" + customFieldId + "/items/" + itemId)));
    }

    @Override
    public ResponseList<SharedFile> getSharedFiles(Object projectIdOrKey, String path) throws BacklogException {
        return getSharedFiles(projectIdOrKey, path, new QueryParams());
    }

    @Override
    public ResponseList<SharedFile> getSharedFiles(Object projectIdOrKey, String path, QueryParams queryParams) throws BacklogException {
        try {
            String encodedPath = URLEncoder.encode(path, "utf-8");
            return factory.createSharedFileList(get(buildEndpoint("projects/" + projectIdOrKey + "/files/metadata/" + encodedPath), queryParams));
        } catch (UnsupportedEncodingException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public SharedFileData downloadSharedFile(Object projectIdOrKey, Object sharedFileId) throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(backlogEndPointSupport.getSharedFileEndpoint(projectIdOrKey, sharedFileId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new SharedFileDataImpl(filename, inputStream);
    }

    @Override
    public DiskUsageDetail getProjectDiskUsage(Object projectIdOrKey) throws BacklogException {
        return factory.createDiskUsageDetail(get(buildEndpoint("projects/" + projectIdOrKey + "/diskUsage")));
    }

    @Override
    public ResponseList<Issue> getIssues(GetIssuesParams params) throws BacklogException {
        return factory.createIssueList(get(buildEndpoint("issues"), params));
    }

    @Override
    public int getIssuesCount(GetIssuesCountParams params) throws BacklogException {
        return factory.createCount(get(buildEndpoint("issues/count"), params)).getCount();
    }

    @Override
    public Issue createIssue(CreateIssueParams params) throws BacklogException {
        return factory.createIssue(post(buildEndpoint("issues"), params));
    }

    @Override
    public Issue importIssue(ImportIssueParams params) throws BacklogException {
        return factory.importIssue(post(buildEndpoint("issues/import"), params));
    }

    @Override
    public Issue updateIssue(UpdateIssueParams params) throws BacklogException {
        return factory.createIssue(patch(buildEndpoint("issues/" + params.getIssueIdOrKeyString()), params));
    }

    @Override
    public Issue importUpdateIssue(ImportUpdateIssueParams params) throws BacklogException {
        return factory.createIssue(patch(buildEndpoint("issues/" + params.getIssueIdOrKeyString() + "/import"), params));
    }

    @Override
    public Attachment importDeleteAttachment(Object issueIdOrKey, Object attachmentId, ImportDeleteAttachmentParams params) throws BacklogException {
        return factory.createAttachment(delete(buildEndpoint("issues/" + issueIdOrKey + "/attachments/import/" + attachmentId), params));
    }

    @Override
    public Issue deleteIssue(Object issueIdOrKey) throws BacklogException {
        return factory.createIssue(delete(buildEndpoint("issues/" + issueIdOrKey)));
    }

    @Override
    public Issue getIssue(Object issueIdOrKey) throws BacklogException {
        return factory.createIssue(get(buildEndpoint("issues/" + issueIdOrKey)));
    }

    @Override
    public ResponseList<IssueComment> getIssueComments(Object issueIdOrKey) throws BacklogException {
        return factory.createIssueCommentList(get(buildEndpoint("issues/" + issueIdOrKey + "/comments")));
    }

    @Override
    public ResponseList<IssueComment> getIssueComments(Object issueIdOrKey, QueryParams queryParams) throws BacklogException {
        return factory.createIssueCommentList(get(buildEndpoint("issues/" + issueIdOrKey + "/comments"), queryParams));
    }

    @Override
    public IssueComment addIssueComment(AddIssueCommentParams params) throws BacklogException {
        return factory.createIssueComment(post(buildEndpoint("issues/" + params.getIssueIdOrKeyString() + "/comments"), params));
    }

    @Override
    public int getIssueCommentCount(Object issueIdOrKey) throws BacklogException {
        return factory.createCount(get(buildEndpoint("issues/" + issueIdOrKey + "/comments/count")))
                .getCount();
    }

    @Override
    public IssueComment getIssueComment(Object issueIdOrKey, Object commentId) throws BacklogException {
        return factory.createIssueComment(get(buildEndpoint("issues/" + issueIdOrKey + "/comments/" + commentId)));
    }

    @Override
    public IssueComment updateIssueComment(UpdateIssueCommentParams params) throws BacklogException {
        return factory.createIssueComment(patch(
                buildEndpoint("issues/" + params.getIssueIdOrKeyString()
                        + "/comments/" + params.getCommentId()), params));
    }

    @Override
    public ResponseList<Notification> getIssueCommentNotifications(Object issueIdOrKey, Object commentId) throws BacklogException {
        return factory.createNotificationList(get(buildEndpoint("issues/" + issueIdOrKey
                + "/comments/" + commentId + "/notifications")));
    }

    @Override
    public IssueComment addIssueCommentNotification(AddIssueCommentNotificationParams params) throws BacklogException {
        return factory.createIssueComment(post(buildEndpoint(
                "issues/" + params.getIssueIdOrKeyString()
                        + "/comments/" + params.getCommentId()
                        + "/notifications"), params));

    }

    @Override
    public ResponseList<Attachment> getIssueAttachments(Object issueIdOrKey) {
        return factory.createAttachmentList(get(buildEndpoint("issues/" + issueIdOrKey + "/attachments")));
    }

    @Override
    public AttachmentData downloadIssueAttachment(Object issueIdOrKey, Object attachmentId) {
        BacklogHttpResponse backlogHttpResponse = get(backlogEndPointSupport.getIssueAttachmentEndpoint(issueIdOrKey, attachmentId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new AttachmentDataImpl(filename, inputStream);
    }

    @Override
    public Attachment deleteIssueAttachment(Object issueIdOrKey, Object attachmentId) {
        return factory.createAttachment(delete(buildEndpoint("issues/" + issueIdOrKey + "/attachments/" + attachmentId)));
    }

    @Override
    public ResponseList<SharedFile> getIssueSharedFiles(Object issueIdOrKey) {
        return factory.createSharedFileList(get(buildEndpoint("issues/" + issueIdOrKey + "/sharedFiles")));
    }

    @Override
    public ResponseList<SharedFile> linkIssueSharedFile(Object issueIdOrKey, List fileIds) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Object fileId : fileIds) {
            params.add(new NameValuePair("fileId[]", fileId.toString()));
        }
        return factory.createSharedFileList(post(buildEndpoint("issues/" + issueIdOrKey + "/sharedFiles"), params));
    }

    @Override
    public SharedFile unlinkIssueSharedFile(Object issueIdOrKey, Object fileId) {
        return factory.createSharedFile(delete(buildEndpoint("issues/" + issueIdOrKey + "/sharedFiles/" + fileId)));
    }

    @Override
    public ResponseList<Wiki> getWikis(Object projectIdOrKey) {
        GetParams params = new GetWikisParams(projectIdOrKey);
        return factory.createWikiList(get(buildEndpoint("wikis"), params));
    }

    @Override
    public ResponseList<Wiki> getWikis(GetWikisParams params) {
        ResponseList<Wiki> wikis = factory.createWikiList(get(buildEndpoint("wikis"), params));
        // API でソート出来ないのでここでソートする
        sortWikis(wikis, params.getSort(), params.getOrder());
        return wikis;
    }

    public static void sortWikis(ResponseList<Wiki> wikis,
                                 final GetWikisParams.SortKey sort,
                                 final GetWikisParams.Order order) {
        if (sort != null && order != null) {
            Collections.sort(wikis, new Comparator<Wiki>() {
                @Override
                public int compare(Wiki wiki1, Wiki wiki2) {
                    switch (sort) {
                        case Name:
                            String name1 = wiki1.getName();
                            String name2 = wiki2.getName();
                            return order.equals(GetWikisParams.Order.Asc) ?
                                    name1.compareTo(name2) : name2.compareTo(name1);
                        case Created:
                            Date created1 = wiki1.getCreated();
                            Date created2 = wiki2.getCreated();
                            return order.equals(GetWikisParams.Order.Asc) ?
                                    created1.compareTo(created2) : created2.compareTo(created1);
                        case Updated:
                            Date updated1 = wiki1.getUpdated();
                            Date updated2 = wiki2.getUpdated();
                            return order.equals(GetWikisParams.Order.Asc) ?
                                    updated1.compareTo(updated2) : updated2.compareTo(updated1);
                    }
                    return 0;
                }
            });
        }
    }

    @Override
    public int getWikiCount(Object projectIdOrKey) {
        GetParams params = new GetWikisParams(projectIdOrKey);
        return factory.createCount(get(buildEndpoint("wikis/count"), params)).getCount();
    }

    @Override
    public ResponseList<WikiTag> getWikiTags(Object projectIdOrKey) {

        GetParams params = new GetWikiTagsParams(projectIdOrKey);
        return factory.createWikiTagList(get(buildEndpoint("wikis/tags"), params));
    }

    @Override
    public Wiki createWiki(CreateWikiParams params) {
        return factory.createWiki(post(buildEndpoint("wikis"), params));
    }

    @Override
    public Wiki importWiki(ImportWikiParams params) {
        return factory.importWiki(post(buildEndpoint("wikis/import"), params));
    }

    @Override
    public Wiki getWiki(Object wikiId) {
        return factory.createWiki(get(buildEndpoint("wikis/" + wikiId)));
    }

    @Override
    public Wiki updateWiki(UpdateWikiParams params) {
        return factory.createWiki(patch(
                buildEndpoint("wikis/" + params.getWikiId()), params));
    }

    @Override
    public Wiki deleteWiki(Object wikiId, boolean mailNotify) {
        return factory.createWiki(delete(
                buildEndpoint("wikis/" + wikiId),
                new NameValuePair("mailNotify", String.valueOf(mailNotify))));
    }

    @Override
    public ResponseList<Attachment> getWikiAttachments(Object wikiId) {
        return factory.createAttachmentList(get(buildEndpoint("wikis/" + wikiId + "/attachments")));
    }

    @Override
    public ResponseList<Attachment> addWikiAttachment(AddWikiAttachmentParams params) {
        return factory.createAttachmentList(post(buildEndpoint("wikis/" + params.getWikiId() + "/attachments"), params));
    }

    @Override
    public AttachmentData downloadWikiAttachment(Object wikiId, Object attachmentId) {
        BacklogHttpResponse backlogHttpResponse = get(backlogEndPointSupport.getWikiAttachmentEndpoint(wikiId, attachmentId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new AttachmentDataImpl(filename, inputStream);
    }

    @Override
    public Attachment deleteWikiAttachment(Object wikiId, Object attachmentId) {
        return factory.createAttachment(delete(buildEndpoint("wikis/" + wikiId + "/attachments/" + attachmentId)));
    }

    @Override
    public ResponseList<SharedFile> getWikiSharedFiles(Object wikiId) {
        return factory.createSharedFileList(get(buildEndpoint("wikis/" + wikiId + "/sharedFiles")));
    }

    @Override
    public ResponseList<SharedFile> linkWikiSharedFile(Object wikiId, List fileIds) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Object fileId : fileIds) {
            params.add(new NameValuePair("fileId[]", fileId.toString()));
        }
        return factory.createSharedFileList(post(buildEndpoint("wikis/" + wikiId + "/sharedFiles"), params));
    }

    @Override
    public SharedFile unlinkWikiSharedFile(Object wikiId, Object fileId) {
        return factory.createSharedFile(delete(buildEndpoint("wikis/" + wikiId + "/sharedFiles/" + fileId)));
    }

    @Override
    public ResponseList<WikiHistory> getWikiHistories(Object wikiId) {
        return factory.createWikiHistoryList(get(buildEndpoint("wikis/" + wikiId + "/history")));
    }

    @Override
    public ResponseList<WikiHistory> getWikiHistories(Object wikiId, QueryParams params) {
        return factory.createWikiHistoryList(get(buildEndpoint("wikis/" + wikiId + "/history"), params));
    }

    @Override
    public ResponseList<Star> getWikiStars(Object wikiId) {
        return factory.createStarList(get(buildEndpoint("wikis/" + wikiId + "/stars")));
    }

    @Override
    public ResponseList<Priority> getPriorities() throws BacklogException {
        return factory.createPriorityList(get(buildEndpoint("priorities")));
    }

    @Override
    public ResponseList<Resolution> getResolutions() throws BacklogException {
        return factory.createResolutionList(get(buildEndpoint("resolutions")));
    }

    @Override
    public ResponseList<Status> getStatuses() throws BacklogException {
        return factory.createStatusList(get(buildEndpoint("statuses")));
    }

    @Override
    public Icon getUserIcon(Object numericUserId) {
        BacklogHttpResponse backlogHttpResponse = get(backlogEndPointSupport.getUserIconEndpoint(numericUserId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new IconImpl(filename, inputStream);
    }

    @Override
    public ResponseList<Activity> getUserActivities(Object numericUserId) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("users/" + numericUserId + "/activities")));
    }

    @Override
    public ResponseList<Activity> getUserActivities(Object numericUserId, ActivityQueryParams queryParams) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("users/" + numericUserId + "/activities"), queryParams));
    }

    @Override
    public ResponseList<Star> getUserStars(Object numericUserId) throws BacklogException {
        return factory.createStarList(get(buildEndpoint("users/" + numericUserId + "/stars")));
    }

    @Override
    public ResponseList<Star> getUserStars(Object numericUserId, QueryParams queryParams) throws BacklogException {
        return factory.createStarList(get(buildEndpoint("users/" + numericUserId + "/stars"), queryParams));
    }

    @Override
    public int getUserStarCount(Object numericUserId, GetStarsParams params) throws BacklogException {
        return factory.createCount(get(buildEndpoint("users/" + numericUserId + "/stars/count"), params))
                .getCount();
    }

    @Override
    public ResponseList<ViewedIssue> getRecentlyViewedIssues() throws BacklogException {
        return factory.createViewedIssueList(get(buildEndpoint("users/myself/recentlyViewedIssues")));
    }

    @Override
    public ResponseList<ViewedIssue> getRecentlyViewedIssues(OffsetParams params) throws BacklogException {
        return factory.createViewedIssueList(get(buildEndpoint("users/myself/recentlyViewedIssues"), params));
    }

    @Override
    public ResponseList<ViewedProject> getRecentlyViewedProjects() throws BacklogException {
        return factory.createViewedProjectList(get(buildEndpoint("users/myself/recentlyViewedProjects")));
    }

    @Override
    public ResponseList<ViewedProject> getRecentlyViewedProjects(OffsetParams params) throws BacklogException {
        return factory.createViewedProjectList(get(buildEndpoint("users/myself/recentlyViewedProjects"), params));
    }

    @Override
    public ResponseList<ViewedWiki> getRecentlyViewedWikis() throws BacklogException {
        return factory.createViewedWikiList(get(buildEndpoint("users/myself/recentlyViewedWikis")));
    }

    @Override
    public ResponseList<ViewedWiki> getRecentlyViewedWikis(OffsetParams params) throws BacklogException {
        return factory.createViewedWikiList(get(buildEndpoint("users/myself/recentlyViewedWikis"), params));
    }

    @Override
    public ResponseList<User> getUsers() throws BacklogException {
        return factory.createUserList(get(buildEndpoint("users")));
    }

    @Override
    public User getUser(Object numericUserId) throws BacklogException {
        return factory.createUser(get(buildEndpoint("users/" + numericUserId)));
    }

    @Override
    public User createUser(CreateUserParams params) throws BacklogException {
        return factory.createUser(post(buildEndpoint("users"), params));
    }

    @Override
    public User deleteUser(Object numericUserId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("users/" + numericUserId)));
    }

    @Override
    public User getMyself() {
        return factory.createUser(get(buildEndpoint("users/myself")));
    }

    @Override
    public void addStarToIssue(Object issueId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("issueId", String.valueOf(issueId)));
        post(buildEndpoint("stars"), params);
    }

    @Override
    public void addStarToComment(Object commentId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("commentId", String.valueOf(commentId)));
        post(buildEndpoint("stars"), params);
    }

    @Override
    public void addStarToWiki(Object wikiId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("wikiId", String.valueOf(wikiId)));
        post(buildEndpoint("stars"), params);
    }

    @Override
    public void addStarToPullRequest(Object pullRequestId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("pullRequestId", String.valueOf(pullRequestId)));
        post(buildEndpoint("stars"), params);
    }

    @Override
    public void addStarToPullRequestComment(Object pullRequestCommentId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("pullRequestCommentId", String.valueOf(pullRequestCommentId)));
        post(buildEndpoint("stars"), params);
    }

    @Override
    public ResponseList<Notification> getNotifications() throws BacklogException {
        return factory.createNotificationList(get(buildEndpoint("notifications")));
    }

    @Override
    public ResponseList<Notification> getNotifications(QueryParams params) throws BacklogException {
        return factory.createNotificationList(get(buildEndpoint("notifications"), params));
    }

    @Override
    public int getNotificationCount(GetNotificationCountParams params) throws BacklogException {
        return factory.createCount(get(buildEndpoint("notifications/count"), params))
                .getCount();
    }

    @Override
    public int resetNotificationCount() throws BacklogException {
        return factory.createCount(post(buildEndpoint("notifications/markAsRead")))
                .getCount();
    }

    @Override
    public void markAsReadNotification(Object notificationId) throws BacklogException {
        post(buildEndpoint("notifications/" + notificationId + "/markAsRead"));
    }

    @Override
    public ResponseList<Repository> getGitRepositories(Object projectIdOrKey) throws BacklogException {
        GetParams params = new GetRepositoriesParams(projectIdOrKey.toString());
        return factory.createRepositoryList(get(buildEndpoint("git/repositories"), params));
    }

    @Override
    public Repository getGitRepository(Object projectIdOrKey, Object repoIdOrName) throws BacklogException {
        return factory.createRepository(get(buildEndpoint(
                "projects/" + projectIdOrKey.toString() +
                        "/git/repositories/" + repoIdOrName.toString())));
    }

    @Override
    public ResponseList<PullRequest> getPullRequests(Object projectIdOrKey, Object repoIdOrName) throws BacklogException {
        return factory.createPullRequestList(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests")));
    }

    @Override
    public ResponseList<PullRequest> getPullRequests(Object projectIdOrKey, Object repoIdOrName, PullRequestQueryParams params) throws BacklogException {
        return factory.createPullRequestList(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests"), params));
    }

    @Override
    public int getPullRequestCount(Object projectIdOrKey, Object repoIdOrName) throws BacklogException {
        return factory.createCount(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests/count"))).getCount();
    }

    @Override
    public int getPullRequestCount(Object projectIdOrKey, Object repoIdOrName, PullRequestQueryParams params) throws BacklogException {
        return factory.createCount(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests/count"), params)).getCount();
    }

    @Override
    public PullRequest addPullRequest(AddPullRequestParams params) throws BacklogException {
        return factory.createPullRequest(post(buildEndpoint(
                "projects/" + params.getProjectIdOrKeyString() +
                        "/git/repositories/" + params.getRepoIdOrNameString() +
                        "/pullRequests"), params));
    }

    @Override
    public PullRequest updatePullRequest(UpdatePullRequestParams params) throws BacklogException {

        return factory.createPullRequest(patch(buildEndpoint(
                "projects/" + params.getProjectIdOrKeyString() +
                        "/git/repositories/" + params.getRepoIdOrNameString() +
                        "/pullRequests/" + params.getNumber()), params));
    }

    @Override
    public PullRequest getPullRequest(Object projectIdOrKey, Object repoIdOrName, Object number) throws BacklogException {
        return factory.createPullRequest(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests/" + number)));
    }

    @Override
    public ResponseList<PullRequestComment> getPullRequestComments(Object projectIdOrKey, Object repoIdOrName, Object number, QueryParams params) throws BacklogException {
        return factory.createPullRequestCommentList(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests/" + number +
                        "/comments"), params));
    }

    @Override
    public PullRequestComment addPullRequestComment(AddPullRequestCommentParams params) throws BacklogException {
        return factory.createPullRequestComment(post(buildEndpoint(
                "projects/" + params.getProjectIdOrKeyString() +
                        "/git/repositories/" + params.getRepoIdOrName() +
                        "/pullRequests/" + params.getNumber() +
                        "/comments"), params));
    }

    @Override
    public int getPullRequestCommentCount(Object projectIdOrKey, Object repoIdOrName, Object number) throws BacklogException {
        return factory.createCount(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests/" + number +
                        "/comments/count"))).getCount();
    }

    @Override
    public PullRequestComment updatePullRequestComment(UpdatePullRequestCommentParams params) throws BacklogException {
        return factory.createPullRequestComment(patch(buildEndpoint(
                "projects/" + params.getProjectIdOrKeyString() +
                        "/git/repositories/" + params.getRepoIdOrName() +
                        "/pullRequests/" + params.getNumber() +
                        "/comments/" + params.getCommentId()), params));
    }

    @Override
    public ResponseList<Attachment> getPullRequestAttachments(Object projectIdOrKey, Object repoIdOrName, Object number) throws BacklogException {
        return factory.createAttachmentList(get(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests/" + number +
                        "/attachments")));
    }

    @Override
    public AttachmentData downloadPullRequestAttachment(Object projectIdOrKey, Object repoIdOrName, Object number, Object attachmentId) throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(backlogEndPointSupport.getPullRequestAttachmentEndpoint(projectIdOrKey, repoIdOrName, number, attachmentId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new AttachmentDataImpl(filename, inputStream);
    }

    @Override
    public Attachment deletePullRequestAttachment(Object projectIdOrKey, Object repoIdOrName, Object number, Object attachmentId) throws BacklogException {
        return factory.createAttachment(delete(buildEndpoint(
                "projects/" + projectIdOrKey +
                        "/git/repositories/" + repoIdOrName +
                        "/pullRequests/" + number +
                        "/attachments/" + attachmentId)));
    }

    @Override
    public ResponseList<Group> getGroups() throws BacklogException {
        return factory.createGroupList(get(buildEndpoint("groups")));
    }

    @Override
    public ResponseList<Group> getGroups(OffsetParams params) throws BacklogException {
        return factory.createGroupList(get(buildEndpoint("groups"), params));
    }

    @Override
    public Group createGroup(CreateGroupParams params) throws BacklogException {
        return factory.createGroup(post(buildEndpoint("groups"), params));
    }

    @Override
    public Group getGroup(Object groupId) throws BacklogException {
        return factory.createGroup(get(buildEndpoint("groups/" + groupId)));
    }

    @Override
    public Group updateGroup(UpdateGroupParams params) throws BacklogException {
        return factory.createGroup(patch(buildEndpoint("groups/" + params.getGroupId()), params));
    }

    @Override
    public Group deleteGroup(Object groupId) throws BacklogException {
        return factory.createGroup(delete(buildEndpoint("groups/" + groupId)));
    }

    @Override
    public ResponseList<Webhook> getWebhooks(Object projectIdOrKey) throws BacklogException {
        return factory.createWebhookList(get(buildEndpoint("projects/" + projectIdOrKey + "/webhooks")));
    }

    @Override
    public Webhook createWebhook(CreateWebhookParams params) throws BacklogException {
        return factory.createWebhook(post(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/webhooks"), params));
    }

    @Override
    public Webhook getWebhook(Object projectIdOrKey, Object webhookId) throws BacklogException {
        return factory.createWebhook(get(buildEndpoint("projects/" + projectIdOrKey + "/webhooks/" + webhookId)));
    }

    @Override
    public Webhook updateWebhook(UpdateWebhookParams params) throws BacklogException {
        return factory.createWebhook(patch(
                buildEndpoint("projects/" + params.getProjectIdOrKeyString() + "/webhooks/" + params.getWebhookId()), params));
    }

    @Override
    public Webhook deleteWebhook(Object projectIdOrKey, Object webhookId) throws BacklogException {
        return factory.createWebhook(delete(
                buildEndpoint("projects/" + projectIdOrKey + "/webhooks/" + webhookId)));
    }

    @Override
    public String getPullRequestUrl(Project project, Repository repository, PullRequest pullRequest) {
        return configure.getWebAppBaseURL() + "/git/" + project.getProjectKey() + "/" +
                repository.getName() + "/pullRequests/" + pullRequest.getNumber();
    }

    @Override
    public String getPullRequestCommentUrl(Project project, Repository repository, PullRequest pullRequest, PullRequestComment pullRequestComment) {
        return getPullRequestUrl(project, repository, pullRequest) + "#comment-" + pullRequestComment.getId();
    }

    @Override
    public String getIssueUrl(Issue issue) {
        return configure.getWebAppBaseURL() + "/view/" + issue.getIssueKey();
    }

    @Override
    public String getIssueCommentUrl(Issue issue, IssueComment issueComment) {
        return getIssueUrl(issue) + "#comment-" + issueComment.getId();
    }

    @Override
    public String getWikiUrl(Project project, Wiki wiki) {
        try {
            return configure.getWebAppBaseURL() + "/wiki/" + project.getProjectKey() + "/" + URLEncoder.encode(wiki.getName(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Watch getWatch(Long watchingId) throws BacklogException {
        return factory.createWatch(get(buildEndpoint("watchings/" + watchingId)));
    }

    @Override
    public int getUserWatchCount(Object numericUserId, GetWatchesParams params) throws BacklogException {
        return factory.createCount(get(buildEndpoint("users/" + numericUserId + "/watchings/count"), params)).getCount();
    }

    @Override
    public ResponseList<Watch> getUserWatches(Object numericUserId) throws BacklogException {
        return factory.createWatchList(get(buildEndpoint("users/" + numericUserId + "/watchings")));
    }

    @Override
    public Watch addWatchToIssue(Object issueIdOrKey, String note) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("issueIdOrKey", String.valueOf(issueIdOrKey)));
        if (note != null) {
            params.add(new NameValuePair("note", note));
        }
        return factory.createWatch(post(buildEndpoint("watchings"), params));
    }

    @Override
    public Watch updateWatch(UpdateWatchParams params) throws BacklogException {
        return factory.createWatch(patch(buildEndpoint("watchings/" + params.getWatchingIdString()), params));
    }

    @Override
    public Watch deleteWatch(Object watchingId) throws BacklogException {
        return factory.createWatch(delete(buildEndpoint("watchings/" + watchingId)));
    }

    @Override
    public void markAsCheckedUserWatches(Object numericUserId) throws BacklogException {
        post(buildEndpoint("users/" + numericUserId + "/watchings/markAsChecked"));
    }

}
