package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for update watch API.
 *
 * @author nulab-inc
 */
public class UpdateWatchParams extends PatchParams {

    private Object watchingId;

    public UpdateWatchParams(Object watchingId) {
        this.watchingId = watchingId;
    }

    public String getWatchingIdString() {
        return watchingId.toString();
    }

    public UpdateWatchParams note(String note) {
        parameters.add(new NameValuePair("note", String.valueOf(note)));
        return this;
    }

}
