package com.nulabinc.backlog4j;

import java.io.InputStream;

/**
 * The interface for Backlog activity shared file data.
 *
 * @author nulab-inc
 */
public interface SharedFileData {

    String getFilename();

    InputStream getContent();

}
