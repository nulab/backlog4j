package com.nulabinc.backlog4j;

/**
 * The interface for Backlog Document tree data.
 *
 * @author nulab-inc
 */
public interface DocumentTree {

    long getProjectId();

    DocumentTreeNode getActiveTree();

    DocumentTreeNode getTrashTree();
}
