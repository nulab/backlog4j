package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Issue;
import com.nulabinc.backlog4j.Resolution;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nulab-inc
 */
public class ResolutionJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createResolutionListTest() throws IOException {
        String fileContentStr = getJsonString("json/resolutions.json");
        ResponseList<Resolution> resolutions = factory.createResolutionList(fileContentStr);

        assertEquals(5, resolutions.size());

        Resolution resolution = resolutions.get(0);
        assertEquals(0, resolution.getId());
        assertEquals("対応済み", resolution.getName());
        assertEquals(Issue.ResolutionType.Fixed, resolution.getResolutionType());

        resolution = resolutions.get(1);
        assertEquals(1, resolution.getId());
        assertEquals("対応しない", resolution.getName());
        assertEquals(Issue.ResolutionType.WontFix, resolution.getResolutionType());

        resolution = resolutions.get(2);
        assertEquals(2, resolution.getId());
        assertEquals("無効", resolution.getName());
        assertEquals(Issue.ResolutionType.Invalid, resolution.getResolutionType());

        resolution = resolutions.get(3);
        assertEquals(3, resolution.getId());
        assertEquals("重複", resolution.getName());
        assertEquals(Issue.ResolutionType.Duplication, resolution.getResolutionType());

        resolution = resolutions.get(4);
        assertEquals(4, resolution.getId());
        assertEquals("再現しない", resolution.getName());
        assertEquals(Issue.ResolutionType.CannotReproduce, resolution.getResolutionType());

    }
}
