package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

import java.util.List;

/**
 * Parameters for add document tags API.
 *
 * @author nulab-inc
 */
public class AddDocumentTagsParams extends PostParams {

    /**
     * Constructor
     *
     * @param tagNames the tag names to add to the Document page
     */
    public AddDocumentTagsParams(List<String> tagNames) {
        for (String tagName : tagNames) {
            parameters.add(new NameValuePair("tagNames[]", tagName));
        }
    }
}
