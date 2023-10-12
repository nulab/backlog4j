package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.http.NameValuePair;

/**
 * Parameters for create user API.
 *
 * @author nulab-inc
 */
public class CreateUserParams extends PostParams {

    public CreateUserParams(String userId, String password,
                            String name, String mailAddress,
                            User.RoleType roleType) {
        parameters.add(new NameValuePair("userId", userId));
        parameters.add(new NameValuePair("password", password));
        parameters.add(new NameValuePair("name", name));
        parameters.add(new NameValuePair("mailAddress", mailAddress));
        parameters.add(new NameValuePair("roleType", String.valueOf(roleType.getIntValue())));
    }
}
