package interface_adapter.login;

import use_case.login.LogInInputBoundary;

public class LogInController {
    final LogInInputBoundary logInUseCaseInteractor;
    public LogInController(LogInInputBoundary logInUseCaseInteractor){
        this.logInUseCaseInteractor = logInUseCaseInteractor;
    }
    //TODO: implement the execute method
    public void execute(){}
}
