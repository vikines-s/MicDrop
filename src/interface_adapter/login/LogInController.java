package interface_adapter.login;

import use_case.login.LogInInputBoundary;

public class LogInController {
    final LogInInputBoundary logInUseCaseInteractor;
    public LogInController(LogInInputBoundary logInUseCaseInteractor){
        this.logInUseCaseInteractor = logInUseCaseInteractor;
    }
    public void execute(){}
}
