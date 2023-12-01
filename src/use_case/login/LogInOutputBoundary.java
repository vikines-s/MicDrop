package use_case.login;

public interface LogInOutputBoundary {
    void prepareSuccessView(LogInOutputData user);
    void prepareFailView(String error);
}
