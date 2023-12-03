package use_case.logout;

public class LogOutInputData {
    final private String username;

    public LogOutInputData(String username) {
        this.username = username;
    }
    String getUsername() {
        return username;
    }
}
