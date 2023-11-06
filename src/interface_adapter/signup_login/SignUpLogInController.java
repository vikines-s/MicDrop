package interface_adapter.signup_login;

import use_case.signup_login.SignUpLogInInputBoundary;

public class SignUpLogInController {

    final SignUpLogInInputBoundary signUpLogInInteractor;

    public SignUpLogInController(SignUpLogInInputBoundary signUpLogInInteractor) {
        this.signUpLogInInteractor = signUpLogInInteractor;
    }

    public void execute() {
        signUpLogInInteractor.execute();
    }


}
