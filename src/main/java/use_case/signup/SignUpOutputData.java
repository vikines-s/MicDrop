package use_case.signup;

public class SignUpOutputData {

    private final String username;

    //time made?

    private boolean signUpFailed;

    public SignUpOutputData(String username, boolean signUpFailed) {
        this.username = username;
        this.signUpFailed = signUpFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isSignUpFailed() {
        return signUpFailed;
    }

}
