package sample;

import com.nulabinc.backlog4j.auth.AccessToken;
import com.nulabinc.backlog4j.auth.OAuthAuthorization;
import com.nulabinc.backlog4j.auth.OAuthSupport;
import com.nulabinc.backlog4j.conf.BacklogConfigure;
import com.nulabinc.backlog4j.conf.BacklogDefaultConfigure;
import com.nulabinc.backlog4j.conf.BacklogToolConfigure;

/**
 * @author nulab-inc
 */
public class AuthSample {

    private static final String CALLBACK_URL = "CallBackUrl";
    private static final String CLIENT_ID = "yourAppClientId";
    private static final String CLIENT_SECRET = "yourAppSecretId";

    public static void main(String[] args) {
        AuthSample apiCallSample = new AuthSample();
        String authURL = apiCallSample.getOAuthAuthorizationURL("yourSpaceId", 0);
        System.out.println("authURL=" + authURL);
    }

    private OAuthSupport getOAuthSupport(String spaceKey, int type) {
        try {
            BacklogConfigure configure;
            if (type == 0) {
                configure = new BacklogDefaultConfigure(spaceKey);
            } else {
                configure = new BacklogToolConfigure(spaceKey);
            }

            OAuthSupport authorization = new OAuthAuthorization(configure);
            authorization.setOAuthClientId(CLIENT_ID, CLIENT_SECRET);
            authorization.setOAuthRedirectUrl(CALLBACK_URL);
            return authorization;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getOAuthAuthorizationURL(String spaceKey, int type) {
        return getOAuthSupport(spaceKey, type).getOAuthAuthorizationURL();
    }

    private AccessToken getAccessToken(String spaceKey, int type, String authCode) {
        return getOAuthSupport(spaceKey, type).getOAuthAccessToken(authCode);
    }


}
