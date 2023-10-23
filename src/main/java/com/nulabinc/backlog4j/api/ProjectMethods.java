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
    ProjectWithVCS createProject(CreateProjectParams params) throws BacklogException;

    /**
     * Returns the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the Project
     * @throws BacklogException
     */
    ProjectWithVCS getProject(Object projectIdOrKey) throws BacklogException;

    /**
     * Updates the existing project.
     *
     * @param params the updating project parameters
     * @return the updated Project
     * @throws BacklogException
     */
    ProjectWithVCS updateProject(UpdateProjectParams params) throws BacklogException;

    /**
     * Deletes the existing project.
     *
     * @param projectIdOrKey the project identifier
     * @return the deleted Project
     * @throws BacklogException
     */
    Project deleteProject(Object projectIdOrKey) throws BacklogException;

    /**
     * Returns the project icon.
     *
     * @param projectIdOrKey the project identifier
     * @return the Icon
     * @throws BacklogException
     */
    Icon getProjectIcon(Object projectIdOrKey) throws BacklogException;

    /**
     * Returns the activities on the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the activities in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getProjectActivities(Object projectIdOrKey) throws BacklogException;

    /**
     * Returns the activities on the project.
     *
     * @param projectIdOrKey the project identifier
     * @param query          the query parameters
     * @return the activities in a list
     * @throws BacklogException
     */
    ResponseList<Activity> getProjectActivities(Object projectIdOrKey, ActivityQueryParams query) throws BacklogException;


    /**
     * Adds the user to the project.
     *
     * @param projectIdOrKey the project identifier
     * @param userId         the user identifier
     * @return the added User
     * @throws BacklogException
     */
    User addProjectUser(Object projectIdOrKey, Object userId) throws BacklogException;

    /**
     * Returns the users in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the users in a list.
     * @throws BacklogException
     */
    ResponseList<User> getProjectUsers(Object projectIdOrKey) throws BacklogException;

    /**
     * Removes the user from the project.
     *
     * @param projectIdOrKey the project identifier
     * @param userId         the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User removeProjectUser(Object projectIdOrKey, Object userId) throws BacklogException;

    /**
     * Adds the project administrators.
     *
     * @param projectIdOrKey the project identifier
     * @param userId         the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User addProjectAdministrator(Object projectIdOrKey, Object userId) throws BacklogException;

    /**
     * Returns the project administrators.
     *
     * @param projectIdOrKey the project identifier
     * @return the project administrators
     * @throws BacklogException
     */
    ResponseList<User> getProjectAdministrators(Object projectIdOrKey) throws BacklogException;

    /**
     * Deletes the project administrators.
     *
     * @param projectIdOrKey the project identifier
     * @param userId         the user identifier
     * @return the removed User
     * @throws BacklogException
     */
    User removeProjectAdministrator(Object projectIdOrKey, Object userId) throws BacklogException;

    /**
     * Returns the issue types in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the issue types in a list
     * @throws BacklogException
     */
    ResponseList<IssueType> getIssueTypes(Object projectIdOrKey) throws BacklogException;

    /**
     * Adds an issue type to the project.
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
     * Removes the existing issue type from the project.
     *
     * @param projectIdOrKey        the project identifier
     * @param issueTypeId           the issue type identifier
     * @param substituteIssueTypeId the substitute issue type identifier
     * @return the removed IssueType
     * @throws BacklogException
     */
    IssueType removeIssueType(Object projectIdOrKey, Object issueTypeId, Object substituteIssueTypeId) throws BacklogException;

    /**
     * Returns the issue statuses in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the statuses in a list
     * @throws BacklogException
     */
    ResponseList<Status> getStatuses(Object projectIdOrKey) throws BacklogException;

    /**
     * Returns the categories in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the categories in a list
     * @throws BacklogException
     */
    ResponseList<Category> getCategories(Object projectIdOrKey) throws BacklogException;

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
     * @param projectIdOrKey the project identifier
     * @param categoryId     the category identifier
     * @return the removed category
     * @throws BacklogException
     */
    Category removeCategory(Object projectIdOrKey, Object categoryId) throws BacklogException;

    /**
     * Returns the versions in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the versions in a list
     * @throws BacklogException
     */
    ResponseList<Version> getVersions(Object projectIdOrKey) throws BacklogException;

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
     * @param projectIdOrKey the project identifier
     * @param versionId      the version identifier
     * @return the removed version
     * @throws BacklogException
     */
    Version removeVersion(Object projectIdOrKey, Object versionId) throws BacklogException;

    /**
     * Returns the Milestones in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the Milestones in a list
     * @throws BacklogException
     */
    ResponseList<Milestone> getMilestones(Object projectIdOrKey) throws BacklogException;

    /**
     * Adds a Milestone to the project.
     *
     * @param params the adding Milestone parameters.
     * @return the added Milestone
     * @throws BacklogException
     */
    Milestone addMilestone(AddMilestoneParams params) throws BacklogException;

    /**
     * Updates the existing Milestone in the project.
     *
     * @param params the updating Milestone parameters.
     * @return the updated Milestone
     * @throws BacklogException
     */
    Milestone updateMilestone(UpdateMilestoneParams params) throws BacklogException;

    /**
     * Removes the Milestone from the project.
     *
     * @param projectIdOrKey the project identifier
     * @param MilestoneId    the Milestone identifier
     * @return the removed Milestone
     * @throws BacklogException
     */
    Milestone removeMilestone(Object projectIdOrKey, Object MilestoneId) throws BacklogException;

    /**
     * Returns the custom fields in the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the custom fields in a list
     * @throws BacklogException
     */
    ResponseList<CustomFieldSetting> getCustomFields(Object projectIdOrKey) throws BacklogException;

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
     * @param projectIdOrKey the project identifier
     * @param customFieldId  the custom field identifier
     * @return the removed custom filed
     * @throws BacklogException
     */
    CustomFieldSetting removeCustomField(Object projectIdOrKey, Object customFieldId) throws BacklogException;

    /**
     * Adds an item to the list type custom field.
     *
     * @param projectIdOrKey the project identifier
     * @param customFieldId  the custom field identifier
     * @param name           name of the adding item
     * @return the added custom filed item
     * @throws BacklogException
     */
    CustomFieldSetting addListCustomFieldItem(Object projectIdOrKey, Object customFieldId, String name) throws BacklogException;

    /**
     * Updates the existing item of list type custom field.
     *
     * @param projectIdOrKey the project identifier
     * @param customFieldId  the custom field identifier
     * @param itemId         the item identifier
     * @param name           name of the updating item
     * @return the updated CustomFieldSetting
     * @throws BacklogException
     */
    CustomFieldSetting updateListCustomFieldItem(Object projectIdOrKey, Object customFieldId, Object itemId, String name) throws BacklogException;

    /**
     * Removes the item of list type custom field.
     *
     * @param projectIdOrKey the project identifier
     * @param customFieldId  the custom field identifier
     * @param itemId         the item identifier
     * @return the removed CustomFieldSetting
     * @throws BacklogException
     */
    CustomFieldSetting removeListCustomFieldItem(Object projectIdOrKey, Object customFieldId, Object itemId) throws BacklogException;


    /**
     * Returns the shared files in the project.
     *
     * @param projectIdOrKey the project identifier
     * @param path           path of the shared file directory
     * @return the shared files in a list
     * @throws BacklogException
     */
    ResponseList<SharedFile> getSharedFiles(Object projectIdOrKey, String path) throws BacklogException;

    /**
     * Returns the shared files in the project.
     *
     * @param projectIdOrKey the project identifier
     * @param path           path of the shared file directory
     * @param queryParams    the query parameters
     * @return the shared files in a list
     * @throws BacklogException
     */
    ResponseList<SharedFile> getSharedFiles(Object projectIdOrKey, String path, QueryParams queryParams) throws BacklogException;

    /**
     * Returns the shared file data in the project.
     *
     * @param projectIdOrKey the project identifier
     * @param sharedFileId   the shared file identifier
     * @return the SharedFileData
     * @throws BacklogException
     */
    SharedFileData downloadSharedFile(Object projectIdOrKey, Object sharedFileId) throws BacklogException;

    /**
     * Returns the disk usage of the project.
     *
     * @param projectIdOrKey the project identifier
     * @return the DiskUsageDetail
     * @throws BacklogException
     */
    DiskUsageDetail getProjectDiskUsage(Object projectIdOrKey) throws BacklogException;


}
