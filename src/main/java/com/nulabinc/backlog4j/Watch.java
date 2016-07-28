package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * Created by hayashi on 2016/07/26.
 */
public interface Watch {

    long getId();

    String getIdAsString();
    
    boolean getAlreadyRead();
    
    String getAlreadyReadAsString();
    
    String getNote();

    String getType();

    Issue getIssue();

    Date getCreated();

    Date getUpdated();

}
