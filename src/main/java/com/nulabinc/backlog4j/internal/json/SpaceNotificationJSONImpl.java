package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nulabinc.backlog4j.SpaceNotification;

import java.util.Date;

/**
 * @author nulab-inc
 */
public class SpaceNotificationJSONImpl implements SpaceNotification {

    private String content;
    @JsonDeserialize(using = JacksonCustomDateDeserializer.class)
    private Date updated;


    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }
}
