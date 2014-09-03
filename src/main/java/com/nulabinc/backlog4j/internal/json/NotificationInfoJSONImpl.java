package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.NotificationInfo;

/**
 * @author nulab-inc
 */
public class NotificationInfoJSONImpl implements NotificationInfo {

    private String type;

    @Override
    public String getType() {
        return type;
    }
}
