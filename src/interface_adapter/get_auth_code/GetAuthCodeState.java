package interface_adapter.get_auth_code;

import use_case.get_auth_code.GetAuthCodeOutputData;

import java.net.URI;

public class GetAuthCodeState {
    private String success = "false";
    private URI authorizationCodeUri = null;

    public GetAuthCodeState(GetAuthCodeState copy) {
        this.success = copy.success;
    }

    public GetAuthCodeState() {
    }
    public void setSuccess(GetAuthCodeOutputData getAuthCodeOutputData) {
        this.authorizationCodeUri = getAuthCodeOutputData.getAuthorizationCodeUri();
        this.success = "true";
    }

    public String getSuccess() {
        return success;
    }

    public URI getAuthorizationCodeUri() { return this.authorizationCodeUri; }

    @Override
    public String toString() {
        return "GetAuthCodeState{" +
                "success='" + success + '\'' +
                '}';
    }

}
