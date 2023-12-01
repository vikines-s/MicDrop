package interface_adapter.login;

import use_case.login.LogInOutputBoundary;
import use_case.login.LogInOutputData;

public class LogInPresenter implements LogInOutputBoundary {
    public void prepareSuccessView(LogInOutputData user) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
