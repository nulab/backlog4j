package com.nulabinc.backlog4j;

import java.util.List;

/**
 * The interface for Backlog Document tree node data.
 *
 * @author nulab-inc
 */
public interface DocumentTreeNode {

    String getId();

    String getName();

    String getEmoji();

    List<DocumentTreeNode> getChildren();
}
