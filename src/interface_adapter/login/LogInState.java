package interface_adapter.login;

public class LogInState {
    private String username = "";
    private String usernameError = null;

        public LogInState(LogInState copy) {
            username = copy.username;
            usernameError = copy.usernameError;
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
}
