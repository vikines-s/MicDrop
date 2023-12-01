package use_case.get_auth_code;

import java.net.URI;

public interface GetAuthCodeDataAccessInterface {
    void clearAuthorization();

    URI getAuthorizationCodeURI();
}
