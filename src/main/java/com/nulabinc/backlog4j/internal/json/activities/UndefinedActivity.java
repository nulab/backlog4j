package com.nulabinc.backlog4j.internal.json.activities;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.Content;

/**
 * Created by yuhkim on 2015/05/18.
 */
public class UndefinedActivity extends ActivityJSONImpl{
    @Override
    public Activity.Type getType() {
        return Activity.Type.Undefined;
    }

    @Override
    public Content getContent() {
        return null;
    }
}
