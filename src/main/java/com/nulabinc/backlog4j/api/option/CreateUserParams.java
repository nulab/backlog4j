package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.User;
import org.apache.http.message.BasicNameValuePair;

/**
 * Parameters for create user API.
 *
 * @author nulab-inc
 */
public class CreateUserParams extends PostParams {

    public CreateUserParams(String userId, String password,
                                 String name, String mailAddress,
                                 User.RoleType roleType){
        parameters.add(new BasicNameValuePair("userId", userId));
        parameters.add(new BasicNameValuePair("password", password));
        parameters.add(new BasicNameValuePair("name", name));
        parameters.add(new BasicNameValuePair("mailAddress", mailAddress));
        parameters.add(new BasicNameValuePair("roleType", String.valueOf(roleType.getIntValue())));
    }
}
