package com.nulabinc.backlog4j;

import java.io.InputStream;

/**
 * The interface for Backlog icon file data.
 *
 * @author nulab-inc
 */
public interface Icon {
    String getFilename();

    InputStream getContent();
}
