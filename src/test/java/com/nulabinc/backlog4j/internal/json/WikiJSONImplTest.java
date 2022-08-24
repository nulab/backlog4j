package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Attachment;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.Wiki;
import com.nulabinc.backlog4j.WikiTag;
import org.exparity.hamcrest.date.DateMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author nulab-inc
 */
public class WikiJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createWikiListTest() throws IOException {
        String fileContentStr = getJsonString("json/wikis.json");
        ResponseList<Wiki> wikis = factory.createWikiList(fileContentStr);

        assertEquals(2, wikis.size());
    }

    @Test
    public void createWikiTest() throws IOException {
        String fileContentStr = getJsonString("json/wiki.json");
        Wiki wiki = factory.createWiki(fileContentStr);


        assertEquals(1073768473, wiki.getId());
        assertEquals(1073760709, wiki.getProjectId());
        assertEquals("テストwiki", wiki.getName());
        assertEquals("テスト用wikiです", wiki.getContent());

        List<WikiTag> tags = wiki.getTags();
        assertEquals(2, tags.size());
        assertEquals(4677, tags.get(0).getId());
        assertEquals("tag1", tags.get(0).getName());

        List<Attachment> attachments = wiki.getAttachments();
        assertEquals(1, attachments.size());

        List<SharedFile> sharedFiles = wiki.getSharedFiles();
        assertEquals(1, sharedFiles.size());

        List<Star> stars = wiki.getStars();
        assertEquals(2, stars.size());

        User user = wiki.getCreatedUser();
        assertEquals(1073751781, user.getId());
        assertEquals("test_admin", user.getUserId());
        assertEquals("あどみにさん", user.getName());
        assertEquals(User.RoleType.Admin, user.getRoleType());
        assertNull(user.getLang());
        assertEquals("test@test.test", user.getMailAddress());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.AUGUST, 5, 0, 59, 45);
        assertThat(calendar.getTime(), DateMatchers.sameDay(wiki.getCreated()));

        User updateUser = wiki.getUpdatedUser();
        assertEquals(1073751782, updateUser.getId());
        assertEquals("test_admin2", updateUser.getUserId());
        assertEquals("あどみにさん2", updateUser.getName());
        assertEquals(User.RoleType.Admin, updateUser.getRoleType());
        assertNull(updateUser.getLang());
        assertEquals("test@test.test", updateUser.getMailAddress());

        calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.AUGUST, 5, 1, 0, 11);
        assertThat(calendar.getTime(), DateMatchers.sameDay(wiki.getUpdated()));

    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/wiki.json");
        Wiki wiki1 = factory.createWiki(fileContentStr);
        Wiki wiki2 = factory.createWiki(fileContentStr);
        assertEquals(wiki1, wiki2);

    }

    @Test
    public void hashCodeTest() throws IOException {
        String fileContentStr = getJsonString("json/wiki.json");
        Wiki wiki1 = factory.createWiki(fileContentStr);
        Wiki wiki2 = factory.createWiki(fileContentStr);
        assertEquals(wiki1.hashCode(), wiki2.hashCode());

    }
}
