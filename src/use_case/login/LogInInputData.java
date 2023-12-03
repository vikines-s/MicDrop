package use_case.login;

public class LogInInputData {
    final private String username;
    public LogInInputData(String username) {
        this.username = username;
    }
    public String getUsername() { return this.username; }
}
