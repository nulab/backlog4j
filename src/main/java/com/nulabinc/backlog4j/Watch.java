package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog Watch data.
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
