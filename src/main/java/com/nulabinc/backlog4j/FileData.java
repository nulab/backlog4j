package com.nulabinc.backlog4j;

import java.io.InputStream;

/**
 * The interface for Backlog file data.
 *
 * @author nulab-inc
 */
public interface FileData {
    String getFilename();
    InputStream getContent();
}
