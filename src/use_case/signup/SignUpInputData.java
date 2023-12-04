package use_case.signup;

public class SignUpInputData {

    final private String username;
    final private String authorizationCode;

    public SignUpInputData(String username, String authorizationCode) {
        this.username = username;
        this.authorizationCode = authorizationCode;
    }

    public String getUsername() {
        return username;
    }
    public String getAuthorizationCode() { return this.authorizationCode; }
}

