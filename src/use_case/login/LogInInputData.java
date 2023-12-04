package use_case.login;

public class LogInInputData {
    private final String username;
    private final String authCode;

    public LogInInputData(String username, String authCode) {
        this.username = username;
        this.authCode = authCode;
    }
    public String getUsername() { return this.username; }
    public String getAuthCode() { return this.authCode; }
}
