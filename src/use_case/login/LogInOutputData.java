package use_case.login;

public class LogInOutputData {
    private final String username;
    public LogInOutputData(String username) {
        this.username = username;
    }
    public String getUsername() { return this.username; }
}
