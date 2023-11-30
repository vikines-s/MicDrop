package interface_adapter.signup;

public class SignUpState {
    private String username = "";
    private String usernameError = null;

    public SignUpState(SignUpState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SignUpState() {}

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