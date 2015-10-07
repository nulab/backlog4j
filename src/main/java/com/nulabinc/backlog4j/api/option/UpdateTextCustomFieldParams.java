package com.nulabinc.backlog4j.api.option;

/**
 * Parameters for update text type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateTextCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateTextCustomFieldParams(Object projectIdOrKey, long customFiledId) {
        super(projectIdOrKey, customFiledId);
    }
}
