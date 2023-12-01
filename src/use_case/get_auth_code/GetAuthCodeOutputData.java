package use_case.get_auth_code;

import java.net.URI;

public class GetAuthCodeOutputData {

    private final URI authorizationCodeUri;

    public GetAuthCodeOutputData(URI authorizationCodeUri) {
        this.authorizationCodeUri = authorizationCodeUri;
    }

    public URI getAuthorizationCodeUri() {
        return this.authorizationCodeUri;
    }
}
