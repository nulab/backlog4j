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
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueJSONImpl implements Issue {

    private int id;
    private String issueKey;
    private int keyId;
    private int projectId;
    @JsonDeserialize(as = IssueTypeJSONImpl.class)
    private IssueType issueType;
    private String summary;
    private String description;
    @JsonDeserialize(as = ResolutionJSONImpl.class)
    private Resolution resolution;
    @JsonDeserialize(as = PriorityJSONImpl.class)
    private Priority priority;
    @JsonDeserialize(as = StatusJSONImpl.class)
    private Status status;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User assignee;
    @JsonDeserialize(as = CategoryJSONImpl[].class)
    private Category[] category;
    @JsonDeserialize(as = VersionJSONImpl[].class)
    private Version[] versions;
    @JsonDeserialize(as = MilestoneJSONImpl[].class)
    private Milestone[] milestone;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date startDate;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date dueDate;
    @JsonDeserialize(using = JacksonCustomBigdecimalDeserializer.class)
    private BigDecimal estimatedHours;
    @JsonDeserialize(using = JacksonCustomBigdecimalDeserializer.class)
    private BigDecimal actualHours;
    private long parentIssueId;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User createdUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;
    @JsonDeserialize(as = UserJSONImpl.class)
    private User updatedUser;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;
    @JsonDeserialize(as = CustomFieldJSONImpl[].class)
    private CustomField[] customFields;
    @JsonDeserialize(as = AttachmentJSONImpl[].class)
    private Attachment[] attachments;
    @JsonDeserialize(as = SharedFileJSONImpl[].class)
    private SharedFile[] sharedFiles;
    @JsonDeserialize(as = StarJSONImpl[].class)
    private Star[] stars;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getIssueKey() {
        return this.issueKey;
    }

    @Override
    public long getKeyId() {
        return this.keyId;
    }

    @Override
    public long getProjectId() {
        return this.projectId;
    }

    @Override
    public IssueType getIssueType() {
        return this.issueType;
    }

    @Override
    public String getSummary() {
        return this.summary;
    }

    @Override
    public String getDescription() {
        return this.description;
    }


    @Override
    public Resolution getResolution() {
        return resolution;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public User getAssignee() {
        return assignee;
    }

    @Override
    public List<Category> getCategory() {
        return Arrays.asList(category);
    }

    @Override
    public List<Version> getVersions() {
        return Arrays.asList(versions);
    }

    @Override
    public List<Milestone> getMilestone() {
        return Arrays.asList(milestone);
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public BigDecimal getEstimatedHours() {
        return estimatedHours;
    }

    @Override
    public BigDecimal getActualHours() {
        return actualHours;
    }

    @Override
    public long getParentIssueId() {
        return parentIssueId;
    }

    @Override
    public User getCreatedUser() {
        return createdUser;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public User getUpdatedUser() {
        return updatedUser;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public List<CustomField> getCustomFields() {
        return Arrays.asList(customFields);
    }

    @Override
    public List<Attachment> getAttachments() {
        return Arrays.asList(attachments);
    }

    @Override
    public List<SharedFile> getSharedFiles() {
        return Arrays.asList(sharedFiles);
    }

    @Override
    public List<Star> getStars() {
        return Arrays.asList(stars);
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
        IssueJSONImpl rhs = (IssueJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.issueKey, rhs.issueKey)
                .append(this.keyId, rhs.keyId)
                .append(this.projectId, rhs.projectId)
                .append(this.issueType, rhs.issueType)
                .append(this.summary, rhs.summary)
                .append(this.description, rhs.description)
                .append(this.resolution, rhs.resolution)
                .append(this.priority, rhs.priority)
                .append(this.status, rhs.status)
                .append(this.assignee, rhs.assignee)
                .append(this.category, rhs.category)
                .append(this.versions, rhs.versions)
                .append(this.milestone, rhs.milestone)
                .append(this.startDate, rhs.startDate)
                .append(this.dueDate, rhs.dueDate)
                .append(this.estimatedHours, rhs.estimatedHours)
                .append(this.actualHours, rhs.actualHours)
                .append(this.parentIssueId, rhs.parentIssueId)
                .append(this.createdUser, rhs.createdUser)
                .append(this.created, rhs.created)
                .append(this.updatedUser, rhs.updatedUser)
                .append(this.updated, rhs.updated)
                .append(this.customFields, rhs.customFields)
                .append(this.attachments, rhs.attachments)
                .append(this.sharedFiles, rhs.sharedFiles)
                .append(this.stars, rhs.stars)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(issueKey)
                .append(keyId)
                .append(projectId)
                .append(issueType)
                .append(summary)
                .append(description)
                .append(resolution)
                .append(priority)
                .append(status)
                .append(assignee)
                .append(category)
                .append(versions)
                .append(milestone)
                .append(startDate)
                .append(dueDate)
                .append(estimatedHours)
                .append(actualHours)
                .append(parentIssueId)
                .append(createdUser)
                .append(created)
                .append(updatedUser)
                .append(updated)
                .append(customFields)
                .append(attachments)
                .append(sharedFiles)
                .append(stars)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("issueKey", issueKey)
                .append("keyId", keyId)
                .append("projectId", projectId)
                .append("issueType", issueType)
                .append("summary", summary)
                .append("description", description)
                .append("resolution", resolution)
                .append("priority", priority)
                .append("status", status)
                .append("assignee", assignee)
                .append("category", category)
                .append("versions", versions)
                .append("milestone", milestone)
                .append("startDate", startDate)
                .append("dueDate", dueDate)
                .append("estimatedHours", estimatedHours)
                .append("actualHours", actualHours)
                .append("parentIssueId", parentIssueId)
                .append("createdUser", createdUser)
                .append("created", created)
                .append("updatedUser", updatedUser)
                .append("updated", updated)
                .append("customFields", customFields)
                .append("attachments", attachments)
                .append("sharedFiles", sharedFiles)
                .append("stars", stars)
                .toString();
    }
}