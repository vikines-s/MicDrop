package interface_adapter.login;

public class LogInState {
    private String username = "";
    private String usernameError = null;
    private String authCode = "";
    private String authCodeError = null;

    public LogInState(LogInState copy) {
            username = copy.username;
            usernameError = copy.usernameError;
            authCode = copy.authCode;
            authCodeError = copy.authCodeError;
    }
    public LogInState() {}
    public String getUsername() {
        return username;
    }
    public String getUsernameError() {
            return usernameError;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }
    public String getAuthCode() { return authCode; }
    public String getAuthCodeError() { return authCodeError; }
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    public void setAuthCodeError(String authCodeError) {
        this.authCodeError = authCodeError;
    }

    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", getAuthCode='" + authCode + '\'' +
                '}';
    }
}
