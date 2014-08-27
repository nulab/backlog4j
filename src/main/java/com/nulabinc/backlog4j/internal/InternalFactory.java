/*
 * Copyright 2012 Ryuji Yamashita
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nulabinc.backlog4j.internal;


import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.internal.http.InternalHttpResponse;

/**
 * @author nulab-inc
 */
public interface InternalFactory {

    Space createSpace(InternalHttpResponse res) throws BacklogException;

    SpaceNotification createSpaceNotification(InternalHttpResponse res) throws BacklogException;

    DiskUsage createDiskUsage(InternalHttpResponse res) throws BacklogException;

    DiskUsageDetail createDiskUsageDetail(InternalHttpResponse res) throws BacklogException;

    ResponseList<Project> createProjectList(InternalHttpResponse res) throws BacklogException;

    Project createProject(InternalHttpResponse res) throws BacklogException;

    ResponseList<Activity> createActivityList(InternalHttpResponse res) throws BacklogException;

    Activity createActivity(InternalHttpResponse res) throws BacklogException;

    ResponseList<Issue> createIssueList(InternalHttpResponse res) throws BacklogException;

    Issue createIssue(InternalHttpResponse res) throws BacklogException;

    ResponseList<IssueComment> createIssueCommentList(InternalHttpResponse res) throws BacklogException;

    IssueComment createIssueComment(InternalHttpResponse res) throws BacklogException;

    ResponseList<User> createUserList(InternalHttpResponse res) throws BacklogException;

    User createUser(InternalHttpResponse res) throws BacklogException;

    ResponseList<IssueType> createIssueTypeList(InternalHttpResponse res) throws BacklogException;

    IssueType createIssueType(InternalHttpResponse res) throws BacklogException;

    ResponseList<Category> createCategoryList(InternalHttpResponse res) throws BacklogException;

    Category createCategory(InternalHttpResponse res) throws BacklogException;

    ResponseList<CustomFieldSetting> createCustomFieldList(InternalHttpResponse res) throws BacklogException;

    CustomFieldSetting createCustomField(InternalHttpResponse res) throws BacklogException;

    ResponseList<Priority> createPriorityList(InternalHttpResponse res) throws BacklogException;

    ResponseList<Resolution> createResolutionList(InternalHttpResponse res) throws BacklogException;

    ResponseList<Status> createStatusList(InternalHttpResponse res) throws BacklogException;

    ResponseList<Star> createStarList(InternalHttpResponse res) throws BacklogException;

    Star createStar(InternalHttpResponse res) throws BacklogException;

    Count createCount(InternalHttpResponse res) throws BacklogException;

    ResponseList<Version> createVersionList(InternalHttpResponse res) throws BacklogException;

    Version createVersion(InternalHttpResponse res) throws BacklogException;

    Wiki createWiki(InternalHttpResponse res) throws BacklogException;

    ResponseList<Wiki> createWikiList(InternalHttpResponse res) throws BacklogException;

    ResponseList<WikiTag> createWikiTagList(InternalHttpResponse res) throws BacklogException;

    WikiHistory createWikiHistory(InternalHttpResponse res) throws BacklogException;

    WikiTag createWikiTag(InternalHttpResponse res) throws BacklogException;

    ResponseList<WikiHistory> createWikiHistoryList(InternalHttpResponse res) throws BacklogException;

    ResponseList<Notification> createNotificationList(InternalHttpResponse res) throws BacklogException;

    ResponseList<Repository> createRepositoryList(InternalHttpResponse res) throws BacklogException;

    ResponseList<ViewedIssue> createViewedIssueList(InternalHttpResponse res) throws BacklogException;

    ResponseList<ViewedProject> createViewedProjectList(InternalHttpResponse res) throws BacklogException;

    ResponseList<ViewedWiki> createViewedWikiList(InternalHttpResponse res) throws BacklogException;

    ResponseList<SharedFile> createSharedFileList(InternalHttpResponse res) throws BacklogException;

    SharedFile createSharedFile(InternalHttpResponse res) throws BacklogException;

    ResponseList<Attachment> createAttachmentList(InternalHttpResponse res) throws BacklogException;

    Attachment createAttachment(InternalHttpResponse res) throws BacklogException;

    Group createGroup(InternalHttpResponse res) throws BacklogException;

    ResponseList<Group> createGroupList(InternalHttpResponse res) throws BacklogException;

}
