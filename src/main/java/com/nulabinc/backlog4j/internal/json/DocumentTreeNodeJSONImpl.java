package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.DocumentTreeNode;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentTreeNodeJSONImpl implements DocumentTreeNode {

    private String id;
    private String name;
    private String emoji;
    @JsonDeserialize(as = DocumentTreeNodeJSONImpl[].class)
    private DocumentTreeNode[] children;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmoji() {
        return this.emoji;
    }

    @Override
    public List<DocumentTreeNode> getChildren() {
        return this.children == null ? Collections.emptyList() : Arrays.asList(this.children);
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
        DocumentTreeNodeJSONImpl rhs = (DocumentTreeNodeJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .append(this.emoji, rhs.emoji)
                .append(this.children, rhs.children)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(emoji)
                .append(children)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("emoji", emoji)
                .append("children", children)
                .toString();
    }
}
