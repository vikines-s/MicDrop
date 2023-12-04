package use_case.login;

public class LogInInputData {
    final private String username;
    final private String authorization;
    public LogInInputData(String username, String authorization) {
        this.username = username;
        this.authorization = authorization;
    }
    public String getUsername() { return this.username; }
    public String getAuthorization() { return this.authorization; }
}
