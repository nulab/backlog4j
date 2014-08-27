package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.*;

/**
 * @author nulab-inc
 */
public class GroupProjectActivityJSONImpl implements GroupProjectActivity {

    private long id;
    private int type;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Activity.Type getType() {
        return Activity.Type.valueOf(this.type);
    }



}
