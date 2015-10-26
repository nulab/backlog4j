package com.nulabinc.backlog4j;

/**
 * Supports to get url for web link.
 *
 * @author nulab-inc
 */
interface BacklogUrlSupport {

    // https://spacexxx.backlog.jp/git/TEST_PROJECT/app_repository/pullRequests/123
    String getPullRequestUrl (Project project,  Repository repository,
                                     PullRequest pullRequest);

    // https://spacexxx.backlog.jp/git/TEST_PROJECT/app_repository/pullRequests/123#comment-1074239043
    String getPullRequestUrl (Project project,  Repository repository,
                                     PullRequest pullRequest, PullRequestComment pullRequestComment);

    // https://spacexxx.backlog.jp/view/TEST_PROJECT-123
    String getIssueUrl (Issue issue);

    // https://spacexxx.backlog.jp/view/TEST_PROJECT-123#comment-1212
    String getIssueUrl (Issue issue, IssueComment issueComment);

    // https://spacexxx.backlog.jp/wiki/TEST_PROJECT/Home
    String getWikiUrl (Project project, Wiki wiki);
}
