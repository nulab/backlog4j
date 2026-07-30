package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for remove document tags API.
 *
 * @author nulab-inc
 */
public class RemoveDocumentTagsParams extends DeleteParams {

    /**
     * Constructor
     *
     * @param tagNames the tag names to remove from the Document page
     */
    public RemoveDocumentTagsParams(List<String> tagNames) {
        for (String tagName : tagNames) {
            parameters.add(new NameValuePair("tagNames[]", tagName));
        }
    }
}
