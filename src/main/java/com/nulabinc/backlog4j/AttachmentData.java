package com.nulabinc.backlog4j;

import java.io.InputStream;

/**
 * The interface for Backlog attachment file data.
 *
 * @author nulab-inc
 */
public interface AttachmentData {

    String getFilename();

    InputStream getContent();

}
