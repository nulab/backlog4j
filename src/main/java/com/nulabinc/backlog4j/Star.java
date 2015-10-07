package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog star data.
 *
 * @author nulab-inc
 */
public interface Star {
    long getId();

    String getIdAsString();

    String getComment();

    String getUrl();

    String getTitle();

    User getPresenter();

    Date getCreated();

}
