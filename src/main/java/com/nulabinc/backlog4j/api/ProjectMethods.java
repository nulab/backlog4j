package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.*;
import com.nulabinc.backlog4j.internal.json.customFields.*;

/**
 * Executes Backlog Project APIs.
 *
 * @author nulab-inc
 */
public interface ProjectMethods {

    /**
     * Returns all the projects.
     *
     * @return the projects in a list.
     * @throws BacklogException
     */
    ResponseList<Project> getProjects() throws BacklogException;

    /**
     * Create a project.
     *
     * @param params the creating project parameters.
     * @return the created project
     * @throws BacklogException
     */
    Project createProject(CreateProjectParams params) throws BacklogException;

    /**
     * Returns the project.
     *
     * @param projectId the project identifier
     * @return the Project
     * @throws BacklogException
     */
    Project getProject(long projectId) throws BacklogException;

    /**
     * Returns the project.
     *
     * @param projectKey the project identifier
     * @return the Project
     * @throws BacklogException
     */
    Project getProject(String projectKey) throws BacklogException;

    /**
     * Updates the existing project.
     *
     * @param params the updating project parameters
     * @return the updated Project
     * @throws BacklogException
     */
    Project updateProject(UpdateProjectParams params) throws BacklogException;

    /**
     * Deletes the existing project.
     *
     * @param projectId the project identifier
     * @return the deleted Project
     * @throws BacklogException
     */
    Project deleteProject(long projectId) throws BacklogException;

    /**
     * Deletes the existing project.
     *
     * @param projectKey the project identifier
     * @return the deleted Project
     * @throws BacklogException
     */
    Project deleteProject(String projectKey) throws BacklogException;

    /**
     * Returns the project icon.
     *
     * @param projectId the project identifier
     * @return the Icon
     * @throws BacklogException
     */
    Icon getProjectIcon(long projectId) throws BacklogException;

    /**
     * Returns the project icon.
     *
     * @param projectKey the project identifier
     * @return the Icon
     * @throws BacklogException
     */
    Icon getProjectIcon(String projectKey) throws BacklogException;

    /**
     * Returns the endpoint of project icon.
     *
     * @param projectId the project identifier
     * @return the endpoint
     * @throws BacklogException
     */
    String getProjectIconEndpoint(long projectId) throws BacklogException;

    /**
     * Returns the endpoint of project icon.
     *
     * @param projectKey the project identifier
     * @return the endpoint
     * @throws BacklogException
     */
    String getProjectIconEndpoint(String projectKey) throws BacklogException;

    /**
     * Returns the activities on the project.
     *
     * @param projectId the project identifier
     * @return the activities in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getProjectActivities(long projectId) throws BacklogException;

    /**
     * Returns the activities on the project.
     *
     * @param projectKey the project identifier
     * @return the activities in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getProjectActivities(String projectKey) throws BacklogException;


    ResponseList<Activity> getProjectActivities(long projectId, ActivityQueryParams query) throws BacklogException;
    ResponseList<Activity> getProjectActivities(String projectKey, ActivityQueryParams query) throws BacklogException;

    /**
     * Adds the user to the project.
     *
     * @param projectId the project identifier
     * @param userId    the user identifier
     * @return added User
     * @throws BacklogException
     */
    User addProjectUser(long projectId, long userId) throws BacklogException;

    /**
     * Adds the user to the project.
     *
     * @param projectKey the project identifier
     * @param userId     the user identifier
     * @return the added User
     * @throws BacklogException
     */
    User addProjectUser(String projectKey, long userId) throws BacklogException;

    /**
     * Returns the users in the project.
     *
     * @param projectId the project identifier
     * @return the users in a list.
     * @throws BacklogException
     */
    ResponseList<User> getProjectUsers(long projectId) throws BacklogException;

    /**
     * Returns the users in the project.
     *
     * @param projectKey the project identifier
     * @return the users in a list.
     * @throws BacklogException
     */
    ResponseList<User> getProjectUsers(String projectKey) throws BacklogException;

    /**
     * Removes the user from the project.
     *
     * @param projectId the project identifier
     * @param userId    the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User removeProjectUser(long projectId, long userId) throws BacklogException;

    /**
     * Removes the user from the project.
     *
     * @param projectKey the project identifier
     * @param userId     the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User removeProjectUser(String projectKey, long userId) throws BacklogException;

    /**
     * Adds the project administrators.
     *
     * @param projectId the project identifier
     * @param userId    the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User addProjectAdministrator(long projectId, long userId) throws BacklogException;

    /**
     * Adds the project administrators.
     *
     * @param projectKey the project identifier
     * @param userId    the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User addProjectAdministrator(String projectKey, long userId) throws BacklogException;

    /**
     * Returns the project administrators.
     *
     * @param projectId     the project identifier
     * @return              the project administrators
     * @throws BacklogException
     */
    ResponseList<User> getProjectAdministrators(long projectId) throws BacklogException;

    /**
     * Returns the project administrators.
     *
     * @param projectKey    the project identifier
     * @return              the project administrators
     * @throws BacklogException
     */
    ResponseList<User> getProjectAdministrators(String projectKey) throws BacklogException;

    /**
     * Deletes the project administrators.
     *
     * @param projectId    the project identifier
     * @param userId    the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User removeProjectAdministrator(long projectId, long userId) throws BacklogException;

    /**
     * Deletes the project administrators.
     *
     * @param projectKey    the project identifier
     * @param userId    the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User removeProjectAdministrator(String projectKey, long userId) throws BacklogException;

    /**
     * Returns the issue types in the project.
     *
     * @param projectId the project identifier
     * @return the issue types in a list
     * @throws BacklogException
     */
    ResponseList<IssueType> getIssueTypes(long projectId) throws BacklogException;

    /**
     * Returns the issue types in the project.
     *
     * @param projectKey the project identifier
     * @return the issue types in a list
     * @throws BacklogException
     */
    ResponseList<IssueType> getIssueTypes(String projectKey) throws BacklogException;

    /**
     * Adds a issue type to the project.
     *
     * @param params the creating issue type parameters
     * @return the added IssueType
     * @throws BacklogException
     */
    IssueType addIssueType(AddIssueTypeParams params) throws BacklogException;

    /**
     * Updates the issue type in the project.
     *
     * @param params the updating issue type parameters
     * @return the updated IssueType
     * @throws BacklogException
     */
    IssueType updateIssueType(UpdateIssueTypeParams params) throws BacklogException;

    /**
     * Removes the existing issue type in the project.
     *
     * @param projectId             the project identifier
     * @param issueTypeId           the issue type identifier
     * @param substituteIssueTypeId the substitute issue type identifier
     * @return the removed IssueType
     * @throws BacklogException
     */
    IssueType removeIssueType(long projectId, long issueTypeId, long substituteIssueTypeId) throws BacklogException;

    /**
     * Removes the existing issue type from the project.
     *
     * @param projectKey            the project identifier
     * @param issueTypeId           the issue type identifier
     * @param substituteIssueTypeId the substitute issue type identifier
     * @return the removed IssueType
     * @throws BacklogException
     */
    IssueType removeIssueType(String projectKey, long issueTypeId, long substituteIssueTypeId) throws BacklogException;

    /**
     * Returns the categories in the project.
     *
     * @param projectId the project identifier
     * @return the categories in a list
     * @throws BacklogException
     */
    ResponseList<Category> getCategories(long projectId) throws BacklogException;

    /**
     * Returns the categories in the project.
     *
     * @param projectKey the project identifier
     * @return the categories in a list
     * @throws BacklogException
     */
    ResponseList<Category> getCategories(String projectKey) throws BacklogException;

    // カテゴリーの追加

    /**
     * Adds a category to the project.
     *
     * @param params the adding category parameter
     * @return the added category
     * @throws BacklogException
     */
    Category addCategory(AddCategoryParams params) throws BacklogException;

    /**
     * Updates the existing category in the project.
     *
     * @param params the updating category parameters.
     * @return the updated category
     * @throws BacklogException
     */
    Category updateCategory(UpdateCategoryParams params) throws BacklogException;

    /**
     * Removes the category from the project
     *
     * @param projectId  the project identifier
     * @param categoryId the category identifier
     * @return the removed category
     * @throws BacklogException
     */
    Category removeCategory(long projectId, long categoryId) throws BacklogException;

    /**
     * Removes the category from the project
     *
     * @param projectKey the project identifier
     * @param categoryId the category identifier
     * @return the removed category
     * @throws BacklogException
     */
    Category removeCategory(String projectKey, long categoryId) throws BacklogException;

    /**
     * Returns the versions in the project.
     *
     * @param projectId the project identifier
     * @return the versions in a list
     * @throws BacklogException
     */
    ResponseList<Version> getVersions(long projectId) throws BacklogException;


    /**
     * Returns the versions in the project.
     *
     * @param projectKey the project identifier
     * @return the versions in a list
     * @throws BacklogException
     */
    ResponseList<Version> getVersions(String projectKey) throws BacklogException;

    /**
     * Adds a version to the project.
     *
     * @param params the adding version parameters.
     * @return the added version
     * @throws BacklogException
     */
    Version addVersion(AddVersionParams params) throws BacklogException;

    /**
     * Updates the existing version in the project.
     *
     * @param params the updating version parameters.
     * @return the updated version
     * @throws BacklogException
     */
    Version updateVersion(UpdateVersionParams params) throws BacklogException;

    /**
     * Removes the version from the project.
     *
     * @param projectId the project identifier
     * @param versionId the version identifier
     * @return the removed version
     * @throws BacklogException
     */
    Version removeVersion(long projectId, long versionId) throws BacklogException;

    /**
     * Removes the version from the project.
     *
     * @param projectKey the project identifier
     * @param versionId  the version identifier
     * @return the removed version
     * @throws BacklogException
     */
    Version removeVersion(String projectKey, long versionId) throws BacklogException;

    /**
     * Returns the custom fields in the project.
     *
     * @param projectId the project identifier
     * @return the custom fields in a list
     * @throws BacklogException
     */
    ResponseList<CustomFieldSetting> getCustomFields(long projectId) throws BacklogException;

    /**
     * Returns the custom fields in the project.
     *
     * @param projectKey the project identifier
     * @return the custom fields in a list
     * @throws BacklogException
     */
    ResponseList<CustomFieldSetting> getCustomFields(String projectKey) throws BacklogException;

    /**
     * Adds a text type custom field to the project.
     *
     * @param params the adding text type custom filed parameters.
     * @return the added text type custom field setting.
     * @throws BacklogException
     */
    TextCustomFieldSetting addTextCustomField(AddTextCustomFieldParams params) throws BacklogException;

    /**
     * Adds a text area type custom field to the project.
     *
     * @param params the adding text area type custom filed parameters.
     * @return the added text area type custom field setting.
     * @throws BacklogException
     */
    TextAreaCustomFieldSetting addTextAreaCustomField(AddTextAreaCustomFieldParams params) throws BacklogException;

    /**
     * Adds a numeric type custom field to the project.
     *
     * @param params the adding numeric type custom filed parameters.
     * @return the added numeric type custom field setting.
     * @throws BacklogException
     */
    NumericCustomFieldSetting addNumericCustomField(AddNumericCustomFieldParams params) throws BacklogException;

    /**
     * Adds a date type custom field to the project.
     *
     * @param params the adding date type custom filed parameters.
     * @return the added date type custom field setting.
     * @throws BacklogException
     */
    DateCustomFieldSetting addDateCustomField(AddDateCustomFieldParams params) throws BacklogException;

    /**
     * Adds a single list type custom field to the project.
     *
     * @param params the adding single list type custom filed parameters.
     * @return the added single list type custom field setting.
     * @throws BacklogException
     */
    SingleListCustomFieldSetting addSingleListCustomField(AddSingleListCustomFieldParams params) throws BacklogException;

    /**
     * Adds a multiple list type custom field to the project.
     *
     * @param params the adding multiple list type custom filed parameters.
     * @return the added multiple list type custom field setting.
     * @throws BacklogException
     */
    MultipleListCustomFieldSetting addMultipleListCustomField(AddMultipleListCustomFieldParams params) throws BacklogException;

    /**
     * Adds a radio type custom field to the project.
     *
     * @param params the adding radio type custom filed parameters.
     * @return the added radio type custom field setting.
     * @throws BacklogException
     */
    RadioCustomFieldSetting addRadioCustomField(AddRadioCustomFieldParams params) throws BacklogException;

    /**
     * Adds a checkbox type custom field to the project.
     *
     * @param params the adding checkbox type custom filed parameters.
     * @return the added checkbox type custom field setting.
     * @throws BacklogException
     */
    CheckBoxCustomFieldSetting addCheckBoxCustomField(AddCheckBoxCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing text type custom field in the project.
     *
     * @param params the updating text type custom filed parameters.
     * @return the updated text type custom field setting.
     * @throws BacklogException
     */
    TextCustomFieldSetting updateTextCustomField(UpdateTextCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing text area type custom field in the project.
     *
     * @param params the updating text area type custom filed parameters.
     * @return the updated text area type custom field setting.
     * @throws BacklogException
     */
    TextAreaCustomFieldSetting updateTextAreaCustomField(UpdateTextAreaCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing numeric type custom field in the project.
     *
     * @param params the updating numeric type custom filed parameters.
     * @return the updated numeric type custom field setting.
     * @throws BacklogException
     */
    NumericCustomFieldSetting updateNumericCustomField(UpdateNumericCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing date type custom field in the project.
     *
     * @param params the updating date type custom filed parameters.
     * @return the updated date type custom field setting.
     * @throws BacklogException
     */
    DateCustomFieldSetting updateDateCustomField(UpdateDateCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing single list type custom field in the project.
     *
     * @param params the updating single list type custom filed parameters.
     * @return the updated single list type custom field setting.
     * @throws BacklogException
     */
    SingleListCustomFieldSetting updateSingleListCustomField(UpdateSingleListCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing multiple list type custom field in the project.
     *
     * @param params the multiple list text type custom filed parameters.
     * @return the updated multiple list type custom field setting.
     * @throws BacklogException
     */
    MultipleListCustomFieldSetting updateMultipleListCustomField(UpdateMultipleListCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing radio type custom field in the project.
     *
     * @param params the updating radio type custom filed parameters.
     * @return the updated radio type custom field setting.
     * @throws BacklogException
     */
    RadioCustomFieldSetting updateRadioCustomField(UpdateRadioCustomFieldParams params) throws BacklogException;

    /**
     * Updates the existing checkbox type custom field in the project.
     *
     * @param params the updating checkbox type custom filed parameters.
     * @return the updated checkbox type custom field setting.
     * @throws BacklogException
     */
    CheckBoxCustomFieldSetting updateCheckBoxCustomField(UpdateCheckBoxCustomFieldParams params) throws BacklogException;

    /**
     * Removes the custom filed from the project.
     *
     * @param projectId     the project identifier
     * @param customFieldId the custom field identifier
     * @return the removed custom filed
     * @throws BacklogException
     */
    CustomFieldSetting removeCustomField(long projectId, long customFieldId) throws BacklogException;

    /**
     * Removes the custom filed from the project.
     *
     * @param projectKey    the project identifier
     * @param customFieldId the custom field identifier
     * @return the removed custom filed
     * @throws BacklogException
     */
    CustomFieldSetting removeCustomField(String projectKey, long customFieldId) throws BacklogException;

    /**
     * Adds a item to the list type custom field.
     *
     * @param projectId     the project identifier
     * @param customFieldId the custom field identifier
     * @param name          name of the adding item
     * @return the added custom filed item
     * @throws BacklogException
     */
    CustomFieldSetting addListCustomFieldItem(long projectId, long customFieldId, String name) throws BacklogException;

    /**
     * Adds a item to the list type custom field.
     *
     * @param projectKey    the project identifier
     * @param customFieldId the custom field identifier
     * @param name          name of the adding item
     * @return the added custom filed item
     * @throws BacklogException
     */
    CustomFieldSetting addListCustomFieldItem(String projectKey, long customFieldId, String name) throws BacklogException;

    /**
     * Updates the existing item of list type custom field.
     *
     * @param projectId     the project identifier
     * @param customFieldId the custom field identifier
     * @param itemId        the item identifier
     * @param name          name of the updating item
     * @return the updated CustomFieldSetting
     * @throws BacklogException
     */
    CustomFieldSetting updateListCustomFieldItem(long projectId, long customFieldId, long itemId, String name) throws BacklogException;

    /**
     * Updates the existing item of list type custom field.
     *
     * @param projectKey    the project identifier
     * @param customFieldId the custom field identifier
     * @param itemId        the item identifier
     * @param name          name of the updating item
     * @return the updated CustomFieldSetting
     * @throws BacklogException
     */
    CustomFieldSetting updateListCustomFieldItem(String projectKey, long customFieldId, long itemId, String name) throws BacklogException;

    /**
     * Removes the item of list type custom field.
     *
     * @param projectId     the project identifier
     * @param customFieldId the custom field identifier
     * @param itemId        the item identifier
     * @return the removed CustomFieldSetting
     * @throws BacklogException
     */
    CustomFieldSetting removeListCustomFieldItem(long projectId, long customFieldId, long itemId) throws BacklogException;

    /**
     * Removes the item of list type custom field.
     *
     * @param projectKey    the project identifier
     * @param customFieldId the custom field identifier
     * @param itemId        the item identifier
     * @return the removed CustomFieldSetting
     * @throws BacklogException
     */
    CustomFieldSetting removeListCustomFieldItem(String projectKey, long customFieldId, long itemId) throws BacklogException;

    /**
     * Returns the shared files in the project.
     *
     * @param projectId the project identifier
     * @param path      path of the shared file directory
     * @return the shared files in a list
     * @throws BacklogException
     */
    ResponseList<SharedFile> getSharedFiles(long projectId, String path) throws BacklogException;

    /**
     * Returns the shared files in the project.
     *
     * @param projectKey the project identifier
     * @param path       path of the shared file directory
     * @return the shared files in a list
     * @throws BacklogException
     */
    ResponseList<SharedFile> getSharedFiles(String projectKey, String path) throws BacklogException;

    /**
     * Returns the shared file data in the project.
     *
     * @param projectId    the project identifier
     * @param sharedFileId the shared file identifier
     * @return the SharedFileData
     * @throws BacklogException
     */
    SharedFileData downloadSharedFile(long projectId, long sharedFileId) throws BacklogException;

    /**
     * Returns the shared file data in the project.
     *
     * @param projectKey   the project identifier
     * @param sharedFileId the shared file identifier
     * @return the SharedFileData
     * @throws BacklogException
     */
    SharedFileData downloadSharedFile(String projectKey, long sharedFileId) throws BacklogException;

    /**
     * Returns the endpoint of shared file.
     *
     * @param projectId    the project identifier
     * @param sharedFileId the shared file identifier
     * @return the endpoint
     * @throws BacklogException
     */
    String getSharedFileEndpoint(long projectId, long sharedFileId) throws BacklogException;

    /**
     * Returns the endpoint of shared file.
     *
     * @param projectKey   the project identifier
     * @param sharedFileId the shared file identifier
     * @return the endpoint
     * @throws BacklogException
     */
    String getSharedFileEndpoint(String projectKey, long sharedFileId) throws BacklogException;

    /**
     * Returns the disk usage of the project.
     *
     * @param projectId the project identifier
     * @return the DiskUsageDetail
     * @throws BacklogException
     */
    DiskUsageDetail getProjectDiskUsage(long projectId) throws BacklogException;

    /**
     * Returns the disk usage of the project.
     *
     * @param projectKey the project identifier
     * @return the DiskUsageDetail
     * @throws BacklogException
     */
    DiskUsageDetail getProjectDiskUsage(String projectKey) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(long projectId, long repoId) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(String projectKey, String repoName) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param params the finding pull request parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(long projectId, long repoId, PullRequestQueryParams params) throws BacklogException;

    /**
     * Returns the pull requests of the repository.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param params the finding pull request parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequest> getPullRequests(String projectKey, String repoName, PullRequestQueryParams params) throws BacklogException;

    /**
     * Returns the pull request.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    PullRequest getPullRequest(long projectId, long repoId, long number) throws BacklogException;

    /**
     * Returns the pull request.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    PullRequest getPullRequest(String projectKey, String repoName, long number) throws BacklogException;

    /**
     * Returns the comments of pull requests.
     *
     * @param projectId the project identifier
     * @param repoId the repository identifier
     * @param number the pull request identifier
     * @param params the finding pull request comments parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequestComment> getPullRequestComments(long projectId, long repoId, long number, QueryParams params) throws BacklogException;

    /**
     * Returns the comments of pull requests.
     *
     * @param projectKey the project identifier
     * @param repoName the repository name
     * @param number the pull request identifier
     * @param params the finding pull request comments parameters.
     * @return the git pull requests in a list.
     * @throws BacklogException
     */
    ResponseList<PullRequestComment> getPullRequestComments(String projectKey, String repoName, long number, QueryParams params) throws BacklogException;


    /**
     * Add a comment on the pull request.
     *
     * @param params the adding pull request comment parameters.
     * @return the added pull request comment.
     * @throws BacklogException
     */
    PullRequestComment addPullRequestComment(AddPullRequestCommentParams params) throws BacklogException;

}
