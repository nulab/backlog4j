package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.SharedFile;
import com.nulabinc.backlog4j.Space;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author nulab-inc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpaceJSONImpl implements Space {

    private String spaceKey;
    private String name;
    private long ownerId;
    private String lang;
    private String timezone;
    private String reportSendTime;
    private String textFormattingRule;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date created;

    @Override
    public String getSpaceKey() {
        return spaceKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getOwnerId() {
        return ownerId;
    }

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public String getTimezone() {
        return timezone;
    }

    @Override
    public String getReportSendTime() {
        return reportSendTime;
    }

    @Override
    public String getTextFormattingRule() {
        return textFormattingRule;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public Date getCreated() {
        return created;
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
        SpaceJSONImpl rhs = (SpaceJSONImpl) obj;
        return new EqualsBuilder()
                .append(this.spaceKey, rhs.spaceKey)
                .append(this.name, rhs.name)
                .append(this.ownerId, rhs.ownerId)
                .append(this.lang, rhs.lang)
                .append(this.timezone, rhs.timezone)
                .append(this.reportSendTime, rhs.reportSendTime)
                .append(this.textFormattingRule, rhs.textFormattingRule)
                .append(this.updated, rhs.updated)
                .append(this.created, rhs.created)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(spaceKey)
                .append(name)
                .append(ownerId)
                .append(lang)
                .append(timezone)
                .append(reportSendTime)
                .append(textFormattingRule)
                .append(updated)
                .append(created)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("spaceKey", spaceKey)
                .append("name", name)
                .append("ownerId", ownerId)
                .append("lang", lang)
                .append("timezone", timezone)
                .append("reportSendTime", reportSendTime)
                .append("textFormattingRule", textFormattingRule)
                .append("updated", updated)
                .append("created", created)
                .toString();
    }
}
