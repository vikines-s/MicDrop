package use_case.signup;

import entity.User;

public class SignUpOutputData {

    private final User user;
    private boolean signUpFailed;

    public SignUpOutputData(User user, boolean signUpFailed) {
        this.user = user;
        this.signUpFailed = signUpFailed;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isSignUpFailed() {
        return signUpFailed;
    }

}
