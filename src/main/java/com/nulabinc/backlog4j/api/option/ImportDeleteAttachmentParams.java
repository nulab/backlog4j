package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * @author nulab-inc
 */
public class ImportDeleteAttachmentParams extends DeleteParams {

    /**
     * Constructor
     */
    public ImportDeleteAttachmentParams() {}

    public ImportDeleteAttachmentParams createdUserId(long createdUserId) {
        parameters.add(new NameValuePair("createdUserId", String.valueOf(createdUserId)));
        return this;
    }

    public ImportDeleteAttachmentParams created(String created) {
        parameters.add(new NameValuePair("created", created));
        return this;
    }
}
