package interface_adapter.login;

import use_case.login.LogInInputBoundary;
import use_case.login.LogInInputData;

public class LogInController {
    final LogInInputBoundary logInUseCaseInteractor;
    public LogInController(LogInInputBoundary logInUseCaseInteractor){
        this.logInUseCaseInteractor = logInUseCaseInteractor;
    }
    public void execute(String username, String authorization){
        LogInInputData logInInputData = new LogInInputData(username, authorization);
        logInUseCaseInteractor.execute(logInInputData);
    }
}
