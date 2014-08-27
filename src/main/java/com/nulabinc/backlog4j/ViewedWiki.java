package com.nulabinc.backlog4j;

import java.util.Date;

/**
 * The interface for Backlog viewed wiki data.
 *
 * @author nulab-inc
 */
public interface ViewedWiki {
    Wiki getPage();

    Date getUpdated();
}
