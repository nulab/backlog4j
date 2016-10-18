package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.*;
import com.nulabinc.backlog4j.internal.json.customFields.CustomFieldJSONImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatchJSONImpl implements Watch {

    private int id;
    private boolean alreadyRead;
    private String note;
    private String type;
    @JsonDeserialize(as = IssueJSONImpl.class)
    private Issue issue;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(this.id);
    }

    @Override
    public boolean getAlreadyRead() {
        return this.alreadyRead;
    }

    @Override
    public String getAlreadyReadAsString() {
        return String.valueOf(this.alreadyRead);
    }

    @Override
    public String getNote() {
        return this.note;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Issue getIssue() {
        return this.issue;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public Date getUpdated() {
        return updated;
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
        WatchJSONImpl rhs = (WatchJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.alreadyRead, rhs.alreadyRead)
                .append(this.note, rhs.note)
                .append(this.type, rhs.type)
                .append(this.issue, rhs.issue)
                .append(this.created, rhs.created)
                .append(this.updated, rhs.updated)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(alreadyRead)
                .append(type)
                .append(note)
                .append(issue)
                .append(created)
                .append(updated)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("alreadyRead", alreadyRead)
                .append("note", note)
                .append("type", type)
                .append("issue", issue)
                .append("created", created)
                .append("updated", updated)
                .toString();
    }

}