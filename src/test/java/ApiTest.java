import com.nulabinc.backlog4j.BacklogClient;
import com.nulabinc.backlog4j.BacklogClientFactory;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.conf.BacklogJpConfigure;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by yuhkim on 2014/10/30.
 */
public class ApiTest {
    @Test
    public void fileGetTest() throws IOException {
        BacklogConfigure backlogConfigure =
                new BacklogJpConfigure("test002.dev").apiKey("SyJc63HunVv1MGea9z2n5WIAZiL9IFx0ExT0b9XeMriavfJ1BA4l1UrCAwhkeKAI");
        BacklogClient backlog = new BacklogClientFactory(backlogConfigure).newClient();
        ResponseList<SharedFile> allSharedFiles = backlog.getSharedFiles("SHARED_FILE_TEST", "testフォルダ/img");
        SharedFile sharedFile = allSharedFiles.get(0);





    }
}
