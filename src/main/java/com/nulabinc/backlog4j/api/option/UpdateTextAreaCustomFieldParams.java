package com.nulabinc.backlog4j.api.option;

/**
 * Parameters for update text area type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateTextAreaCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateTextAreaCustomFieldParams(Object projectIdOrKey, long customFiledId) {
        super(projectIdOrKey, customFiledId);
    }
}
