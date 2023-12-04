package interface_adapter.logout;

import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInputData;

public class LogOutController {
    final LogOutInputBoundary logOutUseCaseInteractor;

    public LogOutController(LogOutInputBoundary logOutUseCaseInteractor) {
        this.logOutUseCaseInteractor = logOutUseCaseInteractor;
    }
    public void execute(String username) {
        LogOutInputData logOutInputData = new LogOutInputData(username);
        logOutUseCaseInteractor.execute(logOutInputData);
    }
}
