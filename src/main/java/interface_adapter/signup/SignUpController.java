package interface_adapter.signup;

import use_case.signup.*;

public class SignUpController {

    final SignUpInputBoundary signUpUseCaseInteractor;

    public SignUpController(SignUpInputBoundary signUpUseCaseInteractor) {
        this.signUpUseCaseInteractor = signUpUseCaseInteractor;
    }

    public void execute(String username) {
        SignUpInputData signupInputData = new SignUpInputData(username);
        signUpUseCaseInteractor.execute(signupInputData);
    }
}
