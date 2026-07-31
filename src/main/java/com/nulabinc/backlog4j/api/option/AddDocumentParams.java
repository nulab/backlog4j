package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for add document API.
 *
 * @author nulab-inc
 */
public class AddDocumentParams extends PostParams {

    /**
     * Constructor
     *
     * @param projectId the project identifier
     */
    public AddDocumentParams(long projectId) {
        parameters.add(new NameValuePair("projectId", String.valueOf(projectId)));
    }

    /**
     * Sets the title of the Document page.
     *
     * @param title the title of the Document page
     * @return AddDocumentParams instance
     */
    public AddDocumentParams title(String title) {
        parameters.add(new NameValuePair("title", title));
        return this;
    }

    /**
     * Sets the content of the Document page. This is interpreted as markdown syntax.
     *
     * @param content the content of the Document page
     * @return AddDocumentParams instance
     */
    public AddDocumentParams content(String content) {
        parameters.add(new NameValuePair("content", content));
        return this;
    }

    /**
     * Sets the emoji that is added in front of the title.
     *
     * @param emoji the emoji
     * @return AddDocumentParams instance
     */
    public AddDocumentParams emoji(String emoji) {
        parameters.add(new NameValuePair("emoji", emoji));
        return this;
    }

    /**
     * Sets the parent Document page. If this is specified, the Document page will be created as a child of the Document page with this ID.
     *
     * @param parentId the parent Document page identifier
     * @return AddDocumentParams instance
     */
    public AddDocumentParams parentId(String parentId) {
        parameters.add(new NameValuePair("parentId", parentId));
        return this;
    }

    /**
     * Sets whether the Document page is added to the last among sibling Document pages.
     *
     * @param addLast true to add the Document page to the last among sibling Document pages
     * @return AddDocumentParams instance
     */
    public AddDocumentParams addLast(boolean addLast) {
        parameters.add(new NameValuePair("addLast", String.valueOf(addLast)));
        return this;
    }
}
