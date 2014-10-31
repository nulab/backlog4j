import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.api.option.GetIssuesParams;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.conf.BacklogJpConfigure;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yuhkim on 2014/10/30.
 */
public class ApiTest {
    @Test
    public void fileGetTest() throws IOException {
        BacklogConfigure backlogConfigure =
                new BacklogJpConfigure("nulab.dev").apiKey("ke5rrrkUcEnWwdPSy1uEfisNeMjIerFIeT6S8iniNAxihr9yhVBPDOxa6KhPuz6v");
        BacklogClient backlog = new BacklogClientFactory(backlogConfigure).newClient();


//        ResponseList<SharedFile> allSharedFiles = backlog.getSharedFiles("SHARED_FILE_TEST", "testフォルダ/img");
//        SharedFile sharedFile = allSharedFiles.get(0);
        GetIssuesParams params = new GetIssuesParams(Arrays.asList(backlog.getProjects().get(0).getId()));
        params.createdSince("2014-07-01");
        Count count = backlog.getIssuesCount(params);


        assertEquals(0, count.getCount());



    }
}
