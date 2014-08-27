package sample;

import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.*;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.conf.BacklogDefaultConfigure;
import com.nulabinc.backlog4j.internal.json.activities.FileAddedContent;
import com.nulabinc.backlog4j.internal.json.activities.IssueCreatedContent;
import com.nulabinc.backlog4j.internal.json.activities.IssueUpdatedContent;
import com.nulabinc.backlog4j.internal.json.customFields.DateCustomFieldSetting;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nulab-inc
 */
public class ApiCallSample {

    public static void main(String[] args) throws MalformedURLException {
        ApiCallSample apiCallSample = new ApiCallSample();
        BacklogClient backlogClient = apiCallSample.getBacklogClient();

        // get Project
        ResponseList<Project> projects = apiCallSample.getProjectsSample(backlogClient);
        for (Project project : projects) {
            System.out.println(project.getId() + ":" + project.getName() + ":" + project.getProjectKey());
        }
    }

    private BacklogClient getBacklogClient() throws MalformedURLException {
        BacklogConfigure configure =
                new BacklogDefaultConfigure("yourSpaceId").apiKey("yourApiKey");

        BacklogClient backlog = new BacklogClientFactory(configure).newClient();
        return backlog;

    }

    private ResponseList<Project> getProjectsSample(BacklogClient backlog) {
        ResponseList<Project> projects = backlog.getProjects();
        for (Project project : projects) {
            System.out.println(project.getId() + ":" + project.getName() + ":" + project.getProjectKey());
        }
        return projects;
    }

    private Project getProjectSample(BacklogClient backlog) {
        Project project = backlog.getProject("PROJECT-KEY");
        System.out.println(project.getId() + ":" + project.getName() + ":" + project.getProjectKey());
        return project;
    }

    private void createProjectSample(BacklogClient backlog) {
        CreateProjectParams params = new CreateProjectParams(
                "Test project", "TEST_PRJ", false, false, Project.TextFormattingRule.Backlog);
        Project project = backlog.createProject(params);
        System.out.println(project.getId() + ":" + project.getName() + ":" + project.getProjectKey());
    }


    private void getProjectActivitiesSample(BacklogClient backlog, String projectKey) {
        ResponseList<Activity> activities = backlog.getProjectActivities(projectKey);
        for (Activity activity : activities) {
            if (activity.getType() == Activity.Type.IssueCreated) {
                IssueCreatedContent content = (IssueCreatedContent) activity.getContent();
                System.out.println(activity.getId() + ":" + activity.getType() + ":" + content.getSummary() + ":" + activity.getCreated());
            }
            if (activity.getType() == Activity.Type.IssueUpdated) {
                IssueUpdatedContent content = (IssueUpdatedContent) activity.getContent();
                System.out.println(activity.getId() + ":" + activity.getType() + ":" + content.getSummary() + ":" + activity.getCreated());
            }
            if (activity.getType() == Activity.Type.FileAdded) {
                FileAddedContent content = (FileAddedContent) activity.getContent();
                System.out.println(activity.getId() + ":" + activity.getType() + ":" + content.getName() + ":" + activity.getCreated());
            }
        }
    }

    private void addProjectUserSample(BacklogClient backlog) {
        User user = backlog.addProjectUser("TEST_PRJ", 123456789);
        System.out.println(user.getId() + ":" + user.getName() + ":" + user.getRoleType());

    }

    private void addCustomFieldSample(BacklogClient backlog) {
        AddDateCustomFieldParams params = new AddDateCustomFieldParams("TST_PRJ", "Date Field");
        params.required(true);
        params.min("2014-06-10").max("2014-07-10")
                .initialValueType(DateCustomFieldSetting.InitialValueType.TodayPlusShiftDays)
                .initialDate("2014-06-12").initialShift(10);
        DateCustomFieldSetting customField = backlog.addDateCustomField(params);
        System.out.println(customField.getId() + ":" + customField.getName() + ":" + customField.getFieldTypeId());


    }

    private void getIssueTypesSample(BacklogClient backlog) {
        ResponseList<IssueType> issueTypes = backlog.getIssueTypes(1073835361);
        for (IssueType issueType : issueTypes) {
            System.out.println(issueType.getId() + ":" + issueType.getName() + ":" + issueType.getColor());
        }
    }


    private void getIssuesSample(BacklogClient backlog, long projectId) {
        GetIssuesParams getIssuesOption = new GetIssuesParams(Arrays.asList(projectId));
        getIssuesOption.keyword("hoge").count(100);
        ResponseList<Issue> issues = backlog.getIssues(getIssuesOption);
        for (Issue issue : issues) {
            System.out.println(issue.getId() + ":" + issue.getIssueKey() + ":" + issue.getSummary() + ":" + issue.getDescription());
        }
    }

    private void addAttachment(BacklogClient backlog) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("/Desktop/cat.jpeg"));
        AttachmentData attachmentData = new AttachmentDataImpl("cat.jpeg", is);
        Attachment attachment = backlog.postAttachment(attachmentData);
        System.out.println(attachment.getId() + ":" + attachment.getName());

    }

    private void createIssueSample1(BacklogClient backlog) {

        CreateIssueParams createIssueParams = new CreateIssueParams(1073835361, "Issue title", 1074172260, Issue.PriorityType.High);

        Issue issue = backlog.createIssue(createIssueParams);
        System.out.println(issue.getId() + ":" + issue.getIssueKey() + ":" + issue.getSummary() + ":" + issue.getDescription());
    }

    private void createIssueSample2(BacklogClient backlog) {

        CreateIssueParams createIssueParams = new CreateIssueParams(1073835361, "Issue title", 1074172260, Issue.PriorityType.Low);

        Map<Long, String> map = new HashMap<Long, String>();
        map.put((long) 1073760842, "1");
        createIssueParams.textCustomFieldMap(map);

        Map<Long, String> omap = new HashMap<Long, String>();
        omap.put((long) 1073760923, "fish");
        omap.put((long) 1073760957, "egg");
        createIssueParams.customFieldOtherValueMap(omap);

        Issue issue = backlog.createIssue(createIssueParams);
        System.out.println(issue.getId() + ":" + issue.getIssueKey() + ":" + issue.getSummary() + ":" + issue.getDescription());
    }

    private void updateIssueSample(BacklogClient backlog) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("/Desktop/cat.jpeg"));
        AttachmentData attachmentData = new AttachmentDataImpl("cat.jpeg", is);
        Attachment attachment = backlog.postAttachment(attachmentData);
        System.out.println(attachment.getId() + ":" + attachment.getName());

        long attachmentId = attachment.getId();

        UpdateIssueParams updateIssueParams = new UpdateIssueParams("TEST_PRJ-1");
        updateIssueParams.summary("Updated issue").description("this is test issue")
                .issueTypeId(1074170482).priority(Issue.PriorityType.High)
                .attachmentIds(Arrays.asList(attachmentId))
                .comment("update with cat").
                status(Issue.StatusType.InProgress);
        Map<Long, String> map = new HashMap<Long, String>();
        map.put(1073760658l, "egg");
        updateIssueParams.textCustomFieldMap(map);

        Issue issue = backlog.updateIssue(updateIssueParams);
        System.out.println(issue.getId() + ":" + issue.getIssueKey() + ":" + issue.getSummary() + ":" + issue.getDescription());
    }

    private void deleteIssueSample(BacklogClient backlog) {
        Issue issue = backlog.deleteIssue("TEST_PRJ-2");
        System.out.println(issue.getId() + ":" + issue.getIssueKey() + ":" + issue.getSummary() + ":" + issue.getDescription());
    }

    private void addIssueCommentSample(BacklogClient backlog) {
        AddIssueCommentParams params = new AddIssueCommentParams("TEST_PRJ-2", "This is comment fuga-fuga.");
        params.notifiedUserIds(Arrays.asList(1073936693l));
        IssueComment issueComment = backlog.addIssueComment(params);
        System.out.println(issueComment.getId() + ":" + issueComment.getCreated());

    }

    private void getProjectUsersSample(BacklogClient backlog) {
        ResponseList<User> users = backlog.getProjectUsers("TST_PRJ6");
        for (User user : users) {
            System.out.println(user.getId() + ":" + user.getName());
        }
    }

    private void getUserIconSample(BacklogClient backlog) throws IOException {

        Icon icon = backlog.getUserIcon(1073936936);
        File file = new File("/Users/yuhkim/Desktop/" + icon.getFilename());
        InputStream is = icon.getContent();
        createFileWithInputStream(is, file);
    }

    private void createFileWithInputStream(InputStream inputStream, File distFile) throws IOException {

        byte[] buffer = new byte[1024];
        int length = 0;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(distFile);

            while ((length = inputStream.read(buffer)) >= 0) {
                fos.write(buffer, 0, length);
            }

            fos.close();
            fos = null;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
