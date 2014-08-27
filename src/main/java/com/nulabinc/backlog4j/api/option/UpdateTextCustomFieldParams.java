package com.nulabinc.backlog4j.api.option;

/**
 * Parameters for update text type custom field API.
 *
 * @author nulab-inc
 */
public class UpdateTextCustomFieldParams extends UpdateCustomFieldParams {

    public UpdateTextCustomFieldParams(long projectId, long customFiledId) {
        super(projectId, customFiledId);
    }

    public UpdateTextCustomFieldParams(String projectKey, long customFiledId) {
        super(projectKey, customFiledId);
    }
}
