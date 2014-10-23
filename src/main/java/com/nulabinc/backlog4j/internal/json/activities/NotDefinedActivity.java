package com.nulabinc.backlog4j.internal.json.activities;

import com.nulabinc.backlog4j.Content;

/**
 * Created by yuhkim on 2014/10/23.
 */
public class NotDefinedActivity extends ActivityJSONImpl{

    private Object content;

    @Override
    public Type getType() {
        return Type.NotDefined;
    }

    @Override
    public Content getContent() {
        return null;
    }
}
