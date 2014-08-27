package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Star;
import com.nulabinc.backlog4j.User;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.DateMatchers;

import java.io.IOException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author nulab-inc
 */
public class StarJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createSpaceTest() throws IOException {
        String fileContentStr = getJsonString("json/star.json");
        Star star = factory.createStar(fileContentStr);

        assertEquals(1074694702, star.getId());
        assertEquals("[TST_PRJ5-2] star-test | 課題の表示 - Backlog", star.getTitle());
        assertEquals("https://xxxxxxxx.xx/view/TST_PRJ5-2", star.getUrl());
        assertEquals("コメント", star.getComment());

        User user = star.getPresenter();
        assertEquals(1073936936, user.getId());
        assertEquals("test", user.getName());
        assertEquals(User.RoleType.Admin, user.getRoleType());
        assertEquals("ja", user.getLang());
        assertEquals("test@xxxxxxxx.xx", user.getMailAddress());

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 6, 17, 0, 54, 2);
        assertThat(calendar.getTime(), DateMatchers.sameDay(star.getCreated()));

    }
}
