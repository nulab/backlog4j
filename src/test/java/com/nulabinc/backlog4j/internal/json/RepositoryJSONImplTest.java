package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Repository;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.User;
import org.exparity.hamcrest.date.DateMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author nulab-inc
 */
public class RepositoryJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createRepositoryListTest() throws IOException {
        String fileContentStr = getJsonString("json/git_repositories.json");
        ResponseList<Repository> repositories = factory.createRepositoryList(fileContentStr);

        assertEquals(2, repositories.size());

        Repository repository = repositories.get(0);
        assertEquals(868, repository.getId());
        assertEquals(1073760709, repository.getProjectId());
        assertEquals("sample", repository.getName());
        assertEquals("", repository.getDescription());
        assertEquals("", repository.getHookUrl());
        assertEquals("https://nulab.backlog.jp/git/HALLOWEEN/sample.git", repository.getHttpUrl());
        assertEquals("nulab@nulab.git.backlog.jp:/HALLOWEEN/sample.git", repository.getSshUrl());
        assertEquals(2147483646, repository.getDisplayOrder());
        assertNull(repository.getPushedAt());

        User user = repository.getCreatedUser();
        assertEquals(1073751781, user.getId());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.AUGUST, 8, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(repository.getCreated()));

        User updateUser = repository.getUpdatedUser();
        assertEquals(1073751782, updateUser.getId());

        calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.AUGUST, 9, 0, 0, 0);
        assertThat(calendar.getTime(), DateMatchers.sameDay(repository.getUpdated()));

    }
}
