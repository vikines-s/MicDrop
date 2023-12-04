package use_case.logout;

public class LogOutOutputData {
    private final String username;

    public LogOutOutputData(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
}
