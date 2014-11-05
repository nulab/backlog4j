package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.api.option.*;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.http.BacklogHttpClient;
import com.nulabinc.backlog4j.http.BacklogHttpResponse;
import com.nulabinc.backlog4j.internal.file.AttachmentDataImpl;
import com.nulabinc.backlog4j.internal.file.IconImpl;
import com.nulabinc.backlog4j.internal.file.SharedFileDataImpl;
import com.nulabinc.backlog4j.internal.json.customFields.*;
import com.nulabinc.backlog4j.http.NameValuePair;
import com.nulabinc.backlog4j.http.NameValuePair;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("space/image"));
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
        params.add(new NameValuePair("content", String.valueOf(content)));
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
    public Project getProject(long projectId) throws BacklogException {
        return factory.createProject(get(buildEndpoint("projects/" + projectId)));
    }

    @Override
    public Project getProject(String projectKey) throws BacklogException {
        return factory.createProject(get(buildEndpoint("projects/" + projectKey)));
    }

    @Override
    public Project updateProject(UpdateProjectParams params) throws BacklogException {
        return factory.createProject(patch(buildEndpoint("projects/" + params.getProjectIdOrKeyString()), params));
    }

    @Override
    public Project deleteProject(long projectId) throws BacklogException {
        return factory.createProject(delete(buildEndpoint("projects/" + projectId)));
    }

    @Override
    public Project deleteProject(String projectKey) throws BacklogException {
        return factory.createProject(delete(buildEndpoint("projects/" + projectKey)));
    }

    @Override
    public Icon getProjectIcon(long projectId) throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("projects/" + projectId + "/image"));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new IconImpl(filename, inputStream);
    }

    @Override
    public Icon getProjectIcon(String projectKey) throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("projects/" + projectKey + "/image"));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new IconImpl(filename, inputStream);
    }

    @Override
    public ResponseList<Activity> getProjectActivities(long projectId) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("projects/" + projectId + "/activities")));
    }

    @Override
    public ResponseList<Activity> getProjectActivities(String projectKey) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("projects/" + projectKey + "/activities")));
    }

    @Override
    public ResponseList<Activity> getProjectActivities(long projectId, ActivityQueryParams query) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("projects/" + projectId + "/activities"), query));
    }

    @Override
    public ResponseList<Activity> getProjectActivities(String projectKey, ActivityQueryParams query) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("projects/" + projectKey + "/activities"), query));
    }

    @Override
    public ResponseList<User> getProjectUsers(long projectId) throws BacklogException {
        return factory.createUserList(get(buildEndpoint("projects/" + projectId + "/users")));
    }

    @Override
    public ResponseList<User> getProjectUsers(String projectKey) throws BacklogException {
        return factory.createUserList(get(buildEndpoint("projects/" + projectKey + "/users")));
    }

    @Override
    public User addProjectUser(long projectId, long userId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("userId", String.valueOf(userId)));
        return factory.createUser(post(buildEndpoint("projects/" + projectId + "/users"), params));
    }

    @Override
    public User addProjectUser(String projectKey, long userId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("userId", String.valueOf(userId)));
        return factory.createUser(post(buildEndpoint("projects/" + projectKey + "/users"), params));
    }

    @Override
    public User removeProjectUser(long projectId, long userId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("projects/" + projectId + "/users"),
                new NameValuePair("userId", String.valueOf(userId))));
    }

    @Override
    public User removeProjectUser(String projectKey, long userId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("projects/" + projectKey + "/users"),
                new NameValuePair("userId", String.valueOf(userId))));
    }

    @Override
    public User addProjectAdministrator(long projectId, long userId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("userId", String.valueOf(userId)));
        return factory.createUser(post(buildEndpoint("projects/" + projectId + "/administrators"), params));
    }

    @Override
    public User addProjectAdministrator(String projectKey, long userId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("userId", String.valueOf(userId)));
        return factory.createUser(post(buildEndpoint("projects/" + projectKey + "/administrators"), params));
    }

    @Override
    public ResponseList<User> getProjectAdministrators(long projectId) throws BacklogException {
        return factory.createUserList(get(buildEndpoint("projects/" + projectId + "/administrators")));
    }

    @Override
    public ResponseList<User> getProjectAdministrators(String projectKey) throws BacklogException {
        return factory.createUserList(get(buildEndpoint("projects/" + projectKey + "/administrators")));
    }

    @Override
    public User removeProjectAdministrator(long projectId, long userId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("projects/" + projectId + "/administrators"),
                new NameValuePair("userId", String.valueOf(userId))));
    }

    @Override
    public User removeProjectAdministrator(String projectKey, long userId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("projects/" + projectKey + "/administrators"),
                new NameValuePair("userId", String.valueOf(userId))));
    }

    @Override
    public ResponseList<IssueType> getIssueTypes(long projectId) throws BacklogException {
        return factory.createIssueTypeList(get(buildEndpoint("projects/" + projectId + "/issueTypes")));
    }

    @Override
    public ResponseList<IssueType> getIssueTypes(String projectKey) throws BacklogException {
        return factory.createIssueTypeList(get(buildEndpoint("projects/" + projectKey + "/issueTypes")));
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
    public IssueType removeIssueType(long projectId, long issueTypeId, long substituteIssueTypeId) throws BacklogException {
        return factory.createIssueType(delete(buildEndpoint("projects/" + projectId + "/issueTypes/" + issueTypeId),
                new NameValuePair("substituteIssueTypeId", String.valueOf(substituteIssueTypeId))));
    }

    @Override
    public IssueType removeIssueType(String projectKey, long issueTypeId, long substituteIssueTypeId) throws BacklogException {
        return factory.createIssueType(delete(buildEndpoint("projects/" + projectKey + "/issueTypes/" + issueTypeId),
                new NameValuePair("substituteIssueTypeId", String.valueOf(substituteIssueTypeId))));
    }

    @Override
    public ResponseList<Category> getCategories(long projectId) throws BacklogException {
        return factory.createCategoryList(get(buildEndpoint("projects/" + projectId + "/categories")));
    }

    @Override
    public ResponseList<Category> getCategories(String projectKey) throws BacklogException {
        return factory.createCategoryList(get(buildEndpoint("projects/" + projectKey + "/categories")));
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
    public Category removeCategory(long projectId, long categoryId) throws BacklogException {
        return factory.createCategory(delete(buildEndpoint("projects/" + projectId + "/categories/" + categoryId)));
    }

    @Override
    public Category removeCategory(String projectKey, long categoryId) throws BacklogException {
        return factory.createCategory(delete(buildEndpoint("projects/" + projectKey + "/categories/" + categoryId)));
    }

    @Override
    public ResponseList<Version> getVersions(long projectId) throws BacklogException {
        return factory.createVersionList(get(buildEndpoint("projects/" + projectId + "/versions")));
    }

    @Override
    public ResponseList<Version> getVersions(String projectKey) throws BacklogException {
        return factory.createVersionList(get(buildEndpoint("projects/" + projectKey + "/versions")));
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
    public Version removeVersion(long projectId, long versionId) throws BacklogException {
        return factory.createVersion(delete(buildEndpoint("projects/" + projectId + "/versions/" + versionId)));
    }

    @Override
    public Version removeVersion(String projectKey, long versionId) throws BacklogException {
        return factory.createVersion(delete(buildEndpoint("projects/" + projectKey + "/versions/" + versionId)));
    }

    @Override
    public ResponseList<CustomFieldSetting> getCustomFields(long projectId) throws BacklogException {
        return factory.createCustomFieldList(get(buildEndpoint("projects/" + projectId + "/customFields")));
    }

    @Override
    public ResponseList<CustomFieldSetting> getCustomFields(String projectKey) throws BacklogException {
        return factory.createCustomFieldList(get(buildEndpoint("projects/" + projectKey + "/customFields")));
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
    public CustomFieldSetting removeCustomField(long projectId, long customFieldId) throws BacklogException {
        return factory.createCustomField(delete(buildEndpoint("projects/" + projectId + "/customFields/" + customFieldId)));
    }

    @Override
    public CustomFieldSetting removeCustomField(String projectKey, long customFieldId) throws BacklogException {
        return factory.createCustomField(delete(buildEndpoint("projects/" + projectKey + "/customFields/" + customFieldId)));
    }

    @Override
    public CustomFieldSetting addListCustomFieldItem(long projectId, long customFieldId, String name) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("name", name));
        return factory.createCustomField(post(buildEndpoint("projects/" + projectId + "/customFields/" + customFieldId + "/items"), params));
    }

    @Override
    public CustomFieldSetting addListCustomFieldItem(String projectKey, long customFieldId, String name) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("name", name));
        return factory.createCustomField(post(buildEndpoint("projects/" + projectKey + "/customFields/" + customFieldId + "/items"), params));
    }

    @Override
    public CustomFieldSetting updateListCustomFieldItem(long projectId, long customFieldId, long itemId, String name) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("name", name));
        return factory.createCustomField(patch(
                buildEndpoint("projects/" + projectId + "/customFields/" + customFieldId + "/items/" + itemId), params));
    }

    @Override
    public CustomFieldSetting updateListCustomFieldItem(String projectKey, long customFieldId, long itemId, String name) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("name", name));
        return factory.createCustomField(patch(
                buildEndpoint("projects/" + projectKey + "/customFields/" + customFieldId + "/items/" + itemId), params));
    }

    @Override
    public CustomFieldSetting removeListCustomFieldItem(long projectId, long customFieldId, long itemId) throws BacklogException {
        return factory.createCustomField(delete(buildEndpoint("projects/" + projectId + "/customFields/" + customFieldId + "/items/" + itemId)));
    }

    @Override
    public CustomFieldSetting removeListCustomFieldItem(String projectKey, long customFieldId, long itemId) throws BacklogException {
        return factory.createCustomField(delete(buildEndpoint("projects/" + projectKey + "/customFields/" + customFieldId + "/items/" + itemId)));
    }

    @Override
    public ResponseList<SharedFile> getSharedFiles(long projectId, String path) throws BacklogException {
        try {
            String encodedPath = URLEncoder.encode(path, "utf-8");
            return factory.createSharedFileList(get(buildEndpoint("projects/" + projectId + "/files/metadata/" + encodedPath)));
        } catch (UnsupportedEncodingException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public ResponseList<SharedFile> getSharedFiles(String projectKey, String path) throws BacklogException {
        try {
            String encodedPath = URLEncoder.encode(path, "utf-8");
            return factory.createSharedFileList(get(buildEndpoint("projects/" + projectKey + "/files/metadata/" + encodedPath)));
        } catch (UnsupportedEncodingException e) {
            throw new BacklogAPIException(e);
        }
    }

    @Override
    public SharedFileData downloadSharedFile(long projectId, long sharedFileId) throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("projects/" + projectId + "/files/" + sharedFileId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new SharedFileDataImpl(filename, inputStream);
    }

    @Override
    public SharedFileData downloadSharedFile(String projectKey, long sharedFileId) throws BacklogException {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("projects/" + projectKey + "/files/" + sharedFileId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new SharedFileDataImpl(filename, inputStream);
    }

    @Override
    public DiskUsageDetail getProjectDiskUsage(long projectId) throws BacklogException {
        return factory.createDiskUsageDetail(get(buildEndpoint("projects/" + projectId + "/diskUsage")));
    }

    @Override
    public DiskUsageDetail getProjectDiskUsage(String projectKey) throws BacklogException {
        return factory.createDiskUsageDetail(get(buildEndpoint("projects/" + projectKey + "/diskUsage")));
    }

    @Override
    public ResponseList<Issue> getIssues(GetIssuesParams params) throws BacklogException {
        return factory.createIssueList(get(buildEndpoint("issues"), params));
    }

    @Override
    public Count getIssuesCount(GetIssuesParams params) throws BacklogException {
        return factory.createCount(get(buildEndpoint("issues/count"), params));
    }

    @Override
    public Issue createIssue(CreateIssueParams params) throws BacklogException {
        return factory.createIssue(post(buildEndpoint("issues"), params));
    }

    @Override
    public Issue updateIssue(UpdateIssueParams params) throws BacklogException {
        return factory.createIssue(patch(buildEndpoint("issues/" + params.getIssueIdOrKeyString()), params));
    }

    @Override
    public Issue deleteIssue(long issueId) throws BacklogException {
        return factory.createIssue(delete(buildEndpoint("issues/" + issueId)));
    }

    @Override
    public Issue deleteIssue(String issueKey) throws BacklogException {
        return factory.createIssue(delete(buildEndpoint("issues/" + issueKey)));
    }

    @Override
    public Issue getIssue(long issueId) throws BacklogException {
        return factory.createIssue(get(buildEndpoint("issues/" + issueId)));
    }

    @Override
    public Issue getIssue(String issueKey) throws BacklogException {
        return factory.createIssue(get(buildEndpoint("issues/" + issueKey)));
    }

    @Override
    public ResponseList<IssueComment> getIssueComments(long issueId) throws BacklogException {
        return factory.createIssueCommentList(get(buildEndpoint("issues/" + issueId + "/comments")));
    }

    @Override
    public ResponseList<IssueComment> getIssueComments(String issueKey) throws BacklogException {
        return factory.createIssueCommentList(get(buildEndpoint("issues/" + issueKey + "/comments")));
    }

    @Override
    public ResponseList<IssueComment> getIssueComments(long issueId, QueryParams queryParams) throws BacklogException {
        return factory.createIssueCommentList(get(buildEndpoint("issues/" + issueId + "/comments"), queryParams));
    }

    @Override
    public ResponseList<IssueComment> getIssueComments(String issueKey, QueryParams queryParams) throws BacklogException {
        return factory.createIssueCommentList(get(buildEndpoint("issues/" + issueKey + "/comments"), queryParams));
    }

    @Override
    public IssueComment addIssueComment(AddIssueCommentParams params) throws BacklogException {
        return factory.createIssueComment(post(buildEndpoint("issues/" + params.getIssueIdOrKeyString() + "/comments"), params));
    }

    @Override
    public int getIssueCommentCount(long issueId) throws BacklogException {
        return factory.createCount(get(buildEndpoint("issues/" + issueId + "/comments/count")))
                .getCount();
    }

    @Override
    public int getIssueCommentCount(String issueKey) throws BacklogException {
        return factory.createCount(get(buildEndpoint("issues/" + issueKey + "/comments/count")))
                .getCount();
    }

    @Override
    public IssueComment getIssueComment(long issueId, long commentId) throws BacklogException {
        return factory.createIssueComment(get(buildEndpoint("issues/" + issueId + "/comments/" + commentId)));
    }

    @Override
    public IssueComment getIssueComment(String issueKey, long commentId) throws BacklogException {
        return factory.createIssueComment(get(buildEndpoint("issues/" + issueKey + "/comments/" + commentId)));
    }

    @Override
    public IssueComment updateIssueComment(UpdateIssueCommentParams params) throws BacklogException {
        return factory.createIssueComment(patch(
                buildEndpoint("issues/" + params.getIssueIdOrKeyString()
                        + "/comments/" + params.getCommentId()), params));
    }

    @Override
    public ResponseList<Notification> getIssueCommentNotifications(long issueId, long commentId) throws BacklogException {
        return factory.createNotificationList(get(buildEndpoint("issues/" + issueId
                + "/comments/" + commentId + "/notifications")));
    }

    @Override
    public ResponseList<Notification> getIssueCommentNotifications(String issueKey, long commentId) throws BacklogException {
        return factory.createNotificationList(get(buildEndpoint("issues/" + issueKey
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
    public ResponseList<Attachment> getIssueAttachments(long issueId) {
        return factory.createAttachmentList(get(buildEndpoint("issues/" + issueId + "/attachments")));
    }

    @Override
    public ResponseList<Attachment> getIssueAttachments(String issueKey) {
        return factory.createAttachmentList(get(buildEndpoint("issues/" + issueKey + "/attachments")));
    }

    @Override
    public AttachmentData downloadIssueAttachment(long issueId, long attachmentId) {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("issues/" + issueId + "/attachments/" + attachmentId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new AttachmentDataImpl(filename, inputStream);
    }

    @Override
    public AttachmentData downloadIssueAttachment(String issueKey, long attachmentId) {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("issues/" + issueKey + "/attachments/" + attachmentId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new AttachmentDataImpl(filename, inputStream);
    }

    @Override
    public Attachment deleteIssueAttachment(long issueId, long attachmentId) {
        return factory.createAttachment(delete(buildEndpoint("issues/" + issueId + "/attachments/" + attachmentId)));
    }

    @Override
    public Attachment deleteIssueAttachment(String issueKey, long attachmentId) {
        return factory.createAttachment(delete(buildEndpoint("issues/" + issueKey + "/attachments/" + attachmentId)));
    }

    @Override
    public ResponseList<SharedFile> getIssueSharedFiles(long issueId) {
        return factory.createSharedFileList(get(buildEndpoint("issues/" + issueId + "/sharedFiles")));
    }

    @Override
    public ResponseList<SharedFile> getIssueSharedFiles(String issueKey) {
        return factory.createSharedFileList(get(buildEndpoint("issues/" + issueKey + "/sharedFiles")));
    }

    @Override
    public ResponseList<SharedFile> linkIssueSharedFile(long issueId, List<Long> fileIds) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Long fileId : fileIds) {
            params.add(new NameValuePair("fileId[]", fileId.toString()));
        }
        return factory.createSharedFileList(post(buildEndpoint("issues/" + issueId + "/sharedFiles"), params));
    }

    @Override
    public ResponseList<SharedFile> linkIssueSharedFile(String issueKey, List<Long> fileIds) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Long fileId : fileIds) {
            params.add(new NameValuePair("fileId[]", fileId.toString()));
        }
        return factory.createSharedFileList(post(buildEndpoint("issues/" + issueKey + "/sharedFiles"), params));
    }

    @Override
    public SharedFile unlinkIssueSharedFile(long issueId, long fileId) {
        return factory.createSharedFile(delete(buildEndpoint("issues/" + issueId + "/sharedFiles/" + fileId)));
    }

    @Override
    public SharedFile unlinkIssueSharedFile(String issueKey, long fileId) {
        return factory.createSharedFile(delete(buildEndpoint("issues/" + issueKey + "/sharedFiles/" + fileId)));
    }

    @Override
    public ResponseList<Wiki> getWikis(long projectId) {
        GetParams params = new GetWikisParams(projectId);
        return factory.createWikiList(get(buildEndpoint("wikis"), params));
    }

    @Override
    public ResponseList<Wiki> getWikis(String projectKey) {
        GetParams params = new GetWikisParams(projectKey);
        return factory.createWikiList(get(buildEndpoint("wikis"), params));
    }

    @Override
    public Count getWikiCount(long projectId) {
        GetParams params = new GetWikisParams(projectId);
        return factory.createCount(get(buildEndpoint("wikis/count"), params));
    }

    @Override
    public Count getWikiCount(String projectKey) {
        GetParams params = new GetWikisParams(projectKey);
        return factory.createCount(get(buildEndpoint("wikis/count"), params));
    }

    @Override
    public ResponseList<WikiTag> getWikiTags(long projectId) {
        GetParams params = new GetWikiTagsParams(projectId);
        return factory.createWikiTagList(get(buildEndpoint("wikis/tags"), params));
    }

    @Override
    public ResponseList<WikiTag> getWikiTags(String projectKey) {

        GetParams params = new GetWikiTagsParams(projectKey);
        return factory.createWikiTagList(get(buildEndpoint("wikis/tags"), params));
    }

    @Override
    public Wiki createWiki(CreateWikiParams params) {
        return factory.createWiki(post(buildEndpoint("wikis"), params));
    }

    @Override
    public Wiki getWiki(long wikiId) {
        return factory.createWiki(get(buildEndpoint("wikis/" + wikiId)));
    }

    @Override
    public Wiki updateWiki(UpdateWikiParams params) {
        return factory.createWiki(patch(
                buildEndpoint("wikis/" + params.getWikiId()), params));
    }

    @Override
    public Wiki deleteWiki(long wikiId, boolean mailNotify) {
        return factory.createWiki(delete(
                buildEndpoint("wikis/" + wikiId),
                new NameValuePair("mailNotify", String.valueOf(mailNotify))));
    }

    @Override
    public ResponseList<Attachment> getWikiAttachments(long wikiId) {
        return factory.createAttachmentList(get(buildEndpoint("wikis/" + wikiId + "/attachments")));
    }

    @Override
    public ResponseList<Attachment> addWikiAttachment(AddWikiAttachmentParams params) {
        return factory.createAttachmentList(post(buildEndpoint("wikis/" + params.getWikiId() + "/attachments"), params));
    }

    @Override
    public AttachmentData downloadWikiAttachment(long wikiId, long attachmentId) {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("wikis/" + wikiId + "/attachments/" + attachmentId));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new AttachmentDataImpl(filename, inputStream);
    }

    @Override
    public Attachment deleteWikiAttachment(long wikiId, long attachmentId) {
        return factory.createAttachment(delete(buildEndpoint("wikis/" + wikiId + "/attachments/" + attachmentId)));
    }

    @Override
    public ResponseList<SharedFile> getWikiSharedFiles(long wikiId) {
        return factory.createSharedFileList(get(buildEndpoint("wikis/" + wikiId + "/sharedFiles")));
    }

    @Override
    public ResponseList<SharedFile> linkWikiSharedFile(long wikiId, List<Long> fileIds) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Long fileId : fileIds) {
            params.add(new NameValuePair("fileId[]", fileId.toString()));
        }
        return factory.createSharedFileList(post(buildEndpoint("wikis/" + wikiId + "/sharedFiles"), params));
    }

    @Override
    public SharedFile unlinkWikiSharedFile(long wikiId, long fileId) {
        return factory.createSharedFile(delete(buildEndpoint("wikis/" + wikiId + "/sharedFiles/" + fileId)));
    }

    @Override
    public ResponseList<WikiHistory> getWikiHistories(long wikiId) {
        return factory.createWikiHistoryList(get(buildEndpoint("wikis/" + wikiId + "/history")));
    }

    @Override
    public ResponseList<WikiHistory> getWikiHistories(long wikiId, QueryParams params) {
        return factory.createWikiHistoryList(get(buildEndpoint("wikis/" + wikiId + "/history"), params));
    }

    @Override
    public ResponseList<Star> getWikiStars(long wikiId) {
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
    public Icon getUserIcon(long userId) {
        BacklogHttpResponse backlogHttpResponse = get(buildEndpoint("users/" + userId + "/icon"));
        String filename = backlogHttpResponse.getFileNameFromContentDisposition();
        InputStream inputStream = backlogHttpResponse.asInputStream();
        return new IconImpl(filename, inputStream);
    }

    @Override
    public ResponseList<Activity> getUserActivities(long userId) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("users/" + userId + "/activities")));
    }

    @Override
    public ResponseList<Activity> getUserActivities(long userId, ActivityQueryParams queryParams) throws BacklogException {
        return factory.createActivityList(get(buildEndpoint("users/" + userId + "/activities"), queryParams));
    }

    @Override
    public ResponseList<Star> getUserStars(long userId) throws BacklogException {
        return factory.createStarList(get(buildEndpoint("users/" + userId + "/stars")));
    }

    @Override
    public ResponseList<Star> getUserStars(long userId, QueryParams queryParams) throws BacklogException {
        return factory.createStarList(get(buildEndpoint("users/" + userId + "/stars"), queryParams));
    }

    @Override
    public int getUserStarCount(long userId, GetStarsParams params) throws BacklogException {
        return factory.createCount(get(buildEndpoint("users/" + userId + "/stars/count"), params))
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
    public User getUser(long userId) throws BacklogException {
        return factory.createUser(get(buildEndpoint("users/" + userId)));
    }

    @Override
    public User createUser(CreateUserParams params) throws BacklogException {
        return factory.createUser(post(buildEndpoint("users"), params));
    }

    @Override
    public User deleteUser(long userId) throws BacklogException {
        return factory.createUser(delete(buildEndpoint("users/" + userId)));
    }

    @Override
    public User getMyself() {
        return factory.createUser(get(buildEndpoint("users/myself")));
    }

    @Override
    public void addStarToIssue(long issueId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("issueId", String.valueOf(issueId)));
        post(buildEndpoint("stars"), params);
    }

    @Override
    public void addStarToComment(long commentId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("commentId", String.valueOf(commentId)));
        post(buildEndpoint("stars"), params);
    }

    @Override
    public void addStarToWiki(long wikiId) throws BacklogException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("wikiId", String.valueOf(wikiId)));
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
        return factory.createCount(get(buildEndpoint("notifications/count")))
                .getCount();
    }

    @Override
    public int resetNotificationCount() throws BacklogException {
        return factory.createCount(post(buildEndpoint("notifications/markAsRead")))
                .getCount();
    }

    @Override
    public void markAsReadNotification(long notificationId) throws BacklogException {
        post(buildEndpoint("notifications/" + notificationId + "/markAsRead"));
    }

    @Override
    public ResponseList<Repository> getGitRepositories(long projectId) throws BacklogException {
        GetParams params = new GetRepositoriesParams(projectId);
        return factory.createRepositoryList(get(buildEndpoint("git/repositories"), params));
    }

    @Override
    public ResponseList<Repository> getGitRepositories(String projectKey) throws BacklogException {
        GetParams params = new GetRepositoriesParams(projectKey);
        return factory.createRepositoryList(get(buildEndpoint("git/repositories"), params));
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
    public Group getGroup(long groupId) throws BacklogException {
        return factory.createGroup(get(buildEndpoint("groups/" + groupId)));
    }

    @Override
    public Group updateGroup(UpdateGroupParams params) throws BacklogException {
        return factory.createGroup(patch(buildEndpoint("groups/" + params.getGroupId()), params));
    }

    @Override
    public Group deleteGroup(long groupId) throws BacklogException {
        return factory.createGroup(delete(buildEndpoint("groups/" + groupId)));
    }
}
