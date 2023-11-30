package use_case.signup;

public interface SignUpOutputBoundary {

    void prepareSuccessView(SignUpOutputData user);

    void prepareFailView(String error);
}
