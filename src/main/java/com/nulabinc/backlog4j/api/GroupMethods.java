package com.nulabinc.backlog4j.api;

import com.nulabinc.backlog4j.BacklogException;
import com.nulabinc.backlog4j.Group;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.api.option.CreateGroupParams;
import com.nulabinc.backlog4j.api.option.OffsetParams;
import com.nulabinc.backlog4j.api.option.UpdateGroupParams;

/**
 * Executes Backlog Group APIs.
 *
 * @author nulab-inc
 */
public interface GroupMethods {

    /**
     * Returns all the groups.
     *
     * @return the groups in a list.
     * @throws BacklogException
     */
    ResponseList<Group> getGroups() throws BacklogException;

    /**
     * Returns all the groups.
     *
     * @param params the offset parameters
     * @return the groups in a list.
     * @throws BacklogException
     */
    ResponseList<Group> getGroups(OffsetParams params) throws BacklogException;

    /**
     * Creates a group.
     *
     * @param params the group creating parameters
     * @return the created Group
     * @throws BacklogException
     */
    Group createGroup(CreateGroupParams params) throws BacklogException;

    /**
     * Returns the groups identified by the group's id.
     *
     * @param groupId the group identifier
     * @return the Group.
     * @throws BacklogException
     */
    Group getGroup(long groupId) throws BacklogException;

    /**
     * Updates the existing group.
     *
     * @param params the group updating parameters
     * @return the updated Group.
     * @throws BacklogException
     */
    Group updateGroup(UpdateGroupParams params) throws BacklogException;

    /**
     * Deletes the existing groups.
     *
     * @param groupId the group identifier
     * @return the deleted Group.
     * @throws BacklogException
     */
    Group deleteGroup(long groupId) throws BacklogException;
}
