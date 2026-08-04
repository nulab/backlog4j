package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DocumentTree;
import com.nulabinc.backlog4j.DocumentTreeNode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentTreeJSONImpl implements DocumentTree {

    private long projectId;
    @JsonDeserialize(as = DocumentTreeNodeJSONImpl.class)
    private DocumentTreeNode activeTree;
    @JsonDeserialize(as = DocumentTreeNodeJSONImpl.class)
    private DocumentTreeNode trashTree;

    @Override
    public long getProjectId() {
        return this.projectId;
    }

    @Override
    public DocumentTreeNode getActiveTree() {
        return this.activeTree;
    }

    @Override
    public DocumentTreeNode getTrashTree() {
        return this.trashTree;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        DocumentTreeJSONImpl rhs = (DocumentTreeJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.projectId, rhs.projectId)
                .append(this.activeTree, rhs.activeTree)
                .append(this.trashTree, rhs.trashTree)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(projectId)
                .append(activeTree)
                .append(trashTree)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("projectId", projectId)
                .append("activeTree", activeTree)
                .append("trashTree", trashTree)
                .toString();
    }
}
