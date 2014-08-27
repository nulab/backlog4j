package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.Space;

import java.util.Date;

/**
 * @author nulab-inc
 */
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
}
